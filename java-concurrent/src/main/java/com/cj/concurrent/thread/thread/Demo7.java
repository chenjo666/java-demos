package com.cj.concurrent.thread.thread;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread is done.");
        });
        System.out.println("Before starting, is thread alive? " + thread.isAlive());
        thread.start();
        System.out.println("After starting, is thread alive? " + thread.isAlive());
        Thread.sleep(1000); // 主线程等待一秒
        System.out.println("After 1 second, is thread alive? " + thread.isAlive());
        thread.join();  // 子线程加入
        System.out.println("After joining, is thread alive? " + thread.isAlive());
    }
}
//Before starting, is thread alive? false
//After starting, is thread alive? true
//Thread is running.
//After 1 second, is thread alive? true
//Thread is done.
//After joining, is thread alive? false