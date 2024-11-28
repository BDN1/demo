package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ThumbnailView extends ImageView implements Observer {
    private ImageView imageView;
    private ImageModel image;
    private ImageController controller;

    public ThumbnailView() {
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        controller = new ImageController(image, imageView);

        this.setStyle("-fx-border-color: red; -fx-border-width: 2;");
    }
    public HBox getView() {

        HBox hb = new HBox(10, imageView);
        hb.setStyle("-fx-border-color: red; -fx-border-width: 2;");
        return hb;
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth());
        imageView.setFitHeight(image.getImage().getHeight());
    }
}
