package com.cj.concurrent.thread;

public class ThreadStart2Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        System.out.println("第一次启动");
        thread.start();
    }
}
