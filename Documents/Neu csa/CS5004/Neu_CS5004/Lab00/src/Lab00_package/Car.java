/******

Name: Rong Huang

Assignment: Lab 0: Getting Started 

Date: 1/17/2024

Notes:  
 *   This file defines my own class - the car class,representing a car with it's brand, model, and price.
 *   The class includes methods to retrieve the brand,model and price of a car.

******/


package Lab00_package;

/**
 * This class represents a simple Car.The car has a brand, a model and a price.
 */
public class Car {
    private String brand;
    private String model;
    private double price;

    /**
     * Constructs a Car object and initializes it with the provided brand, model, and price.
     *
     * @param brand the brand of this car
     * @param model the model of this car
     * @param price the price of this car
     */
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     * Get the brand of this car.
     *
     * @return the brand of this car
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Get the model of this car.
     *
     * @return the model of this car
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Get the price of this car.
     *
     * @return the price of this car
     */
    public double getPrice() {
        return this.price;
    }
}
