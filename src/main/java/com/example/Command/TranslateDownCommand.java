package com.example.Command;

import com.example.Modele.Perspective;

//Commande de translation

public class TranslateDownCommand extends Command implements ICommand {
    private Perspective perspective;

    public TranslateDownCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.translateDown();
    }
    
    @Override
    public void undo() {
        
    }
}