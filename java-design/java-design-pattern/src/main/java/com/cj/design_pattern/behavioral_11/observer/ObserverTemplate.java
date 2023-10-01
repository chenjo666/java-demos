package com.cj.design_pattern.behavioral_11.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class ConcreteObserver implements Observer {
    @Override
    public void update() {

    }
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class ConcreteSubject implements Subject {
    List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

public class ObserverTemplate {
}
