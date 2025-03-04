package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TaskScreenController {

    @FXML
    private Label usernameLabel;

    @FXML
    private void initialize() {
        usernameLabel.setText("User: " + MindMapApp.getUsername());
    }
}
