package com.cj.design_pattern.behavioral_11.Command.template;

public class Invoker {
    private Command command;
    private void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}
