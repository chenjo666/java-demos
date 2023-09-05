package com.cj.concurrent.testsynchronized.demo1;

public class Test1 {
    public static void main(String[] args) {
        Clazz clazz1 = new Clazz();
        Clazz clazz2 = new Clazz();
        new Thread(() -> clazz1.print()).start();
        new Thread(() -> clazz2.print()).start();
    }
}

class Clazz {
    public static synchronized void print() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
//Thread-0:0
//Thread-0:1
//Thread-1:0
//Thread-0:2
//Thread-0:3
//Thread-1:1
//...           Thread-0 和 Thread-1 混乱执行，因为不是访问同一块内存区域