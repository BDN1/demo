package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        PerspectiveView perspectiveView = new PerspectiveView();
        ThumbnailView thumbnailView = new ThumbnailView();

        HBox root = new HBox(20, perspectiveView.getView(), thumbnailView); 


        root.setStyle("-fx-alignment: center;");


        Scene scene = new Scene(root, 800, 400); 

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
}
