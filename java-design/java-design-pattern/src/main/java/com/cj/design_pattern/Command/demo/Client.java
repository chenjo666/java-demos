package com.cj.design_pattern.Command.demo;


interface Button {
    void pressDown();
}
class OpenButton implements Button {
    private Television tv;
    public OpenButton(Television tv) {
        this.tv = tv;
    }
    @Override
    public void pressDown() {
        tv.open();
    }
}
class CloseButton implements Button {
    private Television tv;
    public CloseButton(Television tv) {
        this.tv = tv;
    }
    @Override
    public void pressDown() {
        tv.close();
    }
}
class Television {
    public void open() {
        System.out.println("电视机开机中！");
    }
    public void close() {
        System.out.println("电视机关机中！");
    }
}
// 遥控器
class RemoteControl {
    private Button button;
    public void setButton(Button button) {
        this.button = button;
    }
    public void buttonDown() {
        button.pressDown();
    }
}

public class Client {
    public static void main(String[] args) {
        // 创建一个电视机
        Television tv = new Television();
        // 创建一个遥控器
        RemoteControl remoteControl = new RemoteControl();
        // 创建开机、关机按钮
        Button openButton = new OpenButton(tv);
        Button closeButton = new CloseButton(tv);

        // 调用开机按钮
        remoteControl.setButton(openButton);
        remoteControl.buttonDown();

        // 调用关机按钮
        remoteControl.setButton(closeButton);
        remoteControl.buttonDown();
    }
}
//电视机开机中！
//电视机关机中！