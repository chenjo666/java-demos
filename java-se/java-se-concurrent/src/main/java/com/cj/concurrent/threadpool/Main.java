package com.cj.concurrent.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
    }
}
