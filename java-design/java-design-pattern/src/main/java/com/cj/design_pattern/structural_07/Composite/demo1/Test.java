package com.cj.design_pattern.structural_07.Composite.demo1;

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    private String name;
    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 打印当前所在的层次
    public abstract void printLevel(int level);
}
class File extends Component {

    public File(String name) {
        super(name);
    }

    @Override
    public void printLevel(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(this.getName());
    }

}
class Folder extends Component {
    private List<Component> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addComponent(Component component) {
        children.add(component);
    }
    public void removeComponent(Component component) {
        children.remove(component);
    }
    @Override
    public void printLevel(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(this.getName());
        for (Component child : children) {
            child.printLevel(level + 1);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder user = new Folder("user");
        Component openTxt = new File("open.txt");
        Component user1 = new File("user1.txt");
        Component user2 = new File("user2.txt");
        user.addComponent(user1);
        user.addComponent(user2);
        root.addComponent(user);
        root.addComponent(openTxt);

        root.printLevel(0);
    }
}
//root
//    user
//        user1.txt
//        user2.txt
//    open.txt