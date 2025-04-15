package edu.farmingdale.g5_csc325_semesterproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String username,email,password;

    //"taskList" is an Array List that stores the Task, Date, and Due Date inputs from Users.
    protected ObservableList<Task> taskList;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.taskList = FXCollections.observableArrayList();
    }

}
