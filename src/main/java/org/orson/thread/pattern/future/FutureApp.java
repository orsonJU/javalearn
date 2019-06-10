package org.orson.thread.pattern.future;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureApp {

    public static void main(String[] args) {


        FutureResource resource = new FutureResource();
        FutureData fd = resource.raise(10);

        int content = fd.getContent();
        System.out.println("received content: " + content);


        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {


                TimeUnit.SECONDS.sleep(3);
                return 10;
            }
        });

        new Thread(ft).start();

        Integer integer = null;
        try {
            integer = ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("future: " + integer);

    }

}

class FutureData {

    private Map<String, Object> result;

    public FutureData(Map<String, Object> result) {
        this.result = result;
    }

    public int getContent() {

        synchronized (this) {

            while(result.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }

            return (int) result.get("data");
        }
    }
}


class FutureResource {



    public FutureData raise(final int size) {


        final Map<String, Object> result = new HashMap<>();
        FutureData fd = new FutureData(result);

        new Thread(new Runnable() {
            @Override
            public void run() {


                int sum = 0;
                int offset = size;
                while(offset > 0) {
                    sum += offset;
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("count sum: " + sum);
                    offset--;
                }

                synchronized (fd) {
                    try {
                        result.put("data", sum);
                    }finally {
                        fd.notifyAll();
                    }
                }

            }
        }).start();

        return fd;

    }
}



