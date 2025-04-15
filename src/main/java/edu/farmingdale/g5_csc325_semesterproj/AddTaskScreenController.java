package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller class for the Add Task screen.
 * Handles task creation and returning to the Task screen.
 */
public class AddTaskScreenController {

    /** Input field for the task name */
    @FXML
    private TextField taskInput;

    /** Input field for the assigned date */
    @FXML
    private TextField dateInput;

    /** Input field for the due date */
    @FXML
    private TextField dueInput;

    /** Button to confirm adding the task */
    @FXML
    private Button addTaskButton;

    /** Button to cancel and return to the task list screen */
    @FXML
    private Button cancelButton;

    /**
     * Handles the logic to add a new task to the current user's task list.
     * Validates input and redirects the user back to the Task screen.
     * @throws IOException if the Task screen fails to load
     */
    @FXML
    public void addNewTask() throws IOException {
        Task newTask = new Task(taskInput.getText(), dateInput.getText(), dueInput.getText());
        MindMapApp.getCurrentUser().taskList.add(newTask);

        taskInput.clear();
        dateInput.clear();
        dueInput.clear();

        Stage stage = (Stage) addTaskButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }

    /**
     * Cancels task creation and returns to the Task screen without saving input.
     * @throws IOException if the Task screen fails to load
     */
    @FXML
    private void cancelAddTask() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        MindMapApp.switchScene(stage, "task-screen.fxml");
    }
}
