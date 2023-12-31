package com.cj.design_pattern.behavioral_11.State.template;

public class Context {
    private State state;
    private void setState(State state) {
        this.state = state;
    }
    public void request() {
        if (state != null)
            state.handle(this);
    }
}
