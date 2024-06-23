/******
 * Name: Rong Huang
 * Assignment: Lab 2:Employees and Paychecks
 * Date: 1/31/2024
 * Notes: 
 *   This file tests the Paycheck class.
 ******/

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Paycheck class.
 */
public class PaycheckTest {

    private Employee employee;
    private Paycheck paycheck;

    /**
     * Sets up the environment for each test. This method is called before each test method.
     */
    @Before
    public void setUp() {
        Employee.setEmployeeCount(0);
        employee = new Employee("John Doe", 20.0);
        employee.addHours(45); // Adding 45 hours, 5 of which should be overtime
        paycheck = new Paycheck(employee, PaymentMethod.DIRECT_DEPOSIT);
    }

    /**
     * Cleans up after each test. This method is called after each test method.
     */
    @After
    public void tearDown() {
        Employee.setEmployeeCount(0);
    }
    
    /**
     * Tests the Paycheck constructor with valid employee details and no overtime.
     */
    @Test
    public void testConstructorWithValidDetailsNoOvertime() {
        Paycheck paycheck = new Paycheck("John Doe", 1, 20.0, 40, PaymentMethod.DIRECT_DEPOSIT);
        assertEquals("John Doe", paycheck.getEmployeeName());
        assertEquals(1, paycheck.getEmployeeId());
        assertEquals(20.0, paycheck.getRate(), 0.001);
        assertEquals(40.0, paycheck.getHoursWorked(), 0.001);
        assertEquals(800.0, paycheck.getTotalPay(), 0.001); // 40 hours * $20/hour
        assertEquals(PaymentMethod.DIRECT_DEPOSIT, paycheck.getPaymentMethod());
    }

    /**
     * Tests the Paycheck constructor with valid employee details and overtime.
     */
    @Test
    public void testConstructorWithValidDetailsOvertime() {
        Paycheck paycheck = new Paycheck("Jane Doe", 2, 20.0, 45, PaymentMethod.PAPER_CHECK);
        assertEquals("Jane Doe", paycheck.getEmployeeName());
        assertEquals(2, paycheck.getEmployeeId());
        assertEquals(20.0, paycheck.getRate(), 0.001);
        assertEquals(45.0, paycheck.getHoursWorked(), 0.001);
        assertEquals(950.0, paycheck.getTotalPay(), 0.001); // 40 * $20 + 5 * $30 (overtime)
        assertEquals(PaymentMethod.PAPER_CHECK, paycheck.getPaymentMethod());
    }

    /**
     * Tests the Paycheck constructor with a negative pay rate.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativePayRate() {
        new Paycheck("John Doe", 1, -20.0, 40, PaymentMethod.DIRECT_DEPOSIT);
    }

    /**
     * Tests the Paycheck constructor with negative hours worked.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeHoursWorked() {
        new Paycheck("John Doe", 1, 20.0, -40, PaymentMethod.DIRECT_DEPOSIT);
    }

    
    /**
     * Tests the Paycheck constructor with an Employee object.
     */
    @Test
    public void testConstructorWithEmployee() {
        paycheck = new Paycheck(employee, PaymentMethod.DIRECT_DEPOSIT);
        assertNotNull(paycheck);
        assertEquals(employee.getName(), paycheck.getEmployeeName());
        assertEquals(employee.getEmployeeId(), paycheck.getEmployeeId());
        assertEquals(employee.getPayRate(), paycheck.getRate(), 0.001);
        assertEquals(employee.getHoursWorked(), paycheck.getHoursWorked(), 0.001);
        assertEquals(PaymentMethod.DIRECT_DEPOSIT, paycheck.getPaymentMethod());
    }
    
    /**
     * Tests the default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        Paycheck defaultPaycheck = new Paycheck();
        assertNotNull(defaultPaycheck);
        assertNull(defaultPaycheck.getEmployeeName());
        assertEquals(0, defaultPaycheck.getEmployeeId());
        assertEquals(0.0, defaultPaycheck.getRate(), 0.001);
        assertEquals(0.0, defaultPaycheck.getHoursWorked(), 0.001);
        assertEquals(0.0, defaultPaycheck.getTotalPay(), 0.001);
        assertNull(defaultPaycheck.getPaymentMethod());
    }
    
    /**
     * Tests the correct calculation of total pay with overtime.
     */
    @Test
    public void testCalculateTotalPayWithOvertime() {
        employee.setHoursWorked(45); // 45 hours, including 5 hours of overtime
        paycheck = new Paycheck(employee, PaymentMethod.DIRECT_DEPOSIT);
        double expectedTotalPay = 40 * 20.0 + 5 * 20.0 * 1.5;
        assertEquals(expectedTotalPay, paycheck.getTotalPay(), 0.001);
    }

