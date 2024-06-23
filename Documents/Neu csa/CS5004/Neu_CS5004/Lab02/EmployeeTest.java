/******
 * Name: Rong Huang
 * Assignment: Lab 2:Employees and Paychecks
 * Date: 1/31/2024
 * Notes: 
 *   This file tests the Employee class.
 ******/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the Employee class.
 */
public class EmployeeTest {

    private Employee employee;

    /**
     * Sets up an Employee object before each test.
     */
    @BeforeEach
    public void setUp() {
        employee = new Employee("John Doe", 20.0);
    }
    
    @AfterEach
    void tearDown() {
        Employee.setEmployeeCount(0);
    }

    /**
     * Tests whether the Employee constructor initializes the object correctly with valid arguments.
     */
    @Test
    public void testEmployeeConstructorValid() {
        assertEquals("John Doe", employee.getName());
        assertEquals(20.0, employee.getPayRate());
        assertEquals(0.0, employee.getHoursWorked());
    }

    /**
     * Tests the Employee constructor with invalid name arguments (empty and null).
     */
    @Test
    public void testEmployeeConstructorInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", 20.0));
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, 20.0));
    }

    /**
     * Tests the Employee constructor with an invalid pay rate (negative value).
     */
    @Test
    public void testEmployeeConstructorInvalidPayRate() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("John Doe", -1));
    }

    /**
     * Tests adding valid hours to the Employee's worked hours.
     */
    @Test
    public void testAddHoursValid() {
        employee.addHours(8);
        assertEquals(8.0, employee.getHoursWorked());
    }

    /**
     * Tests adding invalid hours (negative value) to the Employee's worked hours.
     */
    @Test
    public void testAddHoursInvalid() {
        assertThrows(IllegalArgumentException.class, () -> employee.addHours(-5));
    }

    /**
     * Tests resetting the Employee's worked hours to zero.
     */
    @Test
    public void testResetHoursWorked() {
        employee.addHours(8);
        employee.resetHoursWorked();
        assertEquals(0.0, employee.getHoursWorked());
    }

    /**
     * Tests calculating the weekly pay and resetting the worked hours.
     */
    @Test
    public void testGetWeeklyPay() {
        employee.addHours(40);
        Paycheck paycheck = employee.getWeeklyPay();
        assertNotNull(paycheck);
        assertEquals(0.0, employee.getHoursWorked());
    }

    /**
     * Tests calculating the weekly pay using an existing Paycheck object.
     */
    @Test
    public void testGetWeeklyPayWithPaycheck() {
        Paycheck paycheck = new Paycheck(employee, PaymentMethod.DIRECT_DEPOSIT);
        Paycheck processedPaycheck = employee.getWeeklyPay(paycheck);
        assertNotNull(processedPaycheck);
        assertEquals(0.0, employee.getHoursWorked());
    }

    /**
     * Tests calculating the weekly pay with a null Paycheck object.
     */
    @Test
    public void testGetWeeklyPayWithNullPaycheck() {
        assertThrows(NullPointerException.class, () -> employee.getWeeklyPay(null));
    }

    /**
     * Tests giving the Employee a valid pay raise.
     */
    @Test
    public void testPayRaiseValid() {
        employee.payRaise(10);
        assertEquals(22.0, employee.getPayRate());
    }

    /**
     * Tests giving the Employee an invalid pay raise (negative value).
     */
    @Test
    public void testPayRaiseInvalid() {
        assertThrows(IllegalArgumentException.class, () -> employee.payRaise(-5));
    }

    /**
     * Tests the toString method for correct string representation of the Employee object.
     */
    @Test
    public void testToString() {
        String expected = String.format("Employee Name: %s\nEmployee ID: %d\nEmployee Pay Rate: %.2f\nEmployee's Hours this Week: %.2f\n",
                "John Doe", employee.getEmployeeId(), 20.0, 0.0);
        assertEquals(expected, employee.toString());
    }

    /**
     * Tests the static method getNumEmployees to ensure it returns the correct number of Employee objects created.
     */
    @Test
    public void testStaticNumEmployees() {
        assertEquals(Employee.getEmployeeCount(), 1);
    }

    /**
     * Tests the setters and getters of the Employee class.
     */
    @Test
    public void testSettersAndGetters() {
        employee.setName("Jane Doe");
        assertEquals("Jane Doe", employee.getName());

        employee.setPayRate(25.0);
        assertEquals(25.0, employee.getPayRate());

        employee.setHoursWorked(10.0);
        assertEquals(10.0, employee.getHoursWorked());
    }
}


