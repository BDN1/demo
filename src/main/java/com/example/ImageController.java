package com.example;

import javafx.scene.image.ImageView;

public class ImageController {
    private ImageModel model;
    private Perspective perspective;
    private ImageView imageView;

    public ImageController(Perspective perspective, ImageView imageView){
        this.perspective = perspective;
        this.imageView = imageView;
    }
    public ImageController(ImageModel image, ImageView imageView){
        this.model = image;
        this.imageView = imageView;
    }
    public void handleZoomIn(){
        perspective.zoomIn();
        //manque a update les vues je crois
    }
    public void handleZoomOut(){
        perspective.zoomOut();
        //manque a update les vues je crois
    }
    public void handleTranslateLeft(){
        perspective.translateLeft();
        //manque a update les vues je crois
    }
    public void handleTranslateRight(){
        perspective.translateRight();
        //manque a update les vues je crois
    }

    
}

