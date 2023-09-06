package com.cj.concurrent.thread.thread;


public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello, Thread");
        });
        thread.start();
        System.out.println("hello, main");
        Thread.sleep(1000);
    }
}
