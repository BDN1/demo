package com.example;

public class CommandManager {

    

    private static CommandManager instance;
    private ICommand undoLast;
    private CommandHistory commandHistory;

    private  CommandManager(){
        commandHistory = new CommandHistory();
    }


    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }


    public void setUndoLast(ICommand command) {
        undoLast = command;
    }


    public ICommand getLastUndoneCommand() {
        return undoLast;
    }



}
