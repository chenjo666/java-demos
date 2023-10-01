package com.cj.concurrent.forkjoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;



public class ForkJoinDemo {
    static class FibonacciTask extends RecursiveTask<Long> {
        static final int THRESHOLD = 15;
        private final int n;

        public FibonacciTask(int n) {
            this.n = n;
        }

        @Override
        protected Long compute() {
            if (n <= THRESHOLD) {
                return calculateFibonacci(n);
            }
            FibonacciTask f1 = new FibonacciTask(n - 1);
            f1.fork();
            FibonacciTask f2 = new FibonacciTask(n - 2);
            return f2.compute() + f1.join();
        }
    }
    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 40;

        // 使用 ForkJoin 框架计算斐波那契数列的第 n 项
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        FibonacciTask fibonacciTask = new FibonacciTask(n);
        long startTime = System.currentTimeMillis();
        long result = forkJoinPool.invoke(fibonacciTask);
        long endTime = System.currentTimeMillis();
        long forkJoinTime = endTime - startTime;
        System.out.println("ForkJoin Time: " + forkJoinTime);
        System.out.println("Fibonacci(" + n + ") = " + result);

        // 使用普通的 for 循环计算斐波那契数列的第 n 项
        startTime = System.currentTimeMillis();
        result = calculateFibonacci(n);
        endTime = System.currentTimeMillis();
        long forLoopTime = endTime - startTime;
        System.out.println("ForLoop Time: " + forLoopTime);
        System.out.println("Fibonacci(" + n + ") = " + result);
    }

}
//ForkJoin Time: 290
//Fibonacci(40) = 102334155
//ForLoop Time: 552
//Fibonacci(40) = 102334155