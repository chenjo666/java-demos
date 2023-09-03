package com.cj.concurrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionObjectDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition producerCondition = lock.newCondition();
    private static Condition consumerCondition = lock.newCondition();
    private static int itemCount = 0;
    private static final int MAX_ITEMS = 10;

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true)
                produce();
        }
        public void produce() {
            try {
                lock.lock();
                while (itemCount == MAX_ITEMS) {
                    // 缓冲区满了，等待消费者消费物品
                    producerCondition.await();
                }
                // 生产物品
                itemCount++;
                System.out.println("Producer produced an item. Total items: " + itemCount);
                // 通知消费者可以消费物品了
                consumerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true)
                consume();
        }
        public void consume() {
            try {
                lock.lock();
                while (itemCount == 0) {
                    // 缓冲区为空，等待生产者生产物品
                    consumerCondition.await();
                }
                // 消费物品
                itemCount--;
                System.out.println("Consumer consumed an item. Total items: " + itemCount);
                // 通知生产者可以继续生产物品了
                producerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }
}