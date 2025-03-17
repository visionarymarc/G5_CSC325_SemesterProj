package edu.farmingdale.g5_csc325_semesterproj;

public class Task {
    private String taskName;
    private String dateAssigned;
    private String dueDate;

    public Task(String taskName, String dateAssigned, String dueDate) {
        this.taskName = taskName;
        this.dateAssigned = dateAssigned;
        this.dueDate = dueDate;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public String getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(String dateAssigned){
        this.dateAssigned = dateAssigned;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
}
