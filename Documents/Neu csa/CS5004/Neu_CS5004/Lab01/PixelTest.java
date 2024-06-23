/******
 * Name: Rong Huang
 * Assignment: Lab 1: First Class
 * Date: 1/24/2024
 * Notes: 
 *   This file test the Pixel class.
 ******/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Pixel class.
 */
public class PixelTest {

    private Pixel pixel;
    private Color color;

    /**
     * Sets up a Pixel object with predefined values before each test.
     */
    @Before
    public void setUp() {
        color = new Color(100, 150, 200);
        pixel = new Pixel(10, 20, color);
    }

    /**
     * Tests the default constructor of the Pixel class.
     */
    @Test
    public void testDefaultConstructor() {
        Pixel defaultPixel = new Pixel();
        assertEquals(0, defaultPixel.getX());
        assertEquals(0, defaultPixel.getY());
        assertNotNull(defaultPixel.getColor());
    }

    /**
     * Tests the two-argument constructor of the Pixel class.
     */
    @Test
    public void testTwoArgumentConstructor() {
        Pixel twoArgPixel = new Pixel(5, 10);
        assertEquals(5, twoArgPixel.getX());
        assertEquals(10, twoArgPixel.getY());
        assertNotNull(twoArgPixel.getColor());
    }

    /**
     * Tests the constructor that initializes a Pixel object with a Color.
     */
    @Test
    public void testColorConstructor() {
        Pixel colorPixel = new Pixel(new Color(30, 60, 90));
        assertEquals(0, colorPixel.getX());
        assertEquals(0, colorPixel.getY());
        assertEquals(30, colorPixel.getColor().getrValue());
        assertEquals(60, colorPixel.getColor().getgValue());
        assertEquals(90, colorPixel.getColor().getbValue());
    }

    /**
     * Tests the all-argument constructor of the Pixel class.
     */
    @Test
    public void testAllArgumentConstructor() {
        assertEquals(10, pixel.getX());
        assertEquals(20, pixel.getY());
        assertEquals(color, pixel.getColor());
    }

    /**
     * Tests the getters and setters for the x and y coordinates of the Pixel.
     */
    @Test
    public void testGettersAndSetters() {
        pixel.setX(30);
        pixel.setY(40);
        assertEquals(30, pixel.getX());
        assertEquals(40, pixel.getY());
    }

    /**
     * Tests the getter and setter for the color of the Pixel.
     */
    @Test
    public void testColorGetterSetter() {
        Color newColor = new Color(50, 60, 70);
        pixel.setColor(newColor);
        assertEquals(newColor, pixel.getColor());
    }

    /**
     * Tests the printPixel method. This is more of a placeholder as testing print statements requires more complex setup.
     */
    @Test
    public void testPrintPixel() {
        pixel.printPixel();
    }

    /**
     * Tests setting the boundaries for pixel's coordinates.
     */
    @Test
    public void testSetBorder() {
        pixel.setBorder(15, 5, 25, 15);
        pixel.setX(4);
        pixel.setY(14);
        assertEquals(4, pixel.getX());
        assertEquals(14, pixel.getY());
    }

    /**
     * Tests moving the pixel horizontally.
     */
    @Test
    public void testmoveHor() {
        pixel.moveHor(5);
        assertEquals(15, pixel.getX());
    }
    
    /**
     * Tests moving the pixel vertically.
     */
    @Test
    public void testmoveVer() {
        pixel.moveVer(10);
        assertEquals(30, pixel.getY());
    }
    
    /**
     * Tests moving the pixel with specified amounts both horizontally and vertically.
     */
    @Test
    public void testMovMeth() {
        pixel.movMeth(5, -10);
        assertEquals(15, pixel.getX());
        assertEquals(10, pixel.getY());
    }

    /**
     * Tests checking if the pixel's color is a shade of gray.
     */
    @Test
    public void testIsShadeOfGray() {
        pixel.setColor(new Color(100, 100, 100));
        assertTrue(pixel.isShadeOfGray());

        pixel.setColor(new Color(100, 101, 100));
        assertFalse(pixel.isShadeOfGray());
    }

    /**
     * Tests inverting the color of the pixel.
     */
    @Test
    public void testInvertColor() {
        pixel.invertColor();
        assertEquals(155, pixel.getColor().getrValue());
        assertEquals(105, pixel.getColor().getgValue());
        assertEquals(55, pixel.getColor().getbValue());
    }

    /**
     * Tests adjusting the brightness of the pixel's color.
     */
    @Test
    public void testAdjustBrightness() {
        pixel.adjustBrightness(10); // Increase brightness by 10%
        assertEquals(110, pixel.getColor().getrValue());
        assertEquals(165, pixel.getColor().getgValue());
        assertEquals(220, pixel.getColor().getbValue());

        pixel.adjustBrightness(-20); // Decrease brightness by 20%
        assertEquals(88, pixel.getColor().getrValue());
        assertEquals(132, pixel.getColor().getgValue());
        assertEquals(176, pixel.getColor().getbValue());
    }
}
