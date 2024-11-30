package com.example.Command;
import com.example.Modele.Perspective;

public class TranslateUpCommand extends Command implements ICommand{
    private Perspective perspective;

    public TranslateUpCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public boolean  execute() {
        this.perspective.translateUp();
        return true;
    }

    @Override
    public void undo() {
        
    }
}
