package com.cj.design_pattern.visitor.template;

public interface Element {
    void accept(Visitor visitor);
}
