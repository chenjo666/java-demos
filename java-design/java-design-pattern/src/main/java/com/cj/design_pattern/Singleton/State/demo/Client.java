package com.cj.design_pattern.Singleton.State.demo;

interface HeroState {
    void handle(Hero hero);
}
class DuranceState implements HeroState {
    @Override
    public void handle(Hero hero) {
        System.out.println("英雄被禁锢！");
    }
}
class ModerateState implements HeroState {
    @Override
    public void handle(Hero hero) {
        System.out.println("英雄被减速！");
    }
}
class SilenceState implements HeroState {

    @Override
    public void handle(Hero hero) {
        System.out.println("英雄被沉默！");
    }
}
class Hero {
    private HeroState heroState;
    public void setHeroState(HeroState heroState) {
        this.heroState = heroState;
    }
    public void request() {
        if (heroState != null) {
            heroState.handle(this);
        }
    }
}


public class Client {
    public static void main(String[] args) {
        Hero hero = new Hero();
        HeroState state = new DuranceState();
        hero.setHeroState(state);
        hero.request();

        state = new ModerateState();
        hero.setHeroState(state);
        hero.request();

        state = new SilenceState();
        hero.setHeroState(state);
        hero.request();
    }
}
//英雄被禁锢！
//英雄被减速！
//英雄被沉默！