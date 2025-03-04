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
    private Button signUpBtn;

    @FXML
    private void handleSignUp() throws IOException {
        String username = usernameField.getText().trim();
        if (!username.isEmpty()) {
            MindMapApp.setUsername(username);
            Stage stage = (Stage) signUpBtn.getScene().getWindow();
            MindMapApp.switchScene(stage, "task-screen.fxml");
        }
    }
}
