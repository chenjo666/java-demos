package com.cj.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InheritableThreadLocalDemo002 {
    private static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        threadLocal.set(1);
        System.out.println("父线程获取数据：" + threadLocal.get());
        executorService.submit(() -> {
            System.out.println("第一次从线程池中获取数据：" + threadLocal.get());
        });
        Thread.sleep(500);
        threadLocal.set(2);
        System.out.println("父线程获取数据：" + threadLocal.get());
        executorService.submit(() -> {
            System.out.println("第一次从线程池中获取数据：" + threadLocal.get());
        });
    }
}
