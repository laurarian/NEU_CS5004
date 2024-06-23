/**
 * Name:Rong Huang
 * Assignment: Lab 5 Part 2
 * Date:2024-03-20
 * Defines a date and time, ensuring all parts are within valid ranges. Includes functionality
 * to compare dates and format them as strings.
 */

public class Date {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    // Constructor with arguments
    // Throws IllegalArgumentException if the provided values are not within expected ranges.
    public Date(int year, int month, int day, int hour, int minute) {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31 || hour < 0 ||
                hour > 23 || minute < 0 || minute > 59){
            throw new IllegalArgumentException("Invalid date");
        }

        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    // Getter and Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%d/%d/%d %02d:%02d", year, month, day, hour, minute);
    }


    // Method to check if this date is before the other date.
    public boolean isBefore(Date other) {
        if (this.year != other.year) return this.year < other.year;
        if (this.month != other.month) return this.month < other.month;
        if (this.day != other.day) return this.day < other.day;
        if (this.hour != other.hour) return this.hour < other.hour;
        return this.minute < other.minute;
    }
}
