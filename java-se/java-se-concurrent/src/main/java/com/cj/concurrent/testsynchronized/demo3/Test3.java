package com.cj.concurrent.testsynchronized.demo3;

public class Test3 {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        new Thread(() -> clazz.print()).start();
        new Thread(() -> clazz.print()).start();
    }
}
class Clazz {
    public void print() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i:" + i);
        }
        synchronized (this) {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + " j:" + j);
            }
        }
    }
}
//Thread-0 i:0      i 是并行运行的，因为该区域无锁
//Thread-0 i:1
//Thread-1 i:0
//Thread-0 i:2
//Thread-0 i:3
//Thread-1 i:1
//...               j 是一定 Thread-0 先执行完后 Thread-1 再执行，因为该代码块上锁了
//Thread-1 j:97
//Thread-1 j:98
//Thread-1 j:99

