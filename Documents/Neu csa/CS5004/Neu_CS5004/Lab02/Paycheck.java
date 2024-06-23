/******
 * Name: Rong Huang
 * Assignment: Lab 2:Employees and Paychecks
 * Date: 1/31/2024
 * Notes: 
 *   This file defines the Paycheck class.
 ******/

/**
 * Represents a paycheck for an employee, including total pay calculation.
 */
public class Paycheck {
    private String employeeName;
    private int employeeId;
    private double payRate;
    private double hoursWorked;
    private double totalPay;
    private PaymentMethod paymentMethod;

    /**
     * Constructs a Paycheck with specified employee details and calculates the total pay.
     *
     * @param employeeName the name of the employee
     * @param employeeId   the ID of the employee
     * @param payRate         the pay rate of the employee
     * @param hoursWorked  the hours worked by the employee
     */
    public Paycheck(String employeeName, int employeeId, double payRate, double hoursWorked, PaymentMethod paymentMethod) {
        if (payRate <= 0) {
            throw new IllegalArgumentException("Pay rate must be positive.");
        }
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.paymentMethod = paymentMethod;
        calculateTotalPay();
    }

    /**
     * Constructs a Paycheck based on an Employee object and calculates the total pay.
     *
     * @param employee the Employee object
     */
    public Paycheck(Employee employee,PaymentMethod paymentMethod) {
        if (employee == null) {
            throw new NullPointerException("Attempted a check load with a null employee object");
        }
        this.employeeName = employee.getName();
        this.employeeId = employee.getEmployeeId();
        this.payRate = employee.getPayRate();
        this.hoursWorked = employee.getHoursWorked();
        this.paymentMethod = paymentMethod;
        calculateTotalPay();
    }

    /**
     * Constructs an empty Paycheck. Does not initialize variables or calculate pay.
     */
    public Paycheck() {

    }

    /**
     * Calculates the total pay based on hours worked and pay rate, including overtime.
     */
    private void calculateTotalPay() {
        if (hoursWorked <= 40) {
            totalPay = hoursWorked * payRate;
        } else {
            totalPay = 40 * payRate + (hoursWorked - 40) * payRate * 1.5;
        }
    }

    public void loadCheck(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Attempted a check load with a null employee object");
        }
        this.employeeName = employee.getName();
        this.employeeId = employee.getEmployeeId();
        this.payRate = employee.getPayRate();
        this.hoursWorked = employee.getHoursWorked();
        calculateTotalPay();
    }

    /**
     * Get the name of the employee.
     *
     * @return the name of the employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Set the name of the employee.
     *
     * @param employeeName the name of the employee
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Get the ID of the employee.
     *
     * @return the ID of the employee
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the ID of the employee.
     *
     * @param employeeId the ID of the employee
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get the pay rate of the employee.
     *
     * @return the pay rate of the employee
     */
    public double getRate() {
        return payRate;
    }

    /**
     * Set the pay rate of the employee.
     *
     * @param rate the pay rate of the employee
     */
    public void setRate(double rate) {
        this.payRate = rate;
    }

    /**
     * Get the number of hours worked by the employee.
     *
     * @return the number of hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Set the number of hours worked by the employee.
     *
     * @param hoursWorked the number of hours worked
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Get the total pay of the employee.
     *
     * @return the total pay
     */
    public double getTotalPay() {
        return totalPay;
    }

    /**
     * Set the total pay of the employee.
     *
     * @param totalPay the total pay
     */
    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    /**
     *
     * Gets the employee's payment method.
     *
     * @return The payment method of the employee.
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the employee's payment method.
     *
     * @param paymentMethod The new payment method of the employee.
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return String.format("* %s's Paycheck. Id#: %d *\nPay Rate: %.2f\nHours: %.2f\nTotal Pay: $%.2f\nPayment Method: %s",
                employeeName, employeeId, payRate, hoursWorked, totalPay,paymentMethod);
    }
}
