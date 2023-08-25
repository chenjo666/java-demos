package com.cj.design_pattern.behavioral_11.visitor.template;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    List<Element> elements = new ArrayList<>();
    public void add(Element element) {
        this.elements.add(element);
    }
    public void remove(Element element) {
        this.elements.remove(element);
    }
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
