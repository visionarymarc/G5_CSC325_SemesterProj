package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInScreenController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button signInBtn;

    @FXML
    private Button backBtn2;

    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) backBtn2.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }

    @FXML
    private void handleSignIn() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password.");
            return;
        }

        if (!MindMapApp.getUsers().containsKey(username)) {
            errorLabel.setText("Username not found.");
            return;
        }

        User user = MindMapApp.getUser(username);
        if (!user.password.equals(password)) {
            errorLabel.setText("Incorrect password.");
            return;
        }

        MindMapApp.setUsername(username);
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }

    @FXML
    private void handleResetPassword() throws IOException {
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "reset-password-screen.fxml");
    }

}
