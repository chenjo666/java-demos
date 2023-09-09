package com.cj.concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
    // 定义两把锁
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadLockDemo deadLock = new DeadLockDemo();

        new Thread(() -> deadLock.methodA()).start();
        new Thread(() -> deadLock.methodB()).start();
    }
    public static void methodA() {
        try {
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + ": lock1申请成功，等待1秒后申请lock2");
            Thread.sleep(1000);
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + ": lock2申请成功，将释放lock2和lock1");
            lock2.unlock();
            System.out.println(Thread.currentThread().getName() + ": lock2释放成功");
            lock1.unlock();
            System.out.println(Thread.currentThread().getName() + ": lock1释放成功");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // 先获取lock2，再获取lock1
    public static void methodB() {
        try {
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + ": lock2申请成功，等待1秒后申请lock1");
            Thread.sleep(1000);
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + ": lock1申请成功，将释放lock1和lock2");
            lock1.unlock();
            System.out.println(Thread.currentThread().getName() + ": lock1释放成功");
            lock2.unlock();
            System.out.println(Thread.currentThread().getName() + ": lock2释放成功");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
