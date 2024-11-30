package com.example.Command;

import com.example.Modele.Perspective;

//Commande de translation

public class TranslateCommand implements ICommand {
    private Perspective perspective;

    public TranslateCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        this.perspective.translate();
    }
    
    @Override
    public void undo() {
        
    }
}