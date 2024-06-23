/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This class represents a Meeting with attributes like name, location, date, and duration.
 */

public class Meeting {
    private String name;
    private String location;
    private Date date;
    private double duration; // in hours

    // Constructor with arguments
    public Meeting(String name, String location, int year, int month, int day, int hour, int minute, double duration) {
        this.name = name;
        this.location = location;
        this.date = new Date(year, month, day, hour, minute); // Date validation is handled within the Date class
        this.duration = duration;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("Meeting: Name: %s - Location: %s - Date: %s - Duration: %.2f hours", name, location, date, duration);
    }
}
