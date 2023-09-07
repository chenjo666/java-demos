package com.cj.design_pattern.structural_07.composite;


import java.util.ArrayList;
import java.util.List;


abstract class Component {
    public abstract void operation();
}
 class Composite extends Component {
    List<Component> children = new ArrayList<>();;
    public void addChild(Component component) {
        children.add(component);
    }
    public void removeChild(Component Component) {
        children.remove(Component);
    }
    @Override
    public void operation() {

    }
}

class Leaf extends Component {

    @Override
    public void operation() {

    }
}

public class CompositeTemplate {
}
