package com.cj.concurrent.thread;


public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread.sleep(5000);           // 暂停当前主线程 main 5s

        System.out.println(Thread.currentThread().getName());
    }
}
