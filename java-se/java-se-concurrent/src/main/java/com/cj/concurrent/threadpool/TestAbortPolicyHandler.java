package com.cj.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestAbortPolicyHandler {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        List<DiscardPolicyTask> tasks = new ArrayList<>();
        tasks.add(new DiscardPolicyTask(1));
        tasks.add(new DiscardPolicyTask(2));
        tasks.add(new DiscardPolicyTask(3));
        tasks.add(new DiscardPolicyTask(4));
        tasks.add(new DiscardPolicyTask(5));
        tasks.add(new DiscardPolicyTask(6));

        for (int i = 0; i < 6; i++) {
            threadPool.execute(tasks.get(i));
        }
    }
    static class DiscardPolicyTask implements Runnable {
        private int id;

        public DiscardPolicyTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " execute task: " + id);
        }
    }
}
//pool-1-thread-1 execute task: 1
//pool-1-thread-3 execute task: 5
//pool-1-thread-1 execute task: 3
//pool-1-thread-2 execute task: 2
//pool-1-thread-3 execute task: 4
//Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.cj.threadpool.TestAbortPolicyHandler$AbortPolicyTask@378bf509 rejected from java.util.concurrent.ThreadPoolExecutor@5fd0d5ae[Running, pool size = 3, active threads = 2, queued tasks = 0, completed tasks = 1]
//	at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1365)
//	at com.cj.threadpool.TestAbortPolicyHandler.main(TestAbortPolicyHandler.java:30)
