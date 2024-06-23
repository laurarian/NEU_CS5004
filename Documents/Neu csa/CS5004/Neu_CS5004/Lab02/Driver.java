/******
 * Name: Rong Huang
 * Assignment: Lab 2:Employees and Paychecks
 * Date: 1/31/2024
 * Notes: 
 *   This file is the driver program.
 ******/

public class Driver
{
	public static void main(String[] args) {
		//Create three employee objects
		Employee employee1 = new Employee("John", 20);
		Employee employee2 = new Employee("Max", 17);
		Employee employee3 = new Employee("Gary", 13.75);
		
		//Exception test 1
		Employee employee4 = new Employee("Jane", 98.78);
		Paycheck paycheck = new Paycheck();
		paycheck.loadCheck(employee4);
		
		//If these lines are in use they should throw the associated errors:
		//Exception in thread "main" java.lang.NullPointerException: Attempted pay generation with a null check object
		//employee4.getWeeklyPay(null);*/
		// Exception handling for getWeeklyPay with null
		try {
			employee4.getWeeklyPay(null);
		} catch (NullPointerException e) {
			System.out.println("Caught NullPointerException: " + e.getMessage());
		}
		//Exception in thread "main" java.lang.NullPointerException: Attempted a check load with a null employee object
		//paycheck.loadCheck(null);
		// Exception handling for loadCheck with null
		try {
			paycheck.loadCheck(null);
		} catch (NullPointerException e) {
			System.out.println("Caught NullPointerException: " + e.getMessage());
		}
		
		//Exception test 2
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: Invalid Pay Rate.
		//Employee badEmployee = new Employee("Bob", -34.98);

		// Exception handling for Employee constructor with IllegalArgumentException
		// Testing invalid payRate
		try {
			Employee employeeWithNegativePay = new Employee("Bob", -34.98);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}

		// Testing invalid name (null and empty)
		try {
			Employee employeeWithNullName = new Employee(null, 50.00);
			Employee employeeWithEmptyName = new Employee("  ", 50.00);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}

		// Exception handling for Paycheck constructor with IllegalArgumentException
		// Testing invalid payRate (negative)
		try {
			Paycheck paycheckWithNegativePayRate = new Paycheck("Alice", 123, -20.0, 40.0, PaymentMethod.CASH);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException for Paycheck with negative pay rate: " + e.getMessage());
		}

		// Testing invalid hoursWorked (negative)
		try {
			Paycheck paycheckWithNegativeHoursWorked = new Paycheck("Alice", 123, 50.0, -5.0, PaymentMethod.CASH);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException for Paycheck with negative hours worked: " + e.getMessage()+ "\n");
		}

		//Demonstrate the successful construction of the three employees
		System.out.println("Printing Employees After Construction :");
		System.out.printf(employee1 + "\n" + employee2 + "\n" +  employee3 + "\n");
		
		//Demonstrate changing the hours and pay rate fields of an employee
		employee1.addHours(50);
		
		//Exception test 3
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: You cannot add negative hours.""
		//employee1.addHours(-20);
		// Exception Handling for addHours with IllegalArgumentException
		try {
			employee1.addHours(-20);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage());
		}
		
		employee1.payRaise(10);
		
		//Exception test 4
		//If this line is in use it should throw :
		//"Exception in thread "main" java.lang.IllegalArgumentException: You cannot give a negative raise. Use pay cut."
		//employee1.payRaise(-10);
		// Exception Handling for payRaise with IllegalArgumentException
		try {
			employee1.payRaise(-10);
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException: " + e.getMessage()+ "\n");
		}

		System.out.println("Employee 1, with 50 hours and a 10% pay raise :");
		System.out.printf(employee1 + "\n");
		
		//Demonstrate construction & printing the paychecks 
		//of the three employees
		Paycheck paycheck1 = employee1.getWeeklyPay();
		Paycheck paycheck2 = employee2.getWeeklyPay();
		Paycheck paycheck3 = employee3.getWeeklyPay();
		
		System.out.println("Employee Weekly Paychecks :");
		System.out.printf(paycheck1 + "\n\n" + paycheck2 + "\n\n" +  paycheck3 + "\n\n");
		
		//Demonstrate that the employee objects reset their hoursWorked field
		//after they called the getWeeklyPay method
		System.out.println("Employee 1 with newly reset hours :");
		System.out.printf(employee1 + "\n");
	}
}
