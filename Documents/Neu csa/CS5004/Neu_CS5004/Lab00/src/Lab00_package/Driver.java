/******

Name: Rong Huang

Assignment: Lab 0: Getting Started 

Date: 1/17/2024

Notes:  Demonstrates the usage of Book and Person classes and display the book information.
 

******/

package Lab00_package;

/**
 * This class serves as a driver for the Book and Person classes.
 */

public class Driver {

	public static void main(String[] args) {
		// Initializing a Person object for the book's author
		Person author = new Person("Eric", "Frick", 1970);
		
		// Initializing a Book object for demonstration 
		Book book = new Book("Java Programming", author, 29.95f);
		
		// Displaying book information
        System.out.println("Book Information:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() +
                ", Year of Birth: " + book.getAuthor().getYearOfBirth());
        System.out.println("Price: $" + book.getPrice());
        
	}

}
