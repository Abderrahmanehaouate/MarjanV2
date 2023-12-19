package com.youcode.marjanv2.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        observers.forEach(Observer::update);
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
