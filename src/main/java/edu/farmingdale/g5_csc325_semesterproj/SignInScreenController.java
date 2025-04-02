package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInScreenController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

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

        if (!MindMapApp.getUsers().containsKey(username)) {
            System.out.println("Username not found!");
            return;
        }

        if (!MindMapApp.getUsers().get(username).equals(password)) {
            System.out.println("Incorrect password!");
            return;
        }

        MindMapApp.setUsername(username);
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }
}
