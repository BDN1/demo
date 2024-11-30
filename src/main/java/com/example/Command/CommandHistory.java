package com.example.Command;

import java.util.Stack;

public class CommandHistory {

    private final Stack<ICommand> commandStack = new Stack<>();

    public void executeCommand(ICommand command) {
        command.execute();
        commandStack.push(command);
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            ICommand command = commandStack.pop();
            command.undo();

        } else {
            System.out.println("pas de command a undo");
        }
    }
}