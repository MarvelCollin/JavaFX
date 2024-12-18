package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;

public class Main extends Application {

    TableView<FileData> tableView;
    TableColumn<FileData, String> fileNameColumn;
    TableColumn<FileData, String> filePathColumn;
    Button openButton;
    BorderPane root;
    Scene scene;

    @Override
    public void init() {
        tableView = new TableView<>();

        // buat columnya
        fileNameColumn = new TableColumn<>("File Name");
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));

        filePathColumn = new TableColumn<>("Path");
        filePathColumn.setCellValueFactory(new PropertyValueFactory<>("filePath"));

        // tambahin columnya
        tableView.getColumns().add(fileNameColumn);
        tableView.getColumns().add(filePathColumn);

//        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        fileNameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5)); 
        filePathColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5)); 

        for (int i = 0; i < 24; i++) {
            tableView.getItems().add(new FileData("Test File " + (i + 1), "file path " + (i + 1)));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Chooser to Table");

        openButton = new Button("Open File");
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            // untuk munculin file explorer
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                tableView.getItems().add(new FileData(selectedFile.getName(), selectedFile.getAbsolutePath()));
            }
        });

        root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(openButton);

        scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
