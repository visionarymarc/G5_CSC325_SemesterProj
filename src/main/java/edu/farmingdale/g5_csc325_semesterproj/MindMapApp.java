package edu.farmingdale.g5_csc325_semesterproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.IOException;

public class MindMapApp extends Application {

    // Updated: store full User objects
    private static final HashMap<String, User> users = new HashMap<>();

    // Getter for users
    public static HashMap<String, User> getUsers() {
        return users;
    }

    // Get specific user by username
    public static User getUser(String username) {
        return users.get(username);
    }

    // Store logged-in username
    private static String username = "";

    // Setter and Getter for logged-in username
    public static void setUsername(String name) {
        username = name;
    }

    public static String getUsername() {
        return username;
    }

    // Scene switching logic
    public static void switchScene(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MindMapApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setScene(scene);
    }

    // Launch splash screen on app start
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MindMapApp.class.getResource("splash-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setTitle("Mind Map!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
