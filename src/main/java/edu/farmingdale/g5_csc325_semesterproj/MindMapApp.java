package edu.farmingdale.g5_csc325_semesterproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.IOException;

/**
 * Main class for the Mind Map application.
 * Handles screen transitions, session management, and user registry.
 */
public class MindMapApp extends Application {

    /** Stores all registered users mapped by their usernames */
    protected static final HashMap<String, User> users = new HashMap<>();

    /** The username of the currently logged-in user */
    private static String username = "";

    /**
     * Returns the entire user registry.
     * @return HashMap of all users by username
     */
    public static HashMap<String, User> getUsers() {
        return users;
    }

    /**
     * Retrieves a specific user by username.
     * @param username the username key
     * @return the User object if found, else null
     */
    public static User getUser(String username) {
        return users.get(username);
    }

    /**
     * Gets the currently signed-in user.
     * @return the active User object
     */
    public static User getCurrentUser() {
        return users.get(username);
    }

    /**
     * Sets the current session's username.
     * @param name the username of the logged-in user
     */
    public static void setUsername(String name) {
        username = name;
    }

    /**
     * Returns the current session's username.
     * @return active username string
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Replaces the current window scene with the given FXML screen.
     * @param stage the current stage
     * @param fxmlFile the target FXML file
     * @throws IOException if the FXML cannot be loaded
     */
    public static void switchScene(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MindMapApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 450, 700);
        stage.setScene(scene);
    }

    /**
     * Entry point of the JavaFX application.
     * Loads and displays the splash screen.
     */
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
