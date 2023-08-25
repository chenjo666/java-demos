package com.cj.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestDiscardOldestPolicy {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        List<DiscardOldestPolicyTask> tasks = new ArrayList<>();
        tasks.add(new DiscardOldestPolicyTask(1));
        tasks.add(new DiscardOldestPolicyTask(2));
        tasks.add(new DiscardOldestPolicyTask(3));
        tasks.add(new DiscardOldestPolicyTask(4));
        tasks.add(new DiscardOldestPolicyTask(5));
        tasks.add(new DiscardOldestPolicyTask(6));

        for (int i = 0; i < 6; i++) {
            threadPool.execute(tasks.get(i));
        }
    }
    static class DiscardOldestPolicyTask implements Runnable {
        private int id;

        public DiscardOldestPolicyTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " execute task: " + id);
        }
    }
}
//pool-1-thread-1 execute task: 1
//pool-1-thread-1 execute task: 4
//pool-1-thread-1 execute task: 6
//pool-1-thread-2 execute task: 2
//pool-1-thread-3 execute task: 5