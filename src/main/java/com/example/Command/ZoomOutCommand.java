package com.example.Command;

import com.example.Modele.Perspective;

public class ZoomOutCommand implements ICommand {
    private Perspective perspective;

    public ZoomOutCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.zoomOut();
    }
    
    @Override
    public void undo() {
        this.perspective.zoomIn();
    }
}