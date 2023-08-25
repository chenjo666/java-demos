package com.cj.design_pattern.ChainOfResponsibility.template;

public abstract class Handler {
    private Handler next;
    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return next;
    }

    public abstract void resolve(Request request);
}
