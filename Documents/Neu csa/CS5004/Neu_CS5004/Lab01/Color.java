/******
 * Name: Rong Huang
 * Assignment: Lab 1: First Class
 * Date: 1/24/2024
 * Notes: 
 *   This file defines the Color class with RGB values and 
 *   includes methods to manipulate these values.
 ******/

/**
 * This class represents a color with RGB values.
 */

public class Color {
    // RGB values for the color
	private int rValue;
	private int gValue;
	private int bValue;
	
	
    /**
     * Default constructor. Creates a color with RGB values set to 0.
     */
	public Color() {
        this(0, 0, 0);
	}	
	
    /**
     * Constructor with all arguments. Creates a color with specified RGB values.
     * @param rValue the red value (0 to 255)
     * @param gValue the green value (0 to 255)
     * @param bValue the blue value (0 to 255)
     */
    public Color(int rValue, int gValue, int bValue) {
        setrValue(rValue);
        setgValue(gValue);
        setbValue(bValue);
    }
    
    /**
     * Checks if the provided value is within the valid RGB range.
     * 
     * @param value the value to check
     * @return the corrected value
     */
    private int checkValue(int value) {
        if (value < 0 || value > 255) {
            return 0;
        }
        return value;
    }

    // Getters and setters
    /**
     * Gets the red value of this color.
     *
     * @return the red value
     */
    public int getrValue() {
        return rValue;
    }
    
    /**
     * Sets the red value of this color.
     * If the provided value is outside the range 0-255, it will be set to 0.
     *
     * @param rValue the new red value
     */
    public void setrValue(int rValue) {
        this.rValue = checkValue(rValue);
    }

    /**
     * Gets the green value of this color.
     *
     * @return the green value
     */
    public int getgValue() {
        return gValue;
    }

    /**
     * Sets the green value of this color.
     * If the provided value is outside the range 0-255, it will be set to 0.
     *
     * @param gValue the new green value
     */
    public void setgValue(int gValue) {
        this.gValue = checkValue(gValue);
    }

    /**
     * Gets the blue value of this color.
     *
     * @return the blue value
     */
    public int getbValue() {
        return bValue;
    }

    /**
     * Sets the blue value of this color.
     * If the provided value is outside the range 0-255, it will be set to 0.
     *
     * @param bValue the new blue value
     */
    public void setbValue(int bValue) {
        this.bValue = checkValue(bValue);
    }

    /**
     * Prints the RGB values of the color.
     */
    public void printColor() {
        System.out.println(rValue + "," + gValue + "," + bValue);
    }

    /**
     * Checks if the color is black.0,0,0 is black
     * 
     * @return true if the color is black, otherwise false
     */
    public boolean isBlack() {
        return rValue == 0 && gValue == 0 && bValue == 0;
    }
	
    /**
     * Checks if the color is white.255,255,255 is white
     * 
     * @return true if the color is white, otherwise false
     */
    public boolean isWhite() {
        return rValue == 255 && gValue == 255 && bValue == 255;
    }

    /**
     * Combines this color with another color. If it goes over 255 set it to 0
     * 
     * @param other color to combine with
     */
    public void combineColor(Color other) {
    	this.rValue = (this.rValue + other.rValue > 255) ? 0 : this.rValue + other.rValue;
    	this.gValue = (this.gValue + other.gValue > 255) ? 0 : this.gValue + other.gValue;
    	this.bValue = (this.bValue + other.bValue > 255) ? 0 : this.bValue + other.bValue;
    }
}
