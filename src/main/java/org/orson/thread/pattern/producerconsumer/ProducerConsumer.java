package org.orson.thread.pattern.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Guard Suspension模式基本用于实现Producer-Consumer模式
 */
public class ProducerConsumer {
}



class QueueResource {

    Queue<Integer> queue = new LinkedList<>();


    public void produce(Integer in) {

    }


    public Integer consum() {
        return -1;
    }

}


class ProducerThread implements Runnable {

    QueueResource resource;

    public ProducerThread(QueueResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

    }
}


class ConsumerThread implements Runnable {

    QueueResource resource;

    public ConsumerThread(QueueResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

    }
}
