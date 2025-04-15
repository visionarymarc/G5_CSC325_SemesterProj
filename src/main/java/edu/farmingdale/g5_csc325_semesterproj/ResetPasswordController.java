package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class ResetPasswordController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField codeField;

    @FXML
    private Label resultLabel;

    private String expectedCode;
    private User foundUser;

    // Generate a 4-digit verification code and "send" it (print it out)
    @FXML
    private void handleSendCode() {
        String emailInput = emailField.getText().trim();

        // Search for user by email
        for (Map.Entry<String, User> entry : MindMapApp.getUsers().entrySet()) {
            if (entry.getValue().getEmail().equalsIgnoreCase(emailInput)) {
                foundUser = entry.getValue();
                expectedCode = String.format("%04d", new Random().nextInt(10000));
                resultLabel.setText("Verification code: " + expectedCode + " (pretend this was emailed)");
                return;
            }
        }

        resultLabel.setText("Email not found.");
    }

    // Check the code and reveal credentials
    @FXML
    private void handleVerifyCode() {
        String codeInput = codeField.getText().trim();

        if (foundUser == null) {
            resultLabel.setText("Please enter your email and get the code first.");
            return;
        }

        if (codeInput.equals(expectedCode)) {
            resultLabel.setText("✅ Username: " + foundUser.getUsername() + "\nPassword: " + foundUser.getPassword());
        } else {
            resultLabel.setText("❌ Incorrect verification code.");
        }
    }

    @FXML
    private void handleBack() throws IOException {
        Stage stage = (Stage) emailField.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-in-screen.fxml");
    }
}
