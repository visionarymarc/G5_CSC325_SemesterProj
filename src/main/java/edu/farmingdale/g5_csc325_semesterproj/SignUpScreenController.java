package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class SignUpScreenController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

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
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("All fields are required.");
            return;
        }

        if (!isStrongPassword(password)) {
            errorLabel.setText("Password must include 1 uppercase, 1 lowercase, and 1 special character.");
            return;
        }

        if (MindMapApp.getUsers().containsKey(username)) {
            errorLabel.setText("Username already exists!");
            return;
        }

        // Create and store user
        User newUser = new User(username, email, password);
        MindMapApp.users.put(username, newUser);
        MindMapApp.setUsername(username);

        Stage stage = (Stage) signUpBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }

    // Utility: check password strength
    private boolean isStrongPassword(String password) {
        return Pattern.compile(".*[A-Z].*").matcher(password).find() &&     // Uppercase
                Pattern.compile(".*[a-z].*").matcher(password).find() &&     // Lowercase
                Pattern.compile(".*[^a-zA-Z0-9].*").matcher(password).find(); // Special character
    }
}
