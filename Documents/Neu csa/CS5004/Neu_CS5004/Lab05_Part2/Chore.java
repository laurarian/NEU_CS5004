/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Description: Represents a chore with a frequency and completion status for the linked list task management.
 */

public class Chore {
    private String name;
    private String frequency; // "Daily", "Weekly", "Monthly"
    private boolean isDone;

    // Constructor with arguments
    public Chore(String name, String frequency, boolean isDone) {
        this.name = name;
        this.frequency = frequency;
        this.isDone = isDone;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Chore: Name: %s - Frequency: %s - Done: %s", name, frequency, isDone ? "Yes" : "No");
    }
}
