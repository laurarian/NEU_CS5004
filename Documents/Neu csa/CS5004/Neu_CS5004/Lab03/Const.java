/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the Const class
 ******/


/**
 * Class to hold constant variables used throughout the application.
 * This class cannot be inherited from, ensuring that the constants
 * defined here remain unchanged and globally accessible.
 */
public final class Const {
    // Weight of a stone block in the game.
    public static final double STONE_WEIGHT = 5.0;
    // Weight of a wood block in the game.
    public static final double WOOD_WEIGHT = 5.0;
    // Number of stone blocks needed to construct a house.
    public static final double STONE_BLOCKS_NEEDED_FOR_HOUSE = 10.0;
    // Number of wood blocks needed to construct a house.
    public static final double WOOD_BLOCKS_NEEDED_FOR_HOUSE = 8.0;

    // Private constructor to prevent instantiation
    private Const() {
        throw new AssertionError("Const class should not be instantiated.");
    }
}

