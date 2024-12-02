package com.example;

import java.io.File;

import com.example.Command.CommandManager;
import com.example.Vue.PerspectiveView;
import com.example.Vue.ThumbnailView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }
    private CommandManager commandManager = CommandManager.getInstance();

    @Override
    public void start(Stage stage) throws Exception {
        PerspectiveView perspectiveView = new PerspectiveView();
        PerspectiveView perspectiveView2 = new PerspectiveView();
        ThumbnailView thumbnailView = new ThumbnailView();
        
        

        BorderPane root = new BorderPane();

        HBox centerBox = new HBox(20, thumbnailView.getView(), perspectiveView.getView(), perspectiveView2.getView());
        root.setCenter(centerBox);

        MenuBar menuBar = createMenuBar(perspectiveView, perspectiveView2, thumbnailView);
        root.setTop(menuBar);

        root.setStyle("-fx-alignment: center;");

        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth() * 0.9,
                Screen.getPrimary().getBounds().getHeight() * 0.9);

        stage.setTitle("Test");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private MenuBar createMenuBar(PerspectiveView perspectiveView, PerspectiveView perspectiveView2,
            ThumbnailView thumbnailView) {
        Menu fileMenu = new Menu("Fichier");
        Menu edition = new Menu("Édition");

        // Create the "Upload" menu item
        MenuItem uploadItem = new MenuItem("Charger image");
        uploadItem.setOnAction(e -> handleUploadImage(perspectiveView, perspectiveView2, thumbnailView));

        MenuItem undo = new MenuItem("Défaire");
        undo.setOnAction(e -> commandManager.undoLastCommand());
        MenuItem redo = new MenuItem("Refaire");
        redo.setOnAction(e -> commandManager.redoLastCommand());
        // redo.setOnAction(e -> redo());

        // Add the "Upload" item to the "File" menu
        fileMenu.getItems().add(uploadItem);
        edition.getItems().add(undo);
        edition.getItems().add(redo);

        // Create the menu bar and add the "File" menu
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(edition);

        return menuBar;
    }

    private void handleUploadImage(PerspectiveView perspectiveView, PerspectiveView perspectiveView2,
            ThumbnailView thumbnailView) {
        // Open the FileChooser to select an image file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));

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