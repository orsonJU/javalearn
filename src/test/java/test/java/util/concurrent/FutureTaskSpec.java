package test.java.util.concurrent;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.orson.util.concurrent.FutureTask.MyFutureTask;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FutureTaskSpec {


    @Test
    public void should_block_while_call_get_method() throws Exception {
        
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "Orson";
            }
        };


        MyFutureTask<String> ft = new MyFutureTask<>(callable);
        Thread thread = new Thread(ft);
        thread.start();



        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    ft.get();
                    System.out.println(Thread.currentThread().getName() + " is ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }, "future thread " + i).start();
        }

        Assertions.assertThat(ft.get()).hasToString("Orson");


        System.out.println("done");

    }
}
