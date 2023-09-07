package com.cj.design_pattern.structural_07.composite;

import java.util.ArrayList;
import java.util.List;

abstract class FileComponent {
    private String name;
    public FileComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 打印当前所在的层次
    public abstract void printLevel(int level);
}
class File extends FileComponent {

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
class Folder extends FileComponent {
    private List<FileComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addComponent(FileComponent fileComponent) {
        children.add(fileComponent);
    }
    public void removeComponent(FileComponent fileComponent) {
        children.remove(fileComponent);
    }
    @Override
    public void printLevel(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(this.getName());
        for (FileComponent child : children) {
            child.printLevel(level + 1);
        }
    }
}

public class CompositeDemo  {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder user = new Folder("user");
        FileComponent openTxt = new File("open.txt");
        FileComponent user1 = new File("user1.txt");
        FileComponent user2 = new File("user2.txt");
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