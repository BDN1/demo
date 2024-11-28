package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Perspective perspective = new Perspective();
        PerspectiveView perspectiveView = new PerspectiveView();
        ImageController imageController = new ImageController(perspective, perspectiveView);

        stage.setTitle("Test");
        stage.setScene(perspectiveView.getScene());
        stage.show();
    }

}