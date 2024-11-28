package com.example;

import javafx.scene.image.ImageView;

public class ThumbnailView implements Observer{
    private ImageView imageView;
    private ImageModel image;
    private ImageController controller;


    public ThumbnailView(){
        
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
