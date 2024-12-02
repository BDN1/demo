package com.example.Command;

import java.util.Stack;

public class CommandManager {

    private static CommandManager instance;
    private ICommand undoLast;
    private CommandHistory commandHistory;

    private ICommand translate;
    private ICommand zoom;

    private final Stack<ICommand> commandStack = new Stack<>();

    private CommandManager(ICommand translate, ICommand zoom) {
        commandHistory = new CommandHistory();
        this.translate = translate;
        this.zoom = zoom;
    }

    public static CommandManager getInstance(ICommand translate, ICommand zoom) {
        if (instance == null) {
            instance = new CommandManager(translate, zoom); 
        }
        return instance; 
    }

    public void pressTranslate(ICommand command) {
        this.translate.execute();
        commandStack.push(command);
    }

    public void pressZoom(ICommand command) {
        this.zoom.execute();
        commandStack.push(command);
    }

    public void setUndoLast(ICommand command) {
        undoLast = command;
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