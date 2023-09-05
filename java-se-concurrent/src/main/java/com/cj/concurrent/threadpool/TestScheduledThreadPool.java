package com.cj.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {
    public static void main(String[] args) {
        // 1. 创建定时线程池对象 & 设置线程池线程数量固定为5
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 2. 创建好 Runnable 类线程对象 & 需执行的任务
        Runnable task = () -> System.out.println("execute task!");
        // 3. 向线程池提交任务
        scheduledThreadPool.schedule(task, 1, TimeUnit.SECONDS); // 延迟1s后执行任务
        scheduledThreadPool.scheduleAtFixedRate(task, 10, 1000, TimeUnit.MILLISECONDS);// 延迟10ms后、每隔1000ms执行任务
    }
}
