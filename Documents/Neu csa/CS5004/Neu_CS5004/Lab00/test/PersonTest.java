/******

Name: Rong Huang

Assignment: Lab 0: Getting Started 

Date: 1/17/2024

Notes: This file tests the Book class methods using JUnit to ensure they work as expected.
 

******/

import Lab00_package.Person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Person class. It tests the functionality of the
 * Person class methods.
 */
public class PersonTest {

	private Person john;

	/**
	 * Set up a Person object with a known first name, last name, and year of birth
	 * for testing.
	 */
	@Before
	public void setUp() {
		john = new Person("John", "Doe", 1945);
	}

	/**
	 * Test the getFirstName() method of the Person class. It checks if the method
	 * correctly returns the first name of the person.
	 */
	@Test
	public void testFirst() {
		assertEquals("John", john.getFirstName());
	}

	/**
	 * Test the getLastName() method of the Person class. It checks if the method
	 * correctly returns the last name of the person.
	 */
	@Test
	public void testSecond() {
		assertEquals("Doe", john.getLastName());
	}

	/**
	 * Test the getYearOfBirth() method of the Person class. It checks if the method
	 * correctly returns the year of birth of the person.
	 */
	@Test
	public void testYearOfBirth() {
		assertEquals(1945, john.getYearOfBirth());
	}
}
