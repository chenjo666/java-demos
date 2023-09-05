package com.cj.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * CallerRuns 拒绝策略示例
 */

public class TestHandlerCallerRuns {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        CallerRunsTask t1 = new CallerRunsTask("id:1");
        CallerRunsTask t2 = new CallerRunsTask("id:2");
        CallerRunsTask t3 = new CallerRunsTask("id:3");
        CallerRunsTask t4 = new CallerRunsTask("id:4");
        CallerRunsTask t5 = new CallerRunsTask("id:5");
        CallerRunsTask t6 = new CallerRunsTask("id:6");
        CallerRunsTask t7 = new CallerRunsTask("id:7");

        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);
        es.execute(t6);
        es.execute(t7);

    }
    static class CallerRunsTask implements Runnable {
        private String id;

        public CallerRunsTask(String id) {
            this.id = id;
        }

        public void run() {
            System.out.println(id+"线程名"+Thread.currentThread().getName());
        }
    }
}

//id:7线程名main
//id:1线程名pool-1-thread-1
//id:6线程名pool-1-thread-3
//id:3线程名pool-1-thread-1
//id:5线程名pool-1-thread-1
//id:2线程名pool-1-thread-2
//id:4线程名pool-1-thread-3