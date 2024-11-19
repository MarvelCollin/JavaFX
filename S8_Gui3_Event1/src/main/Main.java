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

    private TableView<FileData> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Chooser to Table");

        tableView = new TableView<>();
        TableColumn<FileData, String> fileNameColumn = new TableColumn<>("File Name");
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));

        TableColumn<FileData, String> filePathColumn = new TableColumn<>("Path");
        filePathColumn.setCellValueFactory(new PropertyValueFactory<>("filePath"));

        tableView.getColumns().add(fileNameColumn);
        tableView.getColumns().add(filePathColumn);

        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setFitToWidth(true);

        Button openButton = new Button("Open File");
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                tableView.getItems().add(new FileData(selectedFile.getName(), selectedFile.getAbsolutePath()));
            }
        });
        
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
        tableView.getItems().add(new FileData("tetstt", "file path nya"));
	    tableView.getItems().add(new FileData("tetstt", "file path nya"));
        
        BorderPane root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(openButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class FileData {
        private String fileName;
        private String filePath;

        public FileData(String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public String getFilePath() {
            return filePath;
        }
    }
}