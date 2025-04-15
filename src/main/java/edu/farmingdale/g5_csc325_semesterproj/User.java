package edu.farmingdale.g5_csc325_semesterproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a user within the Mind Map system.
 * Each user has a unique username, an email, a secure password, and their own task list.
 */
public class User {

    /** Unique username for the user */
    protected String username;

    /** Email address associated with the user account */
    protected String email;

    /** Password used to authenticate the user */
    protected String password;

    /** List of tasks that are uniquely associated with this user */
    protected ObservableList<Task> taskList;

    /**
     * Constructs a new user with credentials and initializes an empty task list.
     * @param username the user's chosen username
     * @param email the user's email address
     * @param password the user's password (must be strong and validated elsewhere)
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.taskList = FXCollections.observableArrayList();
    }

}
