package com.cj.design_pattern.structural_07.Composite.template;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    List<Component> children = new ArrayList<>();;
    public void addChild(Component component) {
        children.add(component);
    }
    public void removeChild(Component component) {
        children.remove(component);
    }
    @Override
    public void operation() {

    }
}
