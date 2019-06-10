package org.orson.thread.synchron;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.TimeUnit;

public class WaitAndNotify {


    public static void main(String[] args) throws InterruptedException {


        Increment increment = new Increment();


        Thread th1 = new Thread(new WaitAndNotifyThread(increment), "thread - 1");
        Thread th2 = new Thread(new WaitAndNotifyThread(increment), "thread - 2");

        th1.start();
        th2.start();

        th1.join();
        th2.join();


    }


}
class Increment {
    public Integer count = 0;

    public void icr() throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + " get lock and doing increment");
        TimeUnit.SECONDS.sleep(1);
        this.count++;
        this.show();
    }

    public void show() {
        System.out.println(count);
    }
}

class WaitAndNotifyThread implements Runnable {

    Increment increment;

    public WaitAndNotifyThread(Increment increment) {
        this.increment = increment;
    }

    @Override
    public void run() {

        synchronized (increment) {

            while (increment.count <= 10) {
                try {
                    increment.icr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    increment.notifyAll();
                    increment.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
            increment.notifyAll();
            System.out.println("ended..");
        }
    }
}
