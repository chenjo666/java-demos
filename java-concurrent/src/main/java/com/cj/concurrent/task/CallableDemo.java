package com.cj.concurrent.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = () -> {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            return new Object();
        };
        FutureTask<Object> task = new FutureTask<>(callable);
        new Thread(task).start();
        new Thread(task).start();

        System.out.println("main 1");
        task.get();
        System.out.println("main 2");
        task.get();
        System.out.println("main 3");
    }
}
