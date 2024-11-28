package com.example.Command;

public class CommandManager {

    private static CommandManager instance;
    private ICommand undoLast;
    private CommandHistory commandHistory;

    private ICommand translate;
    private ICommand zoom;

    private CommandManager(ICommand translate, ICommand zoom) {
        commandHistory = new CommandHistory();
        this.translate = translate;
        this.zoom = zoom;
    }

    public void pressTranslate() {
        this.translate.execute();
    }

    public void pressZoom() {
        this.zoom.execute();
    }

    public void setUndoLast(ICommand command) {
        undoLast = command;
    }

    public ICommand getLastUndoneCommand() {
        return undoLast;
    }

}