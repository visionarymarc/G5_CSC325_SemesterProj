package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the Sign-In screen.
 * Handles user authentication and navigation to other screens.
 */
public class SignInScreenController {

    /** Input field for username */
    @FXML
    private TextField usernameField;

    /** Input field for password */
    @FXML
    private TextField passwordField;

    /** Label for displaying login errors */
    @FXML
    private Label errorLabel;

    /** Button to submit sign-in credentials */
    @FXML
    private Button signInBtn;

    /** Button to return to the splash screen */
    @FXML
    private Button backBtn2;

    /**
     * Returns the user to the splash screen.
     * @throws IOException if the splash screen fails to load
     */
    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) backBtn2.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }

    /**
     * Authenticates user credentials and logs them into their account.
     * If successful, routes the user to the task screen.
     * Displays errors on-screen if validation fails.
     * @throws IOException if task screen fails to load
     */
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

    /**
     * Navigates to the Reset Password screen if the user forgot credentials.
     * @throws IOException if the screen fails to load
     */
    @FXML
    private void handleResetPassword() throws IOException {
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "reset-password-screen.fxml");
    }
}
