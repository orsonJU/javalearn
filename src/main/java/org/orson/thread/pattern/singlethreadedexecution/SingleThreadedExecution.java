package org.orson.thread.pattern.singlethreadedexecution;

import java.util.concurrent.TimeUnit;

/**
 * 每次只能有一个线程读取/修改共享资源
 */
public class SingleThreadedExecution {


    public static void main(String[] args) throws InterruptedException {

        SingleThreadedResource resource = new SingleThreadedResource();
        /*
            多个线程对count进行累加, 每次只有一个线程修改共享资源
         */
        for(int i = 0; i < 10; i++) {
            new Thread(new SingleThreadedApp(resource)).start();
        }

        while(true) {
            resource.display();
            TimeUnit.MILLISECONDS.sleep(5);
        }

    }
}


class SingleThreadedResource {

    public Integer count = 0;


    public void icr() {
        synchronized (this) {
            this.count++;
        }
//        this.display();
    }


    public void display() {
        System.out.println(this.count);
    }

}


class SingleThreadedApp implements Runnable {

    SingleThreadedResource resource;

    public SingleThreadedApp(SingleThreadedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i< 3; i ++) {
            resource.icr();
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
