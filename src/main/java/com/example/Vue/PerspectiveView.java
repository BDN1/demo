package com.example.Vue;

import java.io.File;
import com.example.Controleur.ImageController;
import com.example.Modele.ImageModel;
import com.example.Modele.Perspective;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

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

    double screenHeight = Screen.getPrimary().getBounds().getHeight();
    double screenWidth = Screen.getPrimary().getBounds().getWidth();

    public PerspectiveView() {
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(screenHeight * 0.9);
        imageView.setFitWidth(screenWidth  / 3.1);
        imageView.setPreserveRatio(false);

        // Apply border style directly to the ImageView
        imageView.setStyle("-fx-border-color: blue; -fx-border-width: 5;");

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
        //hb.setPadding(new Insets(0, 20, 0, 20)); // Add padding to the HBox

        HBox buttonBox = new HBox(10, translateLeft, translateUp, zoomIn, zoomOut, translateRight, translateDown);
        buttonBox.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10, hb, buttonBox);
        vb.setAlignment(Pos.CENTER);
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
            imageView.setImage(image.getImage());
        } else {
            System.err.println("Image not loaded correctly.");
        }
    }
}