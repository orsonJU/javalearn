package org.orson.thread.interrupt;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Method Thread.join()
 */
public class JoinThread implements  Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try{
                Thread.sleep(1000);
                System.out.println(i);
            }catch(InterruptedException e ) {
                e.printStackTrace();
            }

        }

    }
}
