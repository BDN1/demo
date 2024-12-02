package com.example.Command;

import java.util.Stack;

public class CommandManager {

    private static CommandManager instance;

    private final Stack<ICommand> commandStack = new Stack<>();
    private final Stack<ICommand> redoStack = new Stack<>();

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager(); 
        }
        return instance; 
    }

    public void pressTranslate(ICommand command) {
        command.execute();
        commandStack.push(command);
        redoStack.clear();
    }

    public void pressZoom(ICommand command) {
        command.execute();
        commandStack.push(command);
        redoStack.clear();
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            ICommand command = commandStack.pop();
            command.undo();
            redoStack.push(command);

        } else {
            System.out.println("pas de command a undo");
        }
    }

    public void redoLastCommand() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.execute();
            commandStack.push(command); 
        } else {
            System.out.println("Aucune commande a redo");
        }
    }
}