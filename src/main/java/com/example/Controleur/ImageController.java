package com.example.Controleur;


import com.example.Command.CommandManager;
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
    private CommandManager commandManager;

    public ImageController(Perspective perspective, ImageView imageView){
        this.perspective = perspective;
        this.imageView = imageView;
    }
    public ImageController(ImageModel image, ImageView imageView){
        this.model = image;
        this.imageView = imageView;
    }
    public void handleZoomIn(){
        ZoomInCommand zoomInCommand = new ZoomInCommand(perspective);
        commandManager.pressZoom(zoomInCommand);
        // il manque la methode update je sais pas elles est ou ?
        //perspective.zoomIn();
        //manque a update les vues je crois
    }
    public void handleZoomOut(){
        ZoomOutCommand zoomOutCommand = new ZoomOutCommand(perspective);
        // faut creer un presse zoomout ici 
        //manque a update les vues je crois
        // il manque la methode update je sais pas elles est ou ?
    }
    public void handleTranslateLeft(){
        TranslateLeftCommand TranslateLeftCommand = new TranslateLeftCommand(perspective);
        commandManager.pressTranslate(TranslateLeftCommand);
        //manque a update les vues je crois
        // il manque la methode update je sais pas elles est ou ?
    }
    public void handleTranslateRight(){
        TranslateRightCommand translateRightCommand = new TranslateRightCommand(perspective);
        commandManager.pressTranslate(translateRightCommand);
        
        
        //manque a update les vues je crois
        // il manque la methode update je sais pas elles est ou ?
    }
    public void handleTranslateUp(){
        TranslateUpCommand translateUpCommand = new TranslateUpCommand(perspective);
        commandManager.pressTranslate(translateUpCommand);
        //manque a update les vues je crois
        // il manque la methode update je sais pas elles est ou ?
    }
    public void handleTranslateDown(){
        TranslateDownCommand translateDownCommand = new TranslateDownCommand(perspective);
        commandManager.pressTranslate(translateDownCommand);
        //manque a update les vues je crois
        // il manque la methode update je sais pas elles est ou ?
    }

    
    
}

