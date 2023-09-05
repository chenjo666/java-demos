package com.cj.concurrent.jmm.visibility;

public class NotVisible {
    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {

            }
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            flag = false;
        }).start();
    }
}
