package com.cj.concurrent.thread.thread;

class MyThread  extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread run...");
    }
}

public class demo1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
