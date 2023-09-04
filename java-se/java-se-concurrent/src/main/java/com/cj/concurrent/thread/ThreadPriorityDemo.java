package com.cj.concurrent.thread;

public class ThreadPriorityDemo {
    static class Worker extends Thread {
        // 调度次数
        private long num = 0;
        @Override
        public void run() {
            // 线程执行体：死循环
            for (int i = 0; ; i++) {
                num++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Worker[] workers = new Worker[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker();
            // 从1~10设置各个线程优先级
            workers[i].setPriority(i + 1);
        }
        // 启动所有线程
        for (int i = 0; i < workers.length; i++) {
            workers[i].start();
        }
        // 等待所有线程执行1s
        Thread.sleep(1000);
        // 停止所有线程
        for (int i = 0; i < workers.length; i++) {
            workers[i].stop();
        }
        for (int i = 0; i < workers.length; i++) {
            System.out.println(workers[i].getName()
                    + "优先级为：" + workers[i].getPriority()
                    + "，调度次数：" + workers[i].num);
        }
    }
}
//Thread-0优先级为：1，调度次数：5631576
//Thread-1优先级为：2，调度次数：101016
//Thread-2优先级为：3，调度次数：455259196
//Thread-3优先级为：4，调度次数：550928729
//Thread-4优先级为：5，调度次数：593475701
//Thread-5优先级为：6，调度次数：578419805
//Thread-6优先级为：7，调度次数：598876170
//Thread-7优先级为：8，调度次数：598742075
//Thread-8优先级为：9，调度次数：594336900
//Thread-9优先级为：10，调度次数：602820490