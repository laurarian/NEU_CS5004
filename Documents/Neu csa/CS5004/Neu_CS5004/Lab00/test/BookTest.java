/******

Name: Rong Huang

Assignment: Lab 0: Getting Started 

Date: 1/17/2024

Notes: This file tests the Book class methods using JUnit to ensure they work as expected.
 

******/


import org.junit.Before;
import org.junit.Test;

import Lab00_package.Person;
import Lab00_package.Book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A JUnit test class for the Book class. It tests the functionality of the Book
 * class methods.
 */
public class BookTest {

	private Person author;
	private Book book;

	/**
	 * Set up a Person object for the book's author and a Book object for testing.
	 */
	@Before
	public void setUp() {
		
		// Setting up a Person object for the book's author
		author = new Person("Eric", "Frick", 1970);
		
		// Setting up a Book object for testing
		book = new Book("Java Programming", author, 29.95f);
	}

	/**
	 * Test the getTitle() method of the Book class. It checks if the method
	 * correctly returns the title of the book.
	 */
	@Test
	public void testGetTitle() {
		assertEquals("Java Programming", book.getTitle());
	}

	/**
	 * Test the getTitle() method of the Book class for inequality. It checks if the
	 * method correctly detects inequality in titles.
	 */
	@Test
	public void testGetTitleNotEqual() {
		assertNotEquals("Python Programming", book.getTitle());
	}

	/**
	 * Test the getPrice() method of the Book class. It checks if the method
	 * correctly returns the price of the book.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(29.95f, book.getPrice(), 0.01); // Using delta for float comparison
	}

	/**
	 * Test the getPrice() method of the Book class for inequality. It checks if the
	 * method correctly detects inequality in prices.
	 */
	@Test
	public void testGetPriceNotEqual() {
		assertNotEquals(39.99f, book.getPrice(), 0.01);
	}

	/**
	 * Test the getAuthor() method of the Book class. It checks if the method
	 * correctly returns the author of the book.
	 */
	@Test
	public void testGetAuthor() {
		assertEquals(author, book.getAuthor());
	}

	/**
	 * Test the getAuthor() method of the Book class for inequality. It checks if
	 * the method correctly detects inequality in authors.
	 */
	@Test
	public void testGetAuthorNotEqual() {
		assertNotEquals(new Person("Alice", "Wonder", 1985), book.getAuthor());
	}
}
