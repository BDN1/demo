package com.example.Modele;

import java.io.File;
import com.example.Vue.Observer;
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
    public void loadImage(File file) {
        if (file.exists() && file.isFile()) {
            try {
                this.image = new Image(file.toURI().toString());
                System.out.println("Image loaded successfully: " + file.getName());
                System.out.println(file.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.err.println("File not found or invalid: " + file.getAbsolutePath());
        }
    }
}