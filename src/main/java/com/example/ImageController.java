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
    private void handleZoomIn(){
        perspective.zoomIn();
        //manque a update les vues je crois
    }
    private void handleZoomOut(){
        perspective.zoomOut();
        //manque a update les vues je crois
    }
    private void handleTranslateLeft(){
        perspective.translateLeft();
        //manque a update les vues je crois
    }
    private void handleTranslateRight(){
        perspective.translateRight();
        //manque a update les vues je crois
    }

    
}

