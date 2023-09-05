package com.cj.concurrent.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("myThread run...");
        return 1;
    }
}

public class demo3 {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
