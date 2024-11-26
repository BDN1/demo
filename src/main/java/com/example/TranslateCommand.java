package com.example;

//Commande de translation

public class TranslateCommand implements ICommand {
    private Perspective perspective;

    public TranslateCommand(Perspective perspective){
        this.perspective = perspective;
    }

    public void execute(){
        this.perspective.translate();
    }
}