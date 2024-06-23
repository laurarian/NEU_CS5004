/******

Name: Rong Huang

Assignment: Lab 0: Getting Started 

Date: 1/17/2024

Notes: This file tests the Car class methods using JUnit to ensure they work as expected.
 

******/

import org.junit.Before;
import org.junit.Test;

import Lab00_package.Car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A JUnit test class for the Car class. It tests the functionality of the Car
 * class methods.
 */
public class CarTest {

    private Car car;

    /**
     * Set up a Car object for testing.
     */
    @Before
    public void setUp() {
        // Setting up a Car object for testing
        car = new Car("Tesla", "Model X", 80000.0);
    }

    /**
     * Test the getBrand() method of the Car class. It checks if the method
     * correctly returns the brand of the car.
     */
    @Test
    public void testGetBrand() {
    	assertEquals("Tesla", car.getBrand());
    }

    /**
     * Test the getBrand() method of the Car class for inequality. It checks if the
     * method correctly detects inequality in brands.
     */
    @Test
    public void testGetBrandNotEqual() {
    	assertNotEquals("Toyota", car.getBrand());
    }

    /**
     * Test the getModel() method of the Car class. It checks if the method
     * correctly returns the model of the car.
     */
    @Test
    public void testGetModel() {
    	assertEquals("Model X", car.getModel());
    }

    /**
     * Test the getModel() method of the Car class for inequality. It checks if the
     * method correctly detects inequality in models.
     */
    @Test
    public void testGetModelNotEqual() {
    	assertNotEquals("Model Y", car.getModel());
    }

    /**
     * Test the getPrice() method of the Car class. It checks if the method
     * correctly returns the price of the car.
     */
    @Test
    public void testGetPrice() {
    	assertEquals(80000.0, car.getPrice(), 0.01); // Using delta for double comparison
    }

    /**
     * Test the getPrice() method of the Car class for inequality. It checks if the
     * method correctly detects inequality in prices.
     */
    @Test
    public void testGetPriceNotEqual() {
    	assertNotEquals(90000.0, car.getPrice(), 0.01);
    }
}
