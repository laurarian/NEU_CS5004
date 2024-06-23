/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Represents a task with details such as ID, description, due date, completion status, and priority.
 * Allows for task management by providing methods to set and get task attributes,including a string representation.
 */
public class Task {
    private int ID;
    private String description;
    private Date date;
    private Boolean completed;
    private Priority priority;

    // Constructor with arguments
    public Task(int ID, String description, Date date, Boolean completed, Priority priority) {
        this.ID = ID;
        this.description = description;
        this.date = date;
        this.completed = completed;
        this.priority = priority;
    }

    // Getter and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Task: ID: %d - Date: %s - Description: %s - Priority: %s - Completed: %s",
                ID, date, description, priority, completed ? "Yes" : "No");
    }
}
