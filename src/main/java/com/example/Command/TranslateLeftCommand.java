package com.example.Command;

import com.example.Modele.Perspective;

public class TranslateLeftCommand implements ICommand {
    private Perspective perspective;

    public TranslateLeftCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.translateLeft();
    }

    @Override
    public void undo() {
        this.perspective.translateRight();
    }
}