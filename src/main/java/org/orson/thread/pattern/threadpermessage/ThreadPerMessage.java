package org.orson.thread.pattern.threadpermessage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadPerMessage {

    public static void main(String[] args) {
        ThreadPerMessageResource resource = new ThreadPerMessageResource();


        new Thread(new ClientThread(resource)).start();

    }
}



class ThreadPerMessageResource {


    public void request(int nextInt) {

        String master = Thread.currentThread().getName();
        System.out.println(master + " add task " + nextInt);

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is doing task " + nextInt);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is completd task" + nextInt);
        }).start();

        System.out.println(master + " out ");
    }
}




class ClientThread implements Runnable {
    ThreadPerMessageResource resource;

    Random random = new Random();

    public ClientThread(ThreadPerMessageResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(;;) {
            resource.request(random.nextInt());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
