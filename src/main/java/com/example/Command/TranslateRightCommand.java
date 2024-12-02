package com.example.Command;

import com.example.Modele.Perspective;

public class TranslateRightCommand implements ICommand {
    private Perspective perspective;

    public TranslateRightCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.translateRight();
        
    }

    @Override
    public void undo() {
        
    }

}
