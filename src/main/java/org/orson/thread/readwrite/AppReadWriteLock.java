package org.orson.thread.readwrite;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AppReadWriteLock {


    public static void main(String[] args) {


        CyclicBarrier cb = new CyclicBarrier(10);

        ReadWriteStore store = new ReadWriteStore();

        for(int i = 0; i < 9; i++) {
            Thread thread = new Thread(new ReadStore(store, cb));
            thread.start();


        }

        Thread thread1 = new Thread(new WriteStore(store, cb));
        thread1.start();


    }
}


class ReadStore implements Runnable {
    ReadWriteStore store;

    CyclicBarrier cb;

    public ReadStore(ReadWriteStore store, CyclicBarrier cb) {
        this.store = store;
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        this.store.get();
    }
}

class WriteStore implements Runnable {
    ReadWriteStore store;

    CyclicBarrier cb;

    public WriteStore(ReadWriteStore store, CyclicBarrier cb) {
        this.store = store;
        this.cb = cb;
    }

    @Override
    public void run() {

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        this.store.put();
    }
}

class ReadWriteStore {


    ReadWriteLock lock = new ReentrantReadWriteLock();



    public void get() {
        String name = Thread.currentThread().getName();
        lock.readLock().lock();
        System.out.println(name + " get read lock");

        System.out.println(name + " is reading");
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e) {
            e.printStackTrace();
        }

        lock.readLock().unlock();
        System.out.println(name + " release read lock");

    }


    public void put() {
        String name = Thread.currentThread().getName();
        lock.writeLock().lock();

        System.out.println(name + " get write lock");
        System.out.println(name + " is writing");

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
        System.out.println(name + " release write lock");
    }

}