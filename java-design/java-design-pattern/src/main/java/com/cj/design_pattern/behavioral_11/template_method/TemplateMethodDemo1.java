package com.cj.design_pattern.behavioral_11.template_method;

abstract class BallGame {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    // 模板方法
    public final void play() {
        // 初始化游戏
        initialize();
        // 开始游戏
        startPlay();
        // 结束游戏
        endPlay();
    }
}
class BasketBallGame extends BallGame {

    @Override
    void initialize() {
        System.out.println("basketBallGame Initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("basketBallGame started!");
    }

    @Override
    void endPlay() {
        System.out.println("basketBallGame finished!");
    }
}
class FootBallGame extends BallGame {

    @Override
    void initialize() {
        System.out.println("footBallGame Initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("footBallGame started!");
    }

    @Override
    void endPlay() {
        System.out.println("footBallGame finished!");
    }
}

public class TemplateMethodDemo1 {
    public static void main(String[] args) {
        BallGame game = new BasketBallGame();
        game.play();

        game = new FootBallGame();
        game.play();
    }
}
//basketBallGame Initialized!
//basketBallGame started!
//basketBallGame finished!
//footBallGame Initialized!
//footBallGame started!
//footBallGame finished!