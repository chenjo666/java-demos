package com.cj.concurrent.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Object call = task.call();
        System.out.println(call);
    }

    static class Task implements Callable {

        @Override
        public Object call() throws Exception {
            Thread.sleep(5000);

            System.out.println("ok");
            return new Object();
        }
    }
}
