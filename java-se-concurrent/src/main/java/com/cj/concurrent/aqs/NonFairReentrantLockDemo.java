package com.cj.concurrent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NonFairReentrantLockDemo {
    // 非公平锁
    private static ReentrantLock lock = new ReentrantLock(false);
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " is trying to acquire the lock.");
            lock.lock();
            try {
                System.out.println(threadName + " has acquired the lock.");
                // 假设执行一些需要互斥保护的操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(threadName + " has released the lock.");
            }
        };

        // 创建多个线程并启动，模拟线程 2 先进行创建获取锁，线程 3 后进行创建获取锁
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
//Thread 1 is trying to acquire the lock.
//Thread 3 is trying to acquire the lock.
//Thread 2 is trying to acquire the lock.
//Thread 1 has acquired the lock.
//Thread 1 has released the lock.
//Thread 2 has acquired the lock.
//Thread 2 has released the lock.
//Thread 3 has acquired the lock.
//Thread 3 has released the lock.