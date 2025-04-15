package edu.farmingdale.g5_csc325_semesterproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTaskScreenController {

    @FXML
    private TextField taskInput;
    @FXML
    private TextField dateInput;
    @FXML
    private TextField dueInput;

    @FXML
    private Button addTaskButton;
    @FXML
    private Button cancelButton;


    //"addNewTask()" method allows Users to click Add Task button to add their new tasks.
    //When clicked, it causes the User Inputs to be grabbed and set into the "taskTable" in the Home Screen.
    //Once the button is hit, the changes are made and the screen switches back to the Home Screen.
    @FXML
    public void addNewTask() throws IOException {
        Task newTask = new Task(taskInput.getText(),dateInput.getText(),dueInput.getText());

        MindMapApp.getCurrentUser().taskList.add(newTask);

        taskInput.clear();
        dateInput.clear();
        dueInput.clear();

        Stage stage = (Stage) addTaskButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }

    //"cancelAddTask()" method grants Users to click the Cancel button.
    //This would shift Users back to the Home Screen if they did not mean to click the Add Task button.
    @FXML
    private void cancelAddTask() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }
}
