package com.cj.concurrent.task;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        // 创建 Callable 对象
        Callable<Integer> callable = () -> {
            System.out.println("任务开始执行...");
            // 模拟耗时操作
            Thread.sleep(2000);
            return 123;
        };

        // 创建 FutureTask 对象，并将 Callable 对象传入
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 提交 FutureTask 到线程池
        executorService.submit(futureTask);

        // 主线程可以继续执行其他操作

        try {
            // 获取任务执行结果，如果任务还未完成，get() 方法会阻塞等待
            int result = futureTask.get();
            System.out.println("任务执行结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
