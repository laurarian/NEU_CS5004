/******
 * Name: Rong Huang
 * Assignment: Lab 2:Employees and Paychecks
 * Date: 1/31/2024
 * Notes: 
 *   This file defines the Employee class with a name, employee ID, hours worked, and pay rate.
 ******/

/**
 * Represents an employee with a name, employee ID, hours worked, and pay rate.
 */
public class Employee {
    private static int employeeCount = 0;

    private String name;
    private int employeeId;
    private double hoursWorked;
    private double payRate;

    /**
     * Constructor to create an employee with a name and pay rate.
     * Initializes hours worked to 0 and assigns a unique employee ID.
     *
     * @param name    The name of the employee.
     * @param payRate The hourly pay rate of the employee.
     */
    public Employee(String name, double payRate) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (payRate < 0) {
            throw new IllegalArgumentException("Invalid Pay Rate.");
        }

        this.name = name;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.employeeId = ++employeeCount;
    }

    /**
     * Adds hours worked to the employee's record.
     *
     * @param hours The number of hours worked to be added.
     */
    public void addHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("You cannot add negative hours.");
        }
        this.hoursWorked += hours;
    }

    /**
     * Resets the number of hours worked to zero.
     */
    public void resetHoursWorked() {
        this.hoursWorked = 0;
    }

    /**
     * Returns a Paycheck object for the current week and resets hours worked.
     *
     * @return A new Paycheck object.
     */
    public Paycheck getWeeklyPay() {
        Paycheck paycheck = new Paycheck(this.name, this.employeeId, this.payRate, this.hoursWorked,PaymentMethod.PAPER_CHECK);
        resetHoursWorked();
        return paycheck;
    }

    /**
     * Accepts a Paycheck object, resets the hours worked, and returns the Paycheck.
     *
     * @param paycheck The Paycheck object to be processed.
     * @return The processed Paycheck object.
     */
    public Paycheck getWeeklyPay(Paycheck paycheck) {
        if (paycheck == null) {
            throw new NullPointerException("Attempted pay generation with a null check object");
        }
        resetHoursWorked();
        return paycheck;
    }

    /**
     * Increases the pay rate by a given percentage.
     *
     * @param percentage The percentage to increase the pay rate.
     */
    public void payRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("You cannot give a negative raise. Use pay cut.");
        }
        this.payRate *= (1 + percentage / 100);
    }
    
    
    /**
     * Returns a string representation of the employee.
     *
     * @return A string representation of the employee.
     */
    @Override
    public String toString() {
        return String.format("Employee Name: %s\nEmployee ID: %d\nEmployee Pay Rate: %.2f\nEmployee's Hours this Week: %.2f\n",
                name, employeeId, payRate, hoursWorked);
    }
    
    
    // Getter for employee Count
    /**
     * Gets the total number of Employee objects created.
     *
     * @return The total number of employees.
     */
    public static int getEmployeeCount() {
        return employeeCount;
    }
    
    // Setter for employee count  
    /**
     * Sets the employee count.
     *
     * @param he total number of employees.
     */
    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }
    
    // Getter for employee name
    /**
     * Gets the employee's name.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    // Setter for employee name
    /**
     * Sets the employee's name.
     *
     * @param name The new name of the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    // Getter for employee ID
    /**
     * Gets the employee's ID.
     *
     * @return The ID of the employee.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    // Employee ID does not have a setter since it's set in the constructor and unique for each employee
    

    // Getter for hours worked
    /**
     * Gets the number of hours worked by the employee.
     *
     * @return The hours worked by the employee.
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    // Setter for hours worked
    /**
     * Sets the number of hours worked by the employee.
     *
     * @param hoursWorked The new number of hours worked.
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Getter for pay rate
    /**
     * Gets the employee's pay rate.
     *
     * @return The pay rate of the employee.
     */
    public double getPayRate() {
        return payRate;
    }

    // Setter for pay rate
    /**
     * Sets the employee's pay rate.
     *
     * @param payRate The new pay rate of the employee.
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}


