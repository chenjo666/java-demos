package com.cj.concurrent.thread.thread;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int cnt = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello, thread: " + ++cnt);
            }
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
