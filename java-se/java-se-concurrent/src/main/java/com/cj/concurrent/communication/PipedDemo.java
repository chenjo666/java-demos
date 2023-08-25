package com.cj.concurrent.communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedDemo {
    private PipedInputStream inputStream = new PipedInputStream();
    private PipedOutputStream outputStream = new PipedOutputStream();

    private int num = 0;

    public PipedDemo() {
        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeData() throws IOException, InterruptedException {
        while (num != 10) {
            System.out.println(Thread.currentThread().getName() + "管道流写入数据：" + (++num));
            outputStream.write(num);
            Thread.sleep(1000);
        }
        outputStream.close();
    }

    public void readData() throws IOException, InterruptedException {
        while (num != 10) {
            System.out.println(Thread.currentThread().getName() + "管道流读取数据：" + inputStream.read());
        }
        inputStream.close();
    }
    public static void main(String[] args) {
        PipedDemo demo = new PipedDemo();

        new Thread(() -> {
            try {
                demo.writeData();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                demo.readData();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
