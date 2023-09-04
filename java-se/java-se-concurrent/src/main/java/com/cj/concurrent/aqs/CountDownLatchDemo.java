package com.cj.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo{

    public static void main(String[] args) throws InterruptedException {
        int workerCount = 5;
        CountDownLatch latch = new CountDownLatch(workerCount);

        // 创建并启动多个工作线程
        for (int i = 0; i < workerCount - 1; i++) {
            new Thread(new Worker(latch, i)).start();
        }

        // 主线程等待所有工作线程完成
        latch.await();

        System.out.println("所有工作线程已完成");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;
        private final int id;

        public Worker(CountDownLatch latch, int id) {
            this.latch = latch;
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " 开始工作...");

            // 模拟工作过程
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker " + id + " 工作完成");

            // 工作完成后递减 CountDownLatch 的计数器
            latch.countDown();
        }
    }
}

