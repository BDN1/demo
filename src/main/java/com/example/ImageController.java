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
        System.out.println("zoom in");
        //perspective.zoomIn();
        //manque a update les vues je crois
    }
    public void handleZoomOut(){
        System.out.println("zoom out");
        //perspective.zoomOut();
        //manque a update les vues je crois
    }
    public void handleTranslateLeft(){
        System.out.println("translate left");
        //perspective.translateLeft();
        //manque a update les vues je crois
    }
    public void handleTranslateRight(){
        System.out.println("translate right");
        //perspective.translateRight();
        //manque a update les vues je crois
    }

    
}

