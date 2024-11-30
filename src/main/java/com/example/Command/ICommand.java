package com.example.Command;

//Interface Commande

public interface ICommand {
    public boolean  execute();
    public void undo();
}