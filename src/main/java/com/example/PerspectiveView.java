package com.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PerspectiveView extends ImageView implements Observer {
    private ImageView imageView;
    private ImageModel image;
    private Perspective perspective;
    private ImageController controller;

    private Button zoomIn;
    private Button zoomOut;
    private Button translateLeft;
    private Button translateRight;

    public PerspectiveView() {
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        translateLeft = new Button("<-");
        zoomIn = new Button("Zoom In");
        zoomOut = new Button("Zoom Out");
        translateRight = new Button("->");

        HBox hb = new HBox(10, imageView, translateLeft, zoomIn, zoomOut, translateRight);
        hb.setAlignment(Pos.BOTTOM_CENTER);

        perspective = new Perspective();
        controller = new ImageController(perspective, imageView);

        setButtonActions();

        hb.setStyle("-fx-border-color: black; -fx-border-width: 2;");
    }

    private void setButtonActions() {
        zoomIn.setOnAction(e -> controller.handleZoomIn());
        zoomOut.setOnAction(e -> controller.handleZoomOut());
        translateLeft.setOnAction(e -> controller.handleTranslateLeft());
        translateRight.setOnAction(e -> controller.handleTranslateRight());
    }

    public HBox getView() {

        HBox hb = new HBox(10, imageView, translateLeft, zoomIn, zoomOut, translateRight);
        hb.setStyle("-fx-border-color: black; -fx-border-width: 2;");
        return hb;
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth() * perspective.getScale());
        imageView.setFitHeight(image.getImage().getHeight() * perspective.getScale());

        imageView.setTranslateX(perspective.getX());
    }
}
