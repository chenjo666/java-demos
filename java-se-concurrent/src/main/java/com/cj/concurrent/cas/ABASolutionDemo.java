package com.cj.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABASolutionDemo {
    public static void main(String[] args) {
        // 初始值 1，版本号 1
        AtomicStampedReference<Integer> abaStamped = new AtomicStampedReference(1, 1);

        // 线程 t1 使用 cas 并且把 1 改成 2，再改回来
        new Thread(() -> {
            // 1 - A
            int stamped = abaStamped.getStamp(), v = abaStamped.getReference();
            System.out.println("t1: stamped{" + stamped + "}, value={" + v + "}");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 2 - B
            boolean res = abaStamped.compareAndSet(
                    v,
                    v + 1,
                    stamped,
                    stamped + 1);
            System.out.println("t1: res{" + res + "}, " + "stamped{" + abaStamped.getStamp() + "}, value={" + abaStamped.getReference() + "}");
            // 3 - A
            res = abaStamped.compareAndSet(
                    abaStamped.getReference(),
                    v,
                    abaStamped.getStamp(),
                    abaStamped.getStamp() + 1);
            System.out.println("t1: res{" + res + "}, " + "stamped{" + abaStamped.getStamp() + "}, value={" + abaStamped.getReference() + "}");

        }, "t1").start();

        // 线程 t2 使用 cas 把 1 改成 3
        new Thread(() -> {
            // 1 - A
            int stamped = abaStamped.getStamp(), v = abaStamped.getReference();
            System.out.println("t2: stamped{" + stamped + "}, value={" + v + "}");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean res = abaStamped.compareAndSet(1, 3, stamped, stamped + 1);
            System.out.println("t2: res{" + res + "}, " + "stamped{" + abaStamped.getStamp() + "}, value={" + abaStamped.getReference() + "}");

        }, "t2").start();
    }
}
//t1: stamped{1}, value={1}
//t2: stamped{1}, value={1}
//t1: res{true}, stamped{2}, value={2}
//t1: res{true}, stamped{3}, value={1}
//t2: res{false}, stamped{3}, value={1}