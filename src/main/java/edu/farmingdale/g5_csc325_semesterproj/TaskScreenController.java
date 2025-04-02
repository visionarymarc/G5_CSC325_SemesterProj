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

public class TaskScreenController {

    @FXML
    private Label usernameLabel;

    @FXML
    public TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> taskNameColumn;
    @FXML
    private TableColumn<Task, String> dateAssignedColumn;
    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private Button addTask;
    @FXML
    private Button deleteTask;

    @FXML
    private Button signoutBtn;

    @FXML
    private void handleSignOut() throws IOException {
        Stage stage = (Stage) signoutBtn.getScene().getWindow();
        MindMapApp.switchScene(stage, "splash-screen.fxml");
    }

    @FXML
    private void initialize() {

        //Username can only contain a maximum of 18 characters for full display (including spaces).
        //Username Input when application first starts is grabbed and set as the "usernameLabel".
        //Username will then be displayed in the Home Screen.
        usernameLabel.setText(MindMapApp.getUsername());

        //This section with "taskNameColumn" grabs User input and stores it in the "taskNameColumn".
        //Also included is the option to edit the specific field in the "taskNameColumn".
        //Simply double-click the field of your choosing, and you enter the new data in that field.
        //Once the new data replaces the old one, hit enter right after to save the new set data.
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        taskNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        taskNameColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setTaskName(event.getNewValue());
        });

        //This section with "dateAssignedColumn" grabs User input and stores it in the "dateAssignedColumn".
        //Also included is the option to edit the field, same steps to follow just like in "taskNameColumn".
        dateAssignedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));
        dateAssignedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateAssignedColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setDateAssigned(event.getNewValue());
        });

        //This section with "dueDateColumn" grabs User input and stores it in the "dueDateColumn".
        //Also included is the option to edit the field, same steps to follow just like in "taskNameColumn".
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateColumn.setOnEditCommit(event -> {
            Task task = event.getRowValue();
            task.setDueDate(event.getNewValue());
        });

        //The items(User Inputs) are grabbed from the "AddTaskScreenController" and set in the taskTable.
        //Every added task is displayed in the Home Screen where "taskTable" is located.
        taskTable.setItems(AddTaskScreenController.getTask());

        //This allows for the fields in each column in "taskTable" to be double-clicked and edited.
        taskTable.setEditable(true);

        //"deleteTask" is the name of the Delete Task button which allows Users to delete a selected row.
        deleteTask.setOnAction(event -> {
            try {
                handleDeleteTask();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    //"handleAddTask()" allows Users to click the Add Task Button and switch to another screen.
    //This allows Users to add new information to display on the "taskTable" on the Home Screen.
    @FXML
    private void handleAddTask() throws IOException {
        Stage stage = (Stage) addTask.getScene().getWindow();
        MindMapApp.switchScene(stage, "add-task-screen.fxml");
    }

    //"handleDeleteTask()" allows Users to click the Delete Task button to delete selected tasks.
    //Simply click the row on "taskTable" that you would like to delete, and click Delete Task to delete it.
    @FXML
    private void handleDeleteTask() throws IOException {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskTable.getItems().remove(selectedTask);
            AddTaskScreenController.getTask().remove(selectedTask);
        }
        else {
            System.out.println("There is an error deleting your selected task.");
        }
    }

}

