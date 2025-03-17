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

    private static ObservableList<Task> taskList = FXCollections.observableArrayList();

    public static ObservableList<Task> getTask(){
        return taskList;
    }

    @FXML
    public void addNewTask() throws IOException {
        Task newTask = new Task(taskInput.getText(),dateInput.getText(),dueInput.getText());

        AddTaskScreenController.getTask().add(newTask);

        taskInput.clear();
        dateInput.clear();
        dueInput.clear();

        Stage stage = (Stage) addTaskButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }

    @FXML
    private void cancelAddTask() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }
}
