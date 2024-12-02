package com.example.Vue;

import java.io.File;
import com.example.Controleur.ImageController;
import com.example.Modele.ImageModel;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ThumbnailView extends ImageView implements Observer {
    private ImageView imageView;
    private ImageModel image;
    private ImageController controller;

    public ThumbnailView() {
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(470);
        imageView.setFitWidth(470);
        imageView.setPreserveRatio(true);

        controller = new ImageController(image, imageView);
    }
    
    public HBox getView() {

        HBox hb = new HBox(10, imageView);
        hb.setStyle("-fx-border-color: black; -fx-border-width: 5;");
        hb.setAlignment(Pos.CENTER);
        return hb;
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth());
        imageView.setFitHeight(image.getImage().getHeight());
    }

    public void loadImage(File file) {
        image.loadImage(file);
        if (image.getImage() != null) {
            imageView.setImage(image.getImage());  // Set the ImageView to display the loaded image
        } else {
            System.err.println("Image not loaded correctly.");
        }
    }
}