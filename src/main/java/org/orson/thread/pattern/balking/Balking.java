package org.orson.thread.pattern.balking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Balking {

    public static void main(String[] args) {
        BalkingResource resource = new BalkingResource();

        new Thread(new BalkingPutThread(resource)).start();


        for(int i = 0; i < 4; i++) {
            new Thread(new BalkingGetThread(resource)).start();
        }
    }
}



class BalkingResource {

    Queue<Integer> queue = new LinkedList<>();


    public void put(Integer in) {
        String name = Thread.currentThread().getName();

        synchronized(queue) {
            System.out.println(name + " putting " + in + " in queue.");
            queue.add(in);
            System.out.println(name + " put " + in + " in queue.");
            queue.notifyAll();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer get() {
        String name = Thread.currentThread().getName();
        synchronized (queue) {
            if(queue.peek() == null) {
                System.out.println(name + " get -1 from queue.");
                return -1;
            }
            Integer out = queue.poll();
            System.out.println(name + " get " + out + " from queue.");
            return out;
        }
    }

}


class BalkingPutThread implements Runnable {

    BalkingResource resource;

    Random random = new Random();

    public BalkingPutThread(BalkingResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.put(random.nextInt());
        }
    }
}

class BalkingGetThread implements Runnable {

    BalkingResource resource;

    public BalkingGetThread(BalkingResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {
            resource.get();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}