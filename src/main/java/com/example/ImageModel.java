package com.example;

import javafx.scene.image.Image;

public class ImageModel {
    private Image image;
    private Observer[] observers;

    public void setImage(Image image){
        this.image = image;
    }
    public Image getImage(){
        return this.image;
    }
}
