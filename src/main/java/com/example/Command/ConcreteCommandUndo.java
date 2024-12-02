package com.example.Command;

public class ConcreteCommandUndo implements ICommand {

private CommandHistory commandHistory;

public ConcreteCommandUndo(){
    this.commandHistory = new CommandHistory();
}

    @Override
    public void execute() {
        commandHistory.undoLastCommand();
    }

    @Override
    public void undo() {
        
    }




}
