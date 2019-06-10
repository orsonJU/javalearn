package org.orson.thread.pattern.workerthread;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WorkerThreadPattern {

    public static void main(String[] args) {
        WorkerResource resource = new WorkerResource();

        new Thread(new ClientThread(resource), "client thread").start();
    }

}


class WorkerResource {

    Queue<Integer> queue = new LinkedList<>();


    WorkerThread[] wts = new WorkerThread[3];


    public WorkerResource() {
        for(int i = 0; i < wts.length; i++) {
            wts[i] = new WorkerThread(queue);
            new Thread(wts[i], "worker-thread-" + i).start();
        }

    }

    public void raise(Integer task) {

        synchronized (this.queue) {
            this.queue.add(task);
            this.queue.notify();
        }
    }
}



class ClientThread implements Runnable {

    WorkerResource resource;

    Random random = new Random();

    public ClientThread(WorkerResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {

            int in = random.nextInt();
            String name = Thread.currentThread().getName();
            System.out.println(name + " is adding task " + in);
            try {
                TimeUnit.SECONDS.sleep(1);
                this.resource.raise(in);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " added task " + in);


        }
    }
}

class WorkerThread implements Runnable {

    Queue<Integer> queue;

    public WorkerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for(;;) {
            String name = Thread.currentThread().getName();

            synchronized (this.queue) {

                while(this.queue.peek() == null) {
                    System.out.println(name + " is waiting for task");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) { ;
                    }
                }
                Integer task = this.queue.poll();
                System.out.println(name + " get task " + task);
            }
        }
    }
}
