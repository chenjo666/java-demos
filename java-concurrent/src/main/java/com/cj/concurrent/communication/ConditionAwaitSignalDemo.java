package com.cj.concurrent.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionAwaitSignalDemo {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean s = false;
    int num = 1;
    public void printOdd() {
        try {
            lock.lock();
            if (s) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + (num++));
            s = true;
            condition.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printEven() {
        try {
            lock.lock();
            if (!s) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + (num++));
            s = false;
            condition.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ConditionAwaitSignalDemo demo = new ConditionAwaitSignalDemo();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                demo.printOdd();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                demo.printEven();
            }
        }).start();
    }
}
//Thread-0: 1
//Thread-1: 2
//Thread-0: 3
//Thread-1: 4
//...