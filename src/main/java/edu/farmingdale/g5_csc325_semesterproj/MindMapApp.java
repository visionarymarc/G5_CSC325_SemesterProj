package edu.farmingdale.g5_csc325_semesterproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.IOException;

public class MindMapApp extends Application {

    // Add this at the class level
    private static final HashMap<String, String> users = new HashMap<>();

    // Getter for users
    public static HashMap<String, String> getUsers() {
        return users;
    }

    // Store "username" temporarily to display on Home Screen.
    private static String username = "";

    //"start" method launches the first screen to access Mind Map.
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MindMapApp.class.getResource("splash-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setTitle("Mind Map!");
        stage.setScene(scene);
        stage.show();
    }

    //This is the Setter and Getter for the Username to be displayed in the Home Screen.
    public static void setUsername(String name) {
        username = name;
    }
    public static String getUsername() {
        return username;
    }

    //"switchScene" method allows for certain sections of the project to switch screens.
    public static void switchScene(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MindMapApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setScene(scene);
    }

    public static void main(String[] args){
        launch();
    }
}
