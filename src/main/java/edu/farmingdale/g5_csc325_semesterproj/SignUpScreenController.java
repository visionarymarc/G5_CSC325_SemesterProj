package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class SignUpScreenController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField; // <-- Add a password field to the FXML

    @FXML
    private Button signUpBtn;

    @FXML
    private Button backBtn1;

    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) backBtn1.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }


    @FXML
    private void handleSignUp() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty!");
            return;
        }

        if (MindMapApp.getUsers().containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        MindMapApp.getUsers().put(username, password);
        MindMapApp.setUsername(username); // Set the logged-in user
        Stage stage = (Stage) signUpBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }
}
