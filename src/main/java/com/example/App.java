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
        PerspectiveView perspectiveView2 = new PerspectiveView();
        ThumbnailView thumbnailView = new ThumbnailView();

        HBox root = new HBox(20,thumbnailView.getView(),perspectiveView.getView(), perspectiveView2.getView()); 


        root.setStyle("-fx-alignment: center;");


        Scene scene = new Scene(root, 600, 400); 

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
}
