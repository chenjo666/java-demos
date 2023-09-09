package com.cj.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5000; i++)
            new Thread(() -> atomicInteger.getAndIncrement()).start();

        // 等待跑完
        Thread.sleep(200);
        System.out.println(atomicInteger.get());
    }
}
