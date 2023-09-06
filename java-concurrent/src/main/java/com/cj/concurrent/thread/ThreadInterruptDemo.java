package com.cj.concurrent.thread;

public class ThreadInterruptDemo {
    public static void main(String[] args) {
        // 创建一个线程
        Thread myThread = new Thread(() -> {
            while (true) {
                System.out.println("线程正在运行...");

                try {
                    // 线程休眠0.5秒钟
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // 捕获到InterruptedException异常，表示线程被中断
                    System.out.println("线程被中断...");
                    // 可以选择在这里处理中断逻辑
                    Thread.currentThread().interrupt();
                }
            }
//            System.out.println("线程已经停止...");
        });

        // 启动线程
        myThread.start();

        try {
            // 主线程休眠1秒钟
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程
        myThread.interrupt();
    }
}
