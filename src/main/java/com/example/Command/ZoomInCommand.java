package com.example.Command;

import com.example.Modele.Perspective;

//Commande de zoom

public class ZoomInCommand extends Command implements ICommand {
    private Perspective perspective;

    public ZoomInCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public boolean  execute() {
        this.perspective.zoomIn();
        return true;
    }
    
    @Override
    public void undo() {
        
    }
}