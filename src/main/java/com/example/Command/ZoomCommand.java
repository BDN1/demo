package com.example.Command;

import com.example.Modele.Perspective;

//Commande de zoom

public class ZoomCommand implements ICommand {
    private Perspective perspective;

    public ZoomCommand(Perspective perspective){
        this.perspective = perspective;
    }

    public void execute() {
        this.perspective.zoom();
    }
    
    @Override
    public void undo() {
        
    }
}