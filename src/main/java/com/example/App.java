package com.example;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
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
        
        BorderPane root = new BorderPane();

        root.setCenter(new HBox(20,thumbnailView.getView(),perspectiveView.getView(), perspectiveView2.getView()));
        MenuBar menuBar = createMenuBar(perspectiveView, perspectiveView2, thumbnailView);

        root.setTop(menuBar);

        root.setStyle("-fx-alignment: center;");


        Scene scene = new Scene(root, 600, 400); 

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    private MenuBar createMenuBar(PerspectiveView perspectiveView, PerspectiveView perspectiveView2, ThumbnailView thumbnailView){
        Menu fileMenu = new Menu("File");

        // Create the "Upload" menu item
        MenuItem uploadItem = new MenuItem("Upload Image");
        uploadItem.setOnAction(e -> handleUploadImage(perspectiveView, perspectiveView2, thumbnailView));

        // Add the "Upload" item to the "File" menu
        fileMenu.getItems().add(uploadItem);

        // Create the menu bar and add the "File" menu
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        return menuBar;
    }
    private void handleUploadImage(PerspectiveView perspectiveView, PerspectiveView perspectiveView2, ThumbnailView thumbnailView) {
        // Open the FileChooser to select an image file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));

        // Show the open file dialog
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            // Load the image into both the PerspectiveViews and ThumbnailView
            perspectiveView.loadImage(selectedFile);
            perspectiveView2.loadImage(selectedFile);
            thumbnailView.loadImage(selectedFile);
        }
    }
}
