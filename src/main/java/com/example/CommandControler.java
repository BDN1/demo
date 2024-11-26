package com.example;

//(LF) Je sais pas si on en aura besoin au final.

class CommandControler {

    private ICommand translate;
    private ICommand zoom;
    private ICommand undo;

    public CommandControler(ICommand translate, ICommand zoom, ICommand undo) {
        this.translate = translate;
        this.zoom = zoom;
        this.undo = undo;
    }
    
    public void pressTranslate() {
        this.translate.execute();
    }
    
    public void pressZoom() {
        this.zoom.execute();
    }

    public void pressUndo() {
        this.undo.execute();
    }
}