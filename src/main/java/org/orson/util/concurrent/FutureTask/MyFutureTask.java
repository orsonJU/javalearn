package org.orson.util.concurrent.FutureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class MyFutureTask<V> implements RunnableFuture<V> {


    Callable<V> callable;

    V data;

    boolean done = false;


    volatile  List<WaitNode> waiters = new ArrayList<>();

    public MyFutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            // call方法需要等待计算返回结果
            V data = callable.call();
            this.data = data;
            this.done = true;


            synchronized (this.waiters) {
                this.waiters.forEach(node -> {
                    // 唤醒调用get方法的线程
                    LockSupport.unpark(node.thread);
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        System.out.println("waiting for the result");
        // 获取调用get方法的线程
//        this.thread = Thread.currentThread();


        WaitNode node = new WaitNode();
        // 如果没有被中断，则不断尝试获取data
        while(!isDone()) {


            synchronized (this.waiters) {
                this.waiters.add(node);
            }

            // 把调用get方法的线程悬挂起来
            LockSupport.park();
        }
        System.out.println("get result");
        return this.data;
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }


    /**
     *
     */
    static final class WaitNode {
        volatile Thread thread;
        volatile WaitNode next;

        public WaitNode() {
            thread = Thread.currentThread();
        }
    }
}
