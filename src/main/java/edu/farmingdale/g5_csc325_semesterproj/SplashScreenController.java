package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller for the Splash Screen.
 * Allows users to choose between signing in or signing up.
 */
public class SplashScreenController {

    /** Button to go to the Sign-In screen */
    @FXML
    private Button inBtn;

    /** Button to go to the Sign-Up screen */
    @FXML
    private Button upBtn;

    /**
     * Handles the transition to the Sign-In screen when the Sign In button is clicked.
     * @throws IOException if the Sign-In screen fails to load
     */
    @FXML
    private void goToSignIn() throws IOException {
        Stage stage = (Stage) inBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-in-screen.fxml");
    }

    /**
     * Handles the transition to the Sign-Up screen when the Sign Up button is clicked.
     * @throws IOException if the Sign-Up screen fails to load
     */
    @FXML
    private void goToSignUp() throws IOException {
        Stage stage = (Stage) upBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "sign-up-screen.fxml");
    }
}
