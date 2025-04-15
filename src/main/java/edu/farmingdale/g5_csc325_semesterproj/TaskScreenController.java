package edu.farmingdale.g5_csc325_semesterproj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main Task screen.
 * Displays the current user's task list, supports adding, editing, and deleting tasks.
 */
public class TaskScreenController {

    /** Label showing the currently logged-in username */
    @FXML
    private Label usernameLabel;

    /** The TableView component that displays the list of tasks */
    @FXML
    public TableView<Task> taskTable;

    /** Table column for the task name */
    @FXML
    private TableColumn<Task, String> taskNameColumn;

    /** Table column for the assigned date */
    @FXML
    private TableColumn<Task, String> dateAssignedColumn;

    /** Table column for the due date */
    @FXML
    private TableColumn<Task, String> dueDateColumn;

    /** Button to add a new task */
    @FXML
    private Button addTask;

    /** Button to delete the selected task */
    @FXML
    private Button deleteTask;

    /** Button to sign out and return to splash screen */
    @FXML
    private Button signoutBtn;

    /**
     * Signs the user out by resetting the session and returning to the splash screen.
     * @throws IOException if the splash screen fails to load
     */
    @FXML
    private void handleSignOut() throws IOException {
        Stage stage = (Stage) signoutBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }

    /**
     * Initializes the Task screen.
     * Sets up column-cell mappings and populates the task table from the current user's data.
     */
    @FXML
    private void initialize() {
        // Display username
        usernameLabel.setText(MindMapApp.getUsername());

        // Set cell factories and enable in-place editing for each column
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        taskNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        taskNameColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setTaskName(event.getNewValue());
        });

        dateAssignedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));
        dateAssignedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateAssignedColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setDateAssigned(event.getNewValue());
        });

        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setDueDate(event.getNewValue());
        });

        // Display current user's task list
        taskTable.setItems(MindMapApp.getCurrentUser().taskList);
        taskTable.setEditable(true);

        // Set delete button functionality
        deleteTask.setOnAction(event -> {
            try {
                handleDeleteTask();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Switches to the Add Task screen for creating a new task.
     * @throws IOException if the Add Task screen fails to load
     */
    @FXML
    private void handleAddTask() throws IOException {
        Stage stage = (Stage) addTask.getScene().getWindow();
        MindMapApp.switchScene(stage, "add-task-screen.fxml");
    }

    /**
     * Deletes the selected task from the current user's task list.
     * If no task is selected, prints an error message to the console.
     * @throws IOException if task deletion causes an issue
     */
    @FXML
    private void handleDeleteTask() throws IOException {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskTable.getItems().remove(selectedTask);
            MindMapApp.getCurrentUser().taskList.remove(selectedTask);
        } else {
            System.out.println("There is an error deleting your selected task.");
        }
    }
}
