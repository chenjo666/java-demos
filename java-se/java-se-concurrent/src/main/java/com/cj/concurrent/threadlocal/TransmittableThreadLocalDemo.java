package com.cj.concurrent.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalDemo {
    static TransmittableThreadLocal<Integer> threadLocal = new TransmittableThreadLocal<>();
    public static void main(String[] args) {
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(Executors.newSingleThreadExecutor());

        threadLocal.set(1);
        System.out.println("父线程获取数据：" + threadLocal.get());
        ttlExecutorService.submit(() -> {
            System.out.println("第一次从线程池中获取数据：" + threadLocal.get());
        });


        threadLocal.set(2);
        System.out.println("父线程获取数据：" + threadLocal.get());
        ttlExecutorService.submit(() -> {
            System.out.println("第二次从线程池中获取数据：" + threadLocal.get());
        });
    }
}
//父线程获取数据：1
//父线程获取数据：2
//第一次从线程池中获取数据：1
//第二次从线程池中获取数据：2