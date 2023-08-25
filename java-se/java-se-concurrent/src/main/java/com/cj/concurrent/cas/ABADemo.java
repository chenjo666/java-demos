package com.cj.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        // 线程 t1 使用 cas 并且把 1 改成 2，再改回来
        new Thread(() -> {
            System.out.println("t1: " + atomicInteger.compareAndSet(1, 2));
            System.out.println("t1: " + atomicInteger.compareAndSet(2, 1));
        }, "t1").start();

        // 线程 t2 使用 cas 把 1 改成 3
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2: " + atomicInteger.compareAndSet(1, 3));
        }, "t2").start();

        // 中间状态存在未知性。
    }
}
