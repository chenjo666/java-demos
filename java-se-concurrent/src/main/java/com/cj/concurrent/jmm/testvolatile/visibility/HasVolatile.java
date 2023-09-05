package com.cj.concurrent.jmm.testvolatile.visibility;

public class HasVolatile {
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {}
            System.out.println("t1 over");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            flag = false;
            System.out.println("t2 over");
        }).start();
    }
}
