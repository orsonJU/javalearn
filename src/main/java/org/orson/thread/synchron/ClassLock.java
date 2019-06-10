package org.orson.thread.synchron;

import java.util.concurrent.TimeUnit;

public class ClassLock {

    public static String NAME = "";

    public static synchronized void staticUpdate(String name) throws InterruptedException {
        String thName = Thread.currentThread().getName();
        System.out.println(thName + " is trying to update variable name");
        TimeUnit.SECONDS.sleep(5);
        NAME = name;
        System.out.println(thName + " is completed update variable name");
    }

    public void update(String name) throws InterruptedException {
        String thName = Thread.currentThread().getName();
        synchronized (ClassLock.class) {
            System.out.println(thName + " is trying to update variable name <-- class block");
            TimeUnit.SECONDS.sleep(5);
            NAME = name;
            System.out.println(thName + " is completed update variable name <-- class block");
        }
    }


    public void instanceUpdate(String name) throws InterruptedException {
        String thName = Thread.currentThread().getName();
        synchronized (this) {
            System.out.println(thName + " is trying to update variable name <-- instance");
            TimeUnit.SECONDS.sleep(5);
            NAME = name;
            System.out.println(thName + " is completed update variable name <-- instance");
        }
    }
}
