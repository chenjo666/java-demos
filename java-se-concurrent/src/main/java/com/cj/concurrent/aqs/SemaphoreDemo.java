package com.cj.concurrent.aqs;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        // 创建 Semaphore 对象，初始值为3
        Semaphore semaphore = new Semaphore(3);

        // 创建5个工作线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Worker(semaphore, i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;
        private final int id;

        public Worker(Semaphore semaphore, int id) {
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " 正在尝试获取 Semaphore...");
            try {
                // 请求获取 Semaphore，如果已满则阻塞等待
                semaphore.acquire();
                System.out.println("Worker " + id + " 成功获取 Semaphore，开始工作...");

                // 模拟工作过程
                Thread.sleep(2000);

                System.out.println("Worker " + id + " 工作完成，释放 Semaphore");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放 Semaphore
                semaphore.release();
            }
        }
    }
}
