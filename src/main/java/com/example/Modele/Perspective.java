package com.example.Modele;

import com.example.Vue.Observer;

public class Perspective {
    private double x=0;
    private double y=0;
    private double scale = 1.0;

    private Observer[] observers;

    public double getScale(){
        return scale;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void zoom() {

    }
    
    public void translate() {

    }

    //peut être les translates y a faire ?????

}
