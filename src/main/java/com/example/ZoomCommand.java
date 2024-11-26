package com.example;

//Commande de zoom

public class ZoomCommand implements ICommand {
    private Perspective perspective;

    public ZoomCommand(Perspective perspective){
        this.perspective = perspective;
    }

    public void execute(){
        this.perspective.zoom();
    }
}