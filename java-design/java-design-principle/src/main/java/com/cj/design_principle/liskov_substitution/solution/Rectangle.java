package com.cj.design_principle.liskov_substitution.solution;

public class Rectangle implements Tetragon {
    private int height;
    private int width;


    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getArea() {
        return this.height * this.width;
    }
}
