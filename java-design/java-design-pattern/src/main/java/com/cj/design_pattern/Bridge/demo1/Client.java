package com.cj.design_pattern.Bridge.demo1;



// 笔（抽象）
abstract class AbstractPen {
    private IDraw draw;
    public AbstractPen(IDraw draw) {
        this.draw = draw;
    }

    public IDraw getDraw() {
        return draw;
    }

    public abstract void draw();
}
// 铅笔
class Pencil extends AbstractPen {

    public Pencil(IDraw draw) {
        super(draw);
    }

    @Override
    public void draw() {
        System.out.print("当前铅笔：");
        this.getDraw().drawColor();
    }
}
// 中性笔
class NeutralPen extends AbstractPen {

    public NeutralPen(IDraw draw) {
        super(draw);
    }

    @Override
    public void draw() {
        System.out.print("当前中性笔：");
        this.getDraw().drawColor();
    }
}
interface IDraw {
    void drawColor();
}
class BlueDraw implements IDraw {

    @Override
    public void drawColor() {
        System.out.println("画蓝色！");
    }
}
class RedDraw implements IDraw {
    @Override
    public void drawColor() {
        System.out.println("画红色！");
    }
}
class GreenDraw implements IDraw {

    @Override
    public void drawColor() {
        System.out.println("画绿色！");
    }
}
public class Client {
    public static void main(String[] args) {
        // 颜色
        IDraw red = new RedDraw();
        IDraw green = new GreenDraw();
        IDraw blue = new BlueDraw();

        AbstractPen pen1 = new Pencil(red);
        pen1.draw();

        AbstractPen pen2 = new NeutralPen(green);
        pen2.draw();

        AbstractPen pen3 = new Pencil(blue);
        pen3.draw();
    }
}
//当前铅笔：画红色！
//当前中性笔：画绿色！
//当前铅笔：画蓝色！