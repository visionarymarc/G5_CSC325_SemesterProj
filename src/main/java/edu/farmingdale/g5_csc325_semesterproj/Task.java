package edu.farmingdale.g5_csc325_semesterproj;

/**
 * Represents a single task within a user's Mind Map.
 * A task includes a name, the date it was assigned, and a due date.
 */
public class Task {

    /** The name or description of the task */
    private String taskName;

    /** The date the task was assigned */
    private String dateAssigned;

    /** The due date for the task */
    private String dueDate;

    /**
     * Constructs a new Task with provided name, assigned date, and due date.
     * @param taskName the title or description of the task
     * @param dateAssigned the date the task was given or created
     * @param dueDate the expected completion date for the task
     */
    public Task(String taskName, String dateAssigned, String dueDate) {
        this.taskName = taskName;
        this.dateAssigned = dateAssigned;
        this.dueDate = dueDate;
    }

    /**
     * Returns the task name or description.
     * @return the task's name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Updates the task's name.
     * @param taskName the new name
     */
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    /**
     * Returns the assigned date of the task.
     * @return the assigned date as a string
     */
    public String getDateAssigned() {
        return dateAssigned;
    }

    /**
     * Updates the assigned date.
     * @param dateAssigned the new date
     */
    public void setDateAssigned(String dateAssigned){
        this.dateAssigned = dateAssigned;
    }

    /**
     * Returns the task's due date.
     * @return the due date
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Updates the task's due date.
     * @param dueDate the new due date
     */
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
}
