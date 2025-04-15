package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Controller for the Sign-Up screen.
 * Allows a new user to register with a username, email, and strong password.
 */
public class SignUpScreenController {

    /** Input field for username */
    @FXML
    private TextField usernameField;

    /** Input field for email */
    @FXML
    private TextField emailField;

    /** Input field for password */
    @FXML
    private TextField passwordField;

    /** Label to display form errors or feedback */
    @FXML
    private Label errorLabel;

    /** Sign-Up button to submit the form */
    @FXML
    private Button signUpBtn;

    /** Back button to return to the splash screen */
    @FXML
    private Button backBtn1;

    /**
     * Returns the user to the splash screen without registering.
     * @throws IOException if the splash screen fails to load
     */
    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) backBtn1.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }

    /**
     * Validates input fields, checks password strength,
     * ensures uniqueness of username, and registers the user.
     * On success, sets the current user and redirects to the task screen.
     * @throws IOException if the task screen fails to load
     */
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

    /**
     * Checks password strength by ensuring it includes at least:
     * - one uppercase letter
     * - one lowercase letter
     * - one special character
     * @param password the password to evaluate
     * @return true if password is strong, false otherwise
     */
    private boolean isStrongPassword(String password) {
        return Pattern.compile(".*[A-Z].*").matcher(password).find() &&     // Uppercase
                Pattern.compile(".*[a-z].*").matcher(password).find() &&     // Lowercase
                Pattern.compile(".*[^a-zA-Z0-9].*").matcher(password).find(); // Special character
    }
}
