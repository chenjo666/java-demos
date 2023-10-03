package com.cj.concurrent.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static int counter = 0;

    public static void main(String[] args) {
        // 创建多个线程进行读写操作
        Thread writer1 = new Thread(new Writer());
        Thread writer2 = new Thread(new Writer());
        Thread reader1 = new Thread(new Reader());
        Thread reader2 = new Thread(new Reader());

        writer1.start();
        reader1.start();
        writer2.start();
        reader2.start();
    }

    static class Reader implements Runnable {
        public void run() {
            lock.readLock().lock(); // 获取读锁
            try {
                System.out.println("Reader starts reading. Counter: " + counter);
                // 模拟读取数据的操作
                Thread.sleep(1000);
                System.out.println("Reader finishes reading.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock(); // 释放读锁
            }
        }
    }

    static class Writer implements Runnable {
        public void run() {
            lock.writeLock().lock(); // 获取写锁
            try {
                System.out.println("Writer starts writing. Counter: " + counter);
                // 模拟写入数据的操作
                counter++;
                Thread.sleep(1000);
                System.out.println("Writer finishes writing. Counter: " + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock(); // 释放写锁
            }
        }
    }
}
