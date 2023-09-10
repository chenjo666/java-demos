package com.cj.concurrent.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CircularPrintABC {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Worker worker = new Worker(cyclicBarrier);
        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();
    }
    static class Worker implements Runnable {
        private final CyclicBarrier cyclicBarrier;
        private int number = 0;
        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            for (;;) {
                try {
                    synchronized (this) {
                        System.out.println((char)((number++) % 3 + 'A'));
                    }
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
