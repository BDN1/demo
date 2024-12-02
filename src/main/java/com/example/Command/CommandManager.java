package com.example.Command;

import java.util.Stack;

public class CommandManager {

    private static CommandManager instance;

    private final Stack<ICommand> commandStack = new Stack<>();

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager(); 
        }
        return instance; 
    }

    public void pressTranslate(ICommand command) {
        command.execute();
        commandStack.push(command);
    }

    public void pressZoom(ICommand command) {
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