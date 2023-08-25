package com.cj.design_principle.liskov_substitution.solution;

public class Square implements Tetragon {
    private int side;
    @Override
    public int getWidth() {
        return this.side;
    }

    @Override
    public int getHeight() {
        return this.side;
    }

    @Override
    public int getArea() {
        return this.side * this.side;
    }
}
