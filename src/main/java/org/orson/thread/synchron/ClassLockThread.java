package org.orson.thread.synchron;

public class ClassLockThread implements Runnable{
    ClassLock cl;

    String method;

    public ClassLockThread(ClassLock cl, String method) {
        this.cl = cl;
        this.method = method;
    }

    @Override
    public void run() {
        if("2".equals(method)) {
            try {
                cl.update("synchronized_block");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if("1".equals(method)){
            try {
                ClassLock.staticUpdate("static_method");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                cl.instanceUpdate("instance_method");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
