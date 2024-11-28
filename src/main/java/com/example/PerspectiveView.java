package com.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PerspectiveView extends ImageView implements Observer{
    private ImageView imageView;
    private ImageModel image;
    private Perspective perspective;
    private ImageController controller;

    public PerspectiveView(){
        image = new ImageModel();
        imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        Button translateLeft = new Button("<-");
        Button zoomIn = new Button("Zoom In");
        Button zoomOut = new Button("Zoom Out");
        Button translateRight = new Button("->");

        VBox vb = new VBox(10,imageView,translateLeft,zoomIn,zoomOut,translateRight);
        vb.setAlignment(Pos.BOTTOM_CENTER);
    }

    public void incrementX(){
        
    }
    public void decrementX(){

    }
    public void incrementZoom(){

    }
    public void decrementZoom(){
        
    }

    @Override
    public void update() {
        imageView.setFitWidth(image.getImage().getWidth() * perspective.getScale());
        imageView.setFitHeight(image.getImage().getHeight() * perspective.getScale());

        imageView.setTranslateX(perspective.getX());

        //manque les y ???
    }



}
