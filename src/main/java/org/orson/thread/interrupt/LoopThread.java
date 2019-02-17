package org.orson.thread.interrupt;

/**
 * This aims to test the Thread.interrupt() function.
 *
 * Assumption:
 * 1) if a thread in a loop while, then Thread.interrupt() wont cause {@java.lang.InterruptedException}
 */
public class LoopThread implements  Runnable {

    @Override
    public void run() {

        while(!Thread.interrupted()) {
            // dead loop and wait for interruption
            System.out.println("I'm looping...");
        }

        System.out.println("I'm dead now...");
    }
}
