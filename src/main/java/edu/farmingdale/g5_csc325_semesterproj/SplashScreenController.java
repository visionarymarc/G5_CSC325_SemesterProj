package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SplashScreenController {

    @FXML
    private Button enterBtn;

    @FXML
    private void handleEnterPress() throws IOException {
        Stage stage = (Stage) enterBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-up-screen.fxml");
    }
}
