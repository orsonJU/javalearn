package org.orson.thread;


import org.junit.Test;
import org.orson.thread.interrupt.JoinThread;
import org.orson.thread.interrupt.LoopThread;

public class AppTest {


    @Test
    public void test_loopThread() {

        Thread thread = new Thread(new LoopThread());
        thread.start();

        // sleep a while
        try {
            Thread.sleep(100);
            thread.interrupt();
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_joinThread() {

        Thread thread = new Thread(new JoinThread());

        thread.start();

        try {
            // wait for JoinThread to be ended.
            thread.join();
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }

        System.out.println("Main ran");
        // main ended, so join thread ended
    }
}