    /**
     * Tests the correct calculation of total pay without overtime.
     */
    @Test
    public void testCalculateTotalPayWithoutOvertime() {
        employee.setHoursWorked(30); // 30 hours, no overtime
        paycheck = new Paycheck(employee, PaymentMethod.DIRECT_DEPOSIT);
        double expectedTotalPay = 30 * 20.0;
        assertEquals(expectedTotalPay, paycheck.getTotalPay(), 0.001);
    }

    /**
     * Tests the handling of a null employee object.
     */
    @Test(expected = NullPointerException.class)
    public void testNullEmployee() {
        new Paycheck(null, PaymentMethod.PAPER_CHECK);
    }
    
    /**
     * Tests the loadCheck method with a valid employee.
     */
    @Test
    public void testLoadCheckWithValidEmployee() {
        Employee newEmployee = new Employee("Jane Doe", 30.0);
        newEmployee.addHours(40); // 40 hours without overtime
        paycheck.loadCheck(newEmployee);

        assertEquals("Jane Doe", paycheck.getEmployeeName());
        assertEquals(2, paycheck.getEmployeeId()); // Assuming Employee ID is incremented
        assertEquals(30.0, paycheck.getRate(), 0.001);
        assertEquals(40.0, paycheck.getHoursWorked(), 0.001);
        assertEquals(1200.0, paycheck.getTotalPay(), 0.001); // 40 * 30
    }

    /**
     * Tests the loadCheck method with a null employee.
     */
    @Test(expected = NullPointerException.class)
    public void testLoadCheckWithNullEmployee() {
        paycheck.loadCheck(null);
    }
    
    /**
     * Tests the setTotalPay method.
     */
    @Test
    public void testSetTotalPay() {
        paycheck.setTotalPay(1500.0);
        assertEquals(1500.0, paycheck.getTotalPay(), 0.001);
    }

    
    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        String expectedString = String.format("* %s's Paycheck. Id#: %d *\nPay Rate: %.2f\nHours: %.2f\nTotal Pay: $%.2f\nPayment Method: %s",
                employee.getName(), employee.getEmployeeId(), 20.0, 45.0, paycheck.getTotalPay(), PaymentMethod.DIRECT_DEPOSIT);
        assertEquals(expectedString, paycheck.toString());
    }

    // Adding tests for getters and setters

    /**
     * Tests the getEmployeeName method.
     */
    @Test
    public void testGetEmployeeName() {
        assertEquals("John Doe", paycheck.getEmployeeName());
    }

    /**
     * Tests the getEmployeeId method.
     */
    @Test
    public void testGetEmployeeId() {
        assertEquals(1, paycheck.getEmployeeId());
    }

    /**
     * Tests the getRate method.
     */
    @Test
    public void testGetRate() {
        assertEquals(20.0, paycheck.getRate(), 0.001);
    }

    /**
     * Tests the getHoursWorked method.
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals(45, paycheck.getHoursWorked(), 0.001);
    }

    /**
     * Tests the getPaymentMethod method.
     */
    @Test
    public void testGetPaymentMethod() {
        assertEquals(PaymentMethod.DIRECT_DEPOSIT, paycheck.getPaymentMethod());
    }

    /**
     * Tests the setEmployeeName method.
     */
    @Test
    public void testSetEmployeeName() {
        paycheck.setEmployeeName("Jane Doe");
        assertEquals("Jane Doe", paycheck.getEmployeeName());
    }

    /**
     * Tests the setEmployeeId method.
     */
    @Test
    public void testSetEmployeeId() {
        paycheck.setEmployeeId(2);
        assertEquals(2, paycheck.getEmployeeId());
    }

    /**
     * Tests the setRate method.
     */
    @Test
    public void testSetRate() {
        paycheck.setRate(25.0);
        assertEquals(25.0, paycheck.getRate(), 0.001);
    }

    /**
     * Tests the setHoursWorked method.
     */
    @Test
    public void testSetHoursWorked() {
        paycheck.setHoursWorked(35);
        assertEquals(35, paycheck.getHoursWorked(), 0.001);
    }

    /**
     * Tests the setPaymentMethod method.
     */
    @Test
    public void testSetPaymentMethod() {
        paycheck.setPaymentMethod(PaymentMethod.PAPER_CHECK);
        assertEquals(PaymentMethod.PAPER_CHECK, paycheck.getPaymentMethod());
    }

}


