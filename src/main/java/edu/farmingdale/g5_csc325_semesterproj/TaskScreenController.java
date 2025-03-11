package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskScreenController {

    @FXML
    private Label usernameLabel;

    @FXML
    private Button addTskBtn;

    @FXML
    private void initialize() {
        usernameLabel.setText("User: " + MindMapApp.getUsername());
    }

    @FXML
    private void handleAddTask() throws IOException {
        Stage stage = (Stage) addTskBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "add-task-screen.fxml");
    }
}
