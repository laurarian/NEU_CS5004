/******
 * Name: Rong Huang
 * Assignment: Lab 1: First Class
 * Date: 1/24/2024
 * Notes: 
 *   This file defines the Pixel class with position and color then implement them.
 ******/


/**
 * This class represents a pixel with x and y coordinates and a color.
 */
public class Pixel {
    private int x;
    private int y;
    private Color color;

    /**
     * Default constructor. Initializes a pixel at coordinates (0,0) with default color.
     */
    public Pixel() {
        this(0, 0, new Color());
    }

    /**
     * two argument constructor that initializes a pixel with specified x and y coordinates and default color.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Pixel(int x, int y) {
        this(x, y, new Color());
    }

    /**
     * Constructor that sets the default x and y values to 0 then sets the color using a sent color.
     * 
     * @param color the color of the pixel
     */
    public Pixel(Color color) {
        this(0, 0, color);
    }

    /**
     * All-argument constructor that takes in an x and y coordinate and a color.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * @param color the color of the pixel
     */
    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
 
    // Getters and setters
    /**
     * Get the x coordinate of the pixel.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinate of the pixel.
     * 
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Gets the y coordinate of the pixel.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the pixel.
     * 
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the color of the pixel.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the pixel.
     *
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }
   
    
    /**
     * Prints the x and y coordinates separated by commas 
     * and then uses composition to add on the color object's information.
     */
    public void printPixel() {
        System.out.println(x + "," + y + ": " + color);
    }

    /**
     * Sets the boundaries for the pixel's coordinates.
     *
     * @param maxX the maximum x value
     * @param minX the minimum x value
     * @param maxY the maximum y value
     * @param minY the minimum y value
     */
    public void setBorder(int maxX, int minX, int maxY, int minY) {
        x = Math.max(Math.min(x, maxX), minX);
        y = Math.max(Math.min(y, maxY), minY);
    }

    /**
     * Moves the pixel horizontally by a specified amount.
     *
     * @param amount the amount to move horizontally
     */
    public void moveHor(int amount) {
        setX(x + amount);
    }

    /**
     * Moves the pixel vertically by a specified amount.
     *
     * @param amount the amount to move vertically
     */
    public void moveVer(int amount) {
        setY(y + amount);
    }

    /**
     * Moves the pixel both horizontally and vertically by specified amounts and ensures the pixel stays within boundaries.
     *
     * @param xAmount the amount to move horizontally
     * @param yAmount the amount to move vertically
     */
    public void movMeth(int xAmount, int yAmount) {
        moveHor(xAmount);
        moveVer(yAmount);
        // Ensure the new position is within the set borders
        setBorder(x, x, y, y);
    }
    
    /**
     * Checks if the pixel's color is a shade of gray.
     * A color is a shade of gray if its red, green, and blue components are equal.
     *
     * @return true if the color is a shade of gray, false otherwise
     */
    public boolean isShadeOfGray() {
        int r = color.getrValue();
        int g = color.getgValue();
        int b = color.getbValue();
        return r == g && g == b;
    }
   
    /**
     * Inverts the color of the pixel.
     * The inverted color is calculated by subtracting each color component from 255.
     */
    public void invertColor() {
        int r = 255 - color.getrValue();
        int g = 255 - color.getgValue();
        int b = 255 - color.getbValue();
        color = new Color(r, g, b);
    }
    
    /**
     * Adjusts the brightness of the pixel's color.
     * Positive percentages increase brightness, negative percentages decrease it.
     * 
     * @param percentage the percentage to adjust the brightness by
     */
    public void adjustBrightness(double percentage) {
        int r = color.getrValue();
        int g = color.getgValue();
        int b = color.getbValue();

        // Adjust each RGB value by the specified percentage and ensure it stays within the range of 0 to 255
        r = (int) Math.min(255, Math.max(0, r + (r * percentage / 100.0)));
        g = (int) Math.min(255, Math.max(0, g + (g * percentage / 100.0)));
        b = (int) Math.min(255, Math.max(0, b + (b * percentage / 100.0)));

        color.setrValue(r);
        color.setgValue(g);
        color.setbValue(b);
    }     
}

