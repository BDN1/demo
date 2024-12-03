package com.example.Controleur;

import com.example.Command.CommandManager;
import com.example.Command.SaveImageCommand;
import com.example.Command.TranslateDownCommand;
import com.example.Command.TranslateLeftCommand;
import com.example.Command.TranslateRightCommand;
import com.example.Command.TranslateUpCommand;
import com.example.Command.ZoomInCommand;
import com.example.Command.ZoomOutCommand;
import com.example.Modele.ImageModel;
import com.example.Modele.Perspective;

import javafx.scene.image.ImageView;

public class ImageController {
    private ImageModel model;
    private Perspective perspective;
    private ImageView imageView;
    private CommandManager commandManager = CommandManager.getInstance();

    public ImageController(Perspective perspective, ImageView imageView) {
        this.perspective = perspective;
        this.imageView = imageView;
    }
    
    public ImageController(ImageModel image, ImageView imageView) {
        this.model = image;
        this.imageView = imageView;
    }

    public void handleZoomIn() {
        ZoomInCommand zoomInCommand = new ZoomInCommand(perspective);
        commandManager.pressZoom(zoomInCommand);
    }
    
    public void handleZoomOut() {
        ZoomOutCommand zoomOutCommand = new ZoomOutCommand(perspective);
        commandManager.pressZoom(zoomOutCommand);
    }
    
    public void handleTranslateLeft(){
        TranslateLeftCommand TranslateLeftCommand = new TranslateLeftCommand(perspective);
        commandManager.pressTranslate(TranslateLeftCommand);
    }

    public void handleTranslateRight() {
        TranslateRightCommand translateRightCommand = new TranslateRightCommand(perspective);
        commandManager.pressTranslate(translateRightCommand);
    }
    
    public void handleTranslateUp() {
        TranslateUpCommand translateUpCommand = new TranslateUpCommand(perspective);
        commandManager.pressTranslate(translateUpCommand);
    }
    
    public void handleTranslateDown(){
        TranslateDownCommand translateDownCommand = new TranslateDownCommand(perspective);
        commandManager.pressTranslate(translateDownCommand);
    }


    public void handleUndo(){
        commandManager.undoLastCommand();
    }

    public void handleRedo() {
        commandManager.redoLastCommand(); 
    }

    public void handleSave(String imagePath,String newPath){
        SaveImageCommand saveImageCommand = new SaveImageCommand(perspective,newPath,model,imagePath);
        commandManager.pressSave(saveImageCommand);
    }
}