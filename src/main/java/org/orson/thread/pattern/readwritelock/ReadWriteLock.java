package org.orson.thread.pattern.readwritelock;

import sun.util.locale.provider.TimeZoneNameUtility;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    public static void main(String[] args) {

        ReadWriteLockResource resource = new ReadWriteLockResource("default");

        new Thread(new WriteThread(resource)).start();

        for(int i = 0; i < 4; i++) {
            new  Thread(new ReadThread("palce" + i, resource), "place-thread-" + i).start();
        }


    }
}


class ReadWriteLockResource {

    private String palce;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ReadWriteLockResource(String palce) {
        this.palce = palce;
    }


    public void swith(String palce) {

        try{
            lock.writeLock().lock();

            String name = Thread.currentThread().getName();
            System.out.println(name + " is setting place: " + palce);
            this.palce = palce;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " set place: " + this.palce);
        }finally {
            lock.writeLock().unlock();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dispaly() {

        try{
            lock.readLock().lock();

            String name = Thread.currentThread().getName();
            System.out.println(name + " is reading palce: " + this.palce);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " read place: " + this.palce);
        }finally {
            lock.readLock().unlock();
        }

    }
}

class WriteThread implements Runnable {

    ReadWriteLockResource resource;

    public WriteThread(ReadWriteLockResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {
            resource.swith(String.valueOf(System.currentTimeMillis()));
        }
    }
}


class ReadThread implements Runnable {

    String place;

    ReadWriteLockResource resource;

    public ReadThread(String place, ReadWriteLockResource resource) {
        this.place = place;
        this.resource = resource;
    }

    @Override
    public void run() {

        for(;;) {
            resource.dispaly();
        }
    }
}
