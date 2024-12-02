package com.example.Command;

import com.example.Modele.Perspective;

public class TranslateUpCommand implements ICommand{
    private Perspective perspective;

    public TranslateUpCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void  execute() {
        this.perspective.translateUp();
    }

    @Override
    public void undo() {
        this.perspective.translateDown();
    }
}
