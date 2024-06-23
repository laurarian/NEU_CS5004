/******
 * Name: Rong Huang
 * Assignment: Lab 1: First Class
 * Date: 1/24/2024
 * Notes: 
 *   This file is the driver program.
 ******/

/**
 * Driver program to demonstrate the functionality of the Color and Pixel classes.
 */
public class Driver {
	
    public static void main(String[] args) {
        // Demonstrate the Color class
        Color color1 = new Color();
        Color color2 = new Color(245, 215, 66);
        Color color3 = new Color(255, 255, 255);

        // Print default color
        System.out.println("Default color (should be 0,0,0):");
        color1.printColor();

        // Print custom color
        System.out.println("Custom color (should be 245,215,66):");
        color2.printColor();

        // Check if color2 is black or white
        System.out.println("Is color2 black? " + color2.isBlack());
        System.out.println("Is color2 white? " + color2.isWhite());

        // Combine color2 and color3
        color2.combineColor(color3);
        System.out.println("Combined color2 and color3 (should be 0,0,0 or 255,255,255 depending on the combineColor logic):");
        color2.printColor();

        // Demonstrate the Pixel class
        Pixel pixel1 = new Pixel();
        Pixel pixel2 = new Pixel(10, 20, new Color(50, 100, 150));

        // Print default pixel
        System.out.println("Default pixel (should be at 0,0 with default color):");
        pixel1.printPixel();

        // Print custom pixel
        System.out.println("Custom pixel (should be at 10,20 with custom color):");
        pixel2.printPixel();

        // Move pixel2
        pixel2.moveHor(5);
        pixel2.moveVer(-10);
        System.out.println("Moved pixel2 (should be at 15,10):");
        pixel2.printPixel();

        // Check if pixel2's color is a shade of gray
        System.out.println("Is pixel2's color a shade of gray? " + pixel2.isShadeOfGray());

        // Invert pixel2's color
        pixel2.invertColor();
        System.out.println("Inverted color of pixel2:");
        pixel2.printPixel();

        // Adjust the brightness of pixel2
        pixel2.adjustBrightness(20.0);
        System.out.println("Adjusted brightness of pixel2:");
        pixel2.printPixel();
    }
}
