package com.example.Command;

import com.example.Modele.Perspective;

public class ZoomOutCommand extends Command implements ICommand {
    private Perspective perspective;

    public ZoomOutCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public boolean  execute() {
        this.perspective.zoomOut();
        return true;
    }
    
    @Override
    public void undo() {
        
    }

}
