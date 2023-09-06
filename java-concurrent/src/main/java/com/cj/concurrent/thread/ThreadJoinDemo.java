package com.cj.concurrent.thread;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread run...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        // 抢占，让 main 线程暂停运行
        thread.join();

        System.out.println(System.currentTimeMillis() + "main run...");
    }
}
