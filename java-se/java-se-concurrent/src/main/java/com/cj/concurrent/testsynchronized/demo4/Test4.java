package com.cj.concurrent.testsynchronized.demo4;

public class Test4 {
    public static void main(String[] args) {
        Clazz clazz1 = new Clazz();
        Clazz clazz2 = new Clazz();
        new Thread(clazz1::print).start();
        new Thread(clazz2::print).start();
    }
}
class Clazz {
    public void print() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i:" + i);
        }
        synchronized (Clazz.class) {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + " j:" + j);
            }
        }
    }
}
//...               i 是并发运行的
//...               j 是一定 Thread-0 先执行完后 Thread-1 再执行，因为该类代码块上锁了
//Thread-1 j:97
//Thread-1 j:98
//Thread-1 j:99

