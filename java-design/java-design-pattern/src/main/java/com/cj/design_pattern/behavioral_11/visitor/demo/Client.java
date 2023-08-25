package com.cj.design_pattern.behavioral_11.visitor.demo;

import java.util.ArrayList;
import java.util.List;

// 景点
interface ScenicSpot {
    void accept(Visitor visitor);
}
// 博物馆
class Museum implements ScenicSpot {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
// 动物园
class Zoo implements ScenicSpot {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
// 访问者
interface Visitor {
    void visit(Museum museum);
    void visit(Zoo zoo);
}
// 游客
class Tourist implements Visitor  {
    @Override
    public void visit(Museum museum) {
        System.out.println("参观了博物馆！");
    }

    @Override
    public void visit(Zoo zoo) {
        System.out.println("参观了动物馆！");
    }
}
// 导游
class Guide {
    List<ScenicSpot> scenicSpots = new ArrayList<>();
    public void add(ScenicSpot scenicSpot) {
        scenicSpots.add(scenicSpot);
    }
    public void remove(ScenicSpot scenicSpot) {
        scenicSpots.remove(scenicSpot);
    }
    public void accept(Visitor visitor) {
        for (ScenicSpot scenicSpot : scenicSpots) {
            scenicSpot.accept(visitor);
        }
    }
}
public class Client {
    public static void main(String[] args) {
        ScenicSpot museum = new Museum();
        ScenicSpot zoo = new Zoo();
        Guide guide = new Guide();
        Tourist tourist = new Tourist();

        guide.add(museum);
        guide.add(zoo);

        guide.accept(tourist);
    }
}
//参观了博物馆！
//参观了动物馆！