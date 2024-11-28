package com.example;

import javafx.scene.image.ImageView;

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

        // Add a border to the ThumbnailView for visualization
        this.setStyle("-fx-border-color: red; -fx-border-width: 2;");
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth());
        imageView.setFitHeight(image.getImage().getHeight());
    }
}
