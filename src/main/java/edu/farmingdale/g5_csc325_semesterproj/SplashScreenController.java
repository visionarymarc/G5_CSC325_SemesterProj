package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SplashScreenController {

    @FXML
    private Button inBtn;
    @FXML
    private Button upBtn;

    @FXML
    private void goToSignIn() throws IOException {
        Stage stage = (Stage) inBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-in-screen.fxml");
    }

    @FXML
    private void goToSignUp() throws IOException {
        Stage stage = (Stage)  upBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-up-screen.fxml");
    }

}
