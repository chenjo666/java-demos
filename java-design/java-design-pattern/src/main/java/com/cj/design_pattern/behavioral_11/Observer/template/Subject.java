package com.cj.design_pattern.behavioral_11.Observer.template;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
