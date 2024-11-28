package com.example.Vue;

import java.io.File;

import com.example.Controleur.ImageController;
import com.example.Modele.ImageModel;
import com.example.Modele.Perspective;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PerspectiveView extends ImageView implements Observer {
    private ImageView imageView;
    private ImageModel image;
    private Perspective perspective;
    private ImageController controller;

    private Button zoomIn;
    private Button zoomOut;
    private Button translateLeft;
    private Button translateRight;
    private Button translateUp;
    private Button translateDown;

    public PerspectiveView() {
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(930);
        imageView.setFitWidth(700);
        imageView.setPreserveRatio(false);

        translateLeft = new Button("<-");
        translateUp = new Button("^");
        zoomIn = new Button("Zoom In");
        zoomOut = new Button("Zoom Out");
        translateRight = new Button("->");
        translateDown = new Button("v");

        perspective = new Perspective();
        controller = new ImageController(perspective, imageView);

        setButtonActions();
    }

    private void setButtonActions() {
        zoomIn.setOnAction(e -> controller.handleZoomIn());
        zoomOut.setOnAction(e -> controller.handleZoomOut());
        translateLeft.setOnAction(e -> controller.handleTranslateLeft());
        translateRight.setOnAction(e -> controller.handleTranslateRight());
        translateUp.setOnAction(e -> controller.handleTranslateUp());
        translateDown.setOnAction(e -> controller.handleTranslateDown());
    }
    public VBox getView() {
        HBox hb = new HBox(10, imageView);
        hb.setAlignment(Pos.CENTER);

        HBox button = new HBox(10,translateLeft, translateUp, zoomIn, zoomOut, translateRight,translateDown);
        hb.setAlignment(Pos.BASELINE_LEFT);

        VBox vb = new VBox(10,hb,button);
        vb.setStyle("-fx-border-color: blue; -fx-border-width: 5;");
        return vb;
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth() * perspective.getScale());
        imageView.setFitHeight(image.getImage().getHeight() * perspective.getScale());

        imageView.setTranslateX(perspective.getX());
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
