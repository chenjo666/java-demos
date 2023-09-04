package com.cj.concurrent.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int workerCount = 3;

        // 创建 CyclicBarrier，指定参与的线程数量和达到屏障时的回调操作
        CyclicBarrier barrier = new CyclicBarrier(workerCount, () -> {
            System.out.println("所有工作线程已到达屏障，执行屏障操作");
            // 屏障操作，当所有线程都达到屏障后会执行
        });

        // 创建并启动多个工作线程
        for (int i = 0; i < workerCount; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final int id;

        public Worker(CyclicBarrier barrier, int id) {
            this.barrier = barrier;
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

            System.out.println("Worker " + id + " 工作完成，等待其他工作线程");

            // 等待其他工作线程，达到屏障点
            try {
                barrier.await();

                System.out.println("Worker " + id + " 继续执行后续操作");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
//Worker 2 开始工作...
//Worker 0 开始工作...
//Worker 1 开始工作...
//Worker 2 工作完成，等待其他工作线程
//Worker 0 工作完成，等待其他工作线程
//Worker 1 工作完成，等待其他工作线程
//所有工作线程已到达屏障，执行屏障操作
//Worker 1 继续执行后续操作
//Worker 0 继续执行后续操作
//Worker 2 继续执行后续操作
