/******
 * Name: Rong Huang
 * Assignment: Lab 1: First Class
 * Date: 1/24/2024
 * Notes: 
 *   This file test the Color class.
 ******/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Color class.
 * This class contains tests to verify the correct functionality of the Color class methods.
 */
public class ColorTest {
	Color c1;
	Color c2;
	Color c3;
	Color c4;
	Color c5;
	Color c6;
    Color c7;
    

    /**
     * Sets up test fixtures before each test method.
     * Initializes several Color objects with different RGB values for testing.
     */
	@Before
	public void setUp()
	{
		c1 = new Color();
		c2 = new Color(100,100,100);
		c3 = new Color(0,0,0);
		c4 = new Color(255,255,255);
		c5 = new Color(-1,-1,-1);
		c6 = new Color(300,300,300);
        c7 = new Color(128,128,128);

	}
	
    /**
     * Tests the getters and setters of the Color class.
     * Ensures that the RGB values are set and retrieved correctly.
     */
    @Test
    public void gettersAndSetters() {
        c1.setrValue(1);
        c1.setgValue(1);
        c1.setbValue(1);

        assertEquals(1, c1.getrValue());
        assertEquals(1, c1.getgValue());
        assertEquals(1, c1.getbValue());
    }	
	
    /**
     * Tests the no-argument constructor of the Color class.
     * Ensures that it initializes a color with all RGB values set to 0.
     */
    @Test
    public void testNoArgConstructor() {
        assertEquals(0, c1.getrValue());
        assertEquals(0, c1.getgValue());
        assertEquals(0, c1.getbValue());
    }
	
    /**
     * Tests the all-argument constructor of the Color class.
     * Ensures that it initializes a color with specified RGB values.
     */
    @Test
    public void testAllArgConstructor() {
        assertEquals(100, c2.getrValue());
        assertEquals(100, c2.getgValue());
        assertEquals(100, c2.getbValue());
    }
	
    /**
     * Tests the behavior of Color class when provided with RGB values beyond the valid range.
     * Ensures that invalid values are corrected to 0.
     */
    @Test
    public void valueBorderTest() {
        assertEquals(0, c5.getrValue());
        assertEquals(0, c5.getgValue());
        assertEquals(0, c5.getbValue());

        assertEquals(0, c6.getrValue());
        assertEquals(0, c6.getgValue());
        assertEquals(0, c6.getbValue());
    }
	
    /**
     * Tests the color identification methods (isBlack and isWhite) of the Color class.
     * Verifies correct identification of black and white colors.
     */
	@Test
	public void colorTestTests() {
		assertEquals(false, c3.isWhite());
		assertEquals(true, c3.isBlack());
		assertEquals(true, c4.isWhite());
		assertEquals(false, c4.isBlack());
	}
	
    /**
     * Tests the combineColor method of the Color class.
     * Ensures that the method correctly combines two colors and resets to 0 
     * if values exceed 255.
     */
    @Test
    public void testCombineColor() {
        c2.combineColor(c7); 
        assertEquals(228, c2.getrValue());
        assertEquals(228, c2.getgValue());
        assertEquals(228, c2.getbValue());
        
        Color colorone = new Color(100,100,100);
        Color colortwo = new Color(250,250,250);
        colorone.combineColor(colortwo); // Should reset to 0 if it goes over 255
        assertEquals(0, colorone.getrValue());
        assertEquals(0, colorone.getgValue());
        assertEquals(0, colorone.getbValue());
    }
	
}
