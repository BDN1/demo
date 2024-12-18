package com.example.Command;

import com.example.Modele.Perspective;

public class ZoomInCommand  implements ICommand {
    private Perspective perspective;

    public ZoomInCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.zoomIn();
    }
    
    @Override
    public void undo() {
        this.perspective.zoomOut();
    }
}