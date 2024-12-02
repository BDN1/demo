package com.example.Modele;

import java.util.ArrayList;
import java.util.List;
import com.example.Vue.Observer;

public class Perspective {
    private double x=0;
    private double y=0;
    private double scale = 1.0;

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer obs) {
        observers.add(obs);
    }
    
    public void detach(Observer obs){
        observers.remove(obs);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
    public double getScale() {
        return scale;
    }
    
    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void zoomIn() {
        scale += 0.1;
        notifyObserver();
    }

    public void zoomOut() {
        scale -= 0.1;
        notifyObserver();
    }
    
    public void translateLeft() {
        x -= 10;
        notifyObserver();
    }
    
    public void translateRight(){
        x += 10;
        notifyObserver();
    }

    public void translateUp() {
        y -= 10;
        notifyObserver();
    }
    
    public void translateDown(){
        y += 10;
        notifyObserver();
    }
}