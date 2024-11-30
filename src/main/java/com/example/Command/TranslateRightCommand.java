package com.example.Command;

import com.example.Modele.Perspective;

public class TranslateRightCommand extends Command implements ICommand {
    private Perspective perspective;

    public TranslateRightCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public boolean  execute() {
        this.perspective.translateRight();
        return true;
    }

    @Override
    public void undo() {
        
    }

}
