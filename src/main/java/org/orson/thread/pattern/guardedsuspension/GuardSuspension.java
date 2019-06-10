package org.orson.thread.pattern.guardedsuspension;

import javax.management.relation.RoleUnresolved;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GuardSuspension {


    public static void main(String[] args) {

        GuardResource resource = new GuardResource();

        GuardPutThread putThread = new GuardPutThread(resource);
        new Thread(putThread).start();

        for(int i = 0; i < 4; i++) {
            new Thread(new GuardGetThread(resource)).start();
        }
    }
}



class GuardResource {

    Queue<Integer> queue = new LinkedList<>();


    public void put(Integer in) {
        String name = Thread.currentThread().getName();

        synchronized(queue) {
            System.out.println(name + " putting " + in + " in queue.");
            queue.add(in);
            System.out.println(name + " put " + in + " in queue.");
            queue.notifyAll();
        }
    }

    public Integer get() {
        String name = Thread.currentThread().getName();
        synchronized (queue) {
            while(queue.peek() == null) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer out = queue.poll();
            System.out.println(name + " get " + out + " from queue.");
            return out;
        }
    }

}


class GuardPutThread implements Runnable {

    GuardResource resource;

    Random random = new Random();

    public GuardPutThread(GuardResource resource) {
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

class GuardGetThread implements Runnable {

    GuardResource resource;

    public GuardGetThread(GuardResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {
            Integer out = resource.get();
        }
    }
}
