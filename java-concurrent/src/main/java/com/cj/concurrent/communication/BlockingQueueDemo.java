package com.cj.concurrent.communication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    private BlockingQueue<Character> blockingQueue = new LinkedBlockingQueue<>();
    private char ch = 'a';

    public void produce() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "生产者已生产元素：" + ch);
                blockingQueue.put(ch++);
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void consume() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "消费者已消费元素：" + blockingQueue.take());
                Thread.sleep(1500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        BlockingQueueDemo demo = new BlockingQueueDemo();
        // 开启一个生产者，两个消费者
        new Thread(() -> {
            demo.produce();
        }).start();
        new Thread(() -> {
            demo.consume();
        }).start();
        new Thread(() -> {
            demo.consume();
        }).start();
    }
}
//Thread-0生产者已生产元素：a
//Thread-1消费者已消费元素：a
//Thread-0生产者已生产元素：b
//Thread-2消费者已消费元素：b
//...