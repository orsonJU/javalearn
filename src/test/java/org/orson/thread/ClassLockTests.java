package org.orson.thread;

import org.junit.Test;
import org.orson.thread.synchron.ClassLock;
import org.orson.thread.synchron.ClassLockThread;

public class ClassLockTests {



    @Test
    public void race_condition_with_class_lock() throws InterruptedException {
        ClassLock cl = new ClassLock();
        // th1 & th2 竞争类锁，th3竞争实例锁
        ClassLockThread th1 = new ClassLockThread(cl, "1");
        ClassLockThread th2 = new ClassLockThread(cl, "2");
        ClassLockThread th3 = new ClassLockThread(cl, "3");
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        Thread t3 = new Thread(th3);

        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();


    }
}
