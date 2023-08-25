package com.cj.design_pattern.Command.template;

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
