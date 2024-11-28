package com.example;

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

    public void zoomIn(){
        scale *= 1.2;
        //faut notify les observer
    }
    public void zoomOut(){
        scale /= 1.2;
        //faut notify les observer
    }
    public void translateLeft(){
        x -= 10;
        //faut notify les observer
    }
    public void translateRight(){
        x += 10;
        //faut notify les observer
    }

    //peut être les translates y a faire ?????

}
