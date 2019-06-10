package org.orson.thread.tool;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreApp {


    public static void main(String[] args) {

        Patient patient = new Patient(3);

        for(int i = 0; i < 10; i++) {
            new Thread(new Customer(patient)).start();
        }
    }


}

class Patient {

    Semaphore semaphore;

    public Patient(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }


    public void shower() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is taking shower");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + " is left");
            semaphore.release();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Customer implements  Runnable {

    Patient patient;

    public Customer(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void run() {

        for(;;) {
            this.patient.shower();
        }
    }
}
