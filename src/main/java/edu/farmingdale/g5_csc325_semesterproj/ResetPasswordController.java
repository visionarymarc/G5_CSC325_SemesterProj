package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * Controller for the Reset Password screen.
 * Allows users to recover their username and password using a verification code tied to their email.
 */
public class ResetPasswordController {

    /** TextField for user to input their registered email */
    @FXML
    private TextField emailField;

    /** TextField to input the received 4-digit verification code */
    @FXML
    private TextField codeField;

    /** Label for displaying results and feedback */
    @FXML
    private Label resultLabel;

    /** Stores the generated verification code */
    private String expectedCode;

    /** The user found via the submitted email */
    private User foundUser;

    /**
     * Generates and displays a mock 4-digit verification code if the provided email matches a user.
     * Pretends to "email" the code and displays it on screen for demo purposes.
     */
    @FXML
    private void handleSendCode() {
        String emailInput = emailField.getText().trim();

        // Search for user by email
        for (Map.Entry<String, User> entry : MindMapApp.getUsers().entrySet()) {
            if (entry.getValue().email.equalsIgnoreCase(emailInput)) {
                foundUser = entry.getValue();
                expectedCode = String.format("%04d", new Random().nextInt(10000));
                resultLabel.setText("Verification code: " + expectedCode + " (pretend this was emailed)");
                return;
            }
        }

        resultLabel.setText("Email not found.");
    }

    /**
     * Verifies the 4-digit code input against the generated one.
     * If matched, displays the user's username and password.
     */
    @FXML
    private void handleVerifyCode() {
        String codeInput = codeField.getText().trim();

        if (foundUser == null) {
            resultLabel.setText("Please enter your email and get the code first.");
            return;
        }

        if (codeInput.equals(expectedCode)) {
            resultLabel.setText("✅ Username: " + foundUser.username + "\nPassword: " + foundUser.password);
        } else {
            resultLabel.setText("❌ Incorrect verification code.");
        }
    }

    /**
     * Returns the user to the Sign-In screen.
     * @throws IOException if the sign-in screen fails to load
     */
    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) emailField.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-in-screen.fxml");
    }
}
