package edu.farmingdale.g5_csc325_semesterproj;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskScreenController {


    @FXML
    public TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> taskNameColumn;
    @FXML
    private TableColumn<Task, String> dateAssignedColumn;
    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button addTask;
    @FXML
    private Button deleteTask;
    @FXML
    private Button editTask;

    @FXML
    private void initialize() {
        usernameLabel.setText(MindMapApp.getUsername());

        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        dateAssignedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        taskTable.setItems(AddTaskScreenController.getTask());

    }

    @FXML
    private void handleAddTask() throws IOException {
        Stage stage = (Stage) addTask.getScene().getWindow();
        MindMapApp.switchScene(stage, "add-task-screen.fxml");
    }

    @FXML
    private void handleEditTask() throws IOException {
        Stage stage = (Stage) editTask.getScene().getWindow();
        MindMapApp.switchScene(stage, "edit-task-screen.fxml");
    }

    @FXML
    private void handleDeleteTask() throws IOException {
        Stage stage = (Stage) deleteTask.getScene().getWindow();
        MindMapApp.switchScene(stage, "delete-task-screen.fxml");
    }

}
