package com.cj.design_pattern.behavioral_11.Command.template;

public class ConcreteCommand2 implements Command {
    private Receiver receiver;
    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.handle2();
    }
}
