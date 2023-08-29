package com.cj.concurrent.threadlocal;

public class ThreadLocalDemo {
    static ThreadLocal<Object> t = new ThreadLocal<>();
    public static void main(String[] args) {
        // set
        t.set(new Object());
        // get
        System.out.println(t.get());
    }
}
