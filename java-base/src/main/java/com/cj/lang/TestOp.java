package com.cj.lang;

public class TestOp {
    public static void main(String[] args) {
        long x = 1L;
        long l = x * 1000 % 400;
        System.out.println(l);

        int x1 = Integer.MAX_VALUE;
        System.out.println((x1 + 1) & Integer.MAX_VALUE);
    }
}
