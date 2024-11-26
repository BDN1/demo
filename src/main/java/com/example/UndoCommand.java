package com.example;

//Commande de retour en arrière

public class UndoCommand implements ICommand {
    private Perspective perspective;

    public UndoCommand(Perspective perspective){
        this.perspective = perspective;
    }

    public void execute(){
        this.perspective.undo();
    }
}