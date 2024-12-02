package com.example.Command;

import com.example.Modele.Perspective;

//Commande de translation

public class TranslateDownCommand implements ICommand {
    private Perspective perspective;

    public TranslateDownCommand(Perspective perspective){
        this.perspective = perspective;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }

    
}