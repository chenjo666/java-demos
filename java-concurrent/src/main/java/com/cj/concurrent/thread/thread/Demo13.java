package com.cj.concurrent.thread.thread;

public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Worker()).start();
    }
    static class Worker implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
