package com.cj.concurrent.collection.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        // 1. 创建一个容量为 5 的阻塞队列
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(5);
        // 2. 生产者新增
        new Thread(new Producer(blockingQueue)).start();
        // 3. 消费者消费
        new Thread(new Consumer(blockingQueue)).start();
    }
    static class Producer implements Runnable {
        BlockingQueue<Object> blockingQueue;
        public Producer(BlockingQueue<Object> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    Object item = new Object();
                    System.out.println(Thread.currentThread().getName() + "生产者已生产元素：" + item);
                    blockingQueue.put(item);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer implements Runnable {
        BlockingQueue<Object> blockingQueue;
        public Consumer(BlockingQueue<Object> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "消费者已消费元素：" + blockingQueue.take() + ", 还剩: "  + blockingQueue.size());
                    Thread.sleep(1500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//Thread-0生产者已生产元素：java.lang.Object@3d0bb382
//Thread-1消费者已消费元素：java.lang.Object@3d0bb382, 还剩: 0
//...
//Thread-0生产者已生产元素：java.lang.Object@5d296f7e
//Thread-1消费者已消费元素：java.lang.Object@2feb52ca, 还剩: 4
//...


