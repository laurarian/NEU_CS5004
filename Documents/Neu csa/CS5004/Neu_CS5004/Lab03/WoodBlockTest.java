/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the WoodBlockTest class
 ******/


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the WoodBlock class, ensuring both constructors
 * and the breakBlock method work as expected.
 */
public class WoodBlockTest {

    private WoodBlock defaultWoodBlock;
    private WoodBlock customWoodBlock;
    private final double customWeight = 10.0;

    /**
     * Sets up WoodBlock instances with default and custom weights before each test.
     */
    @Before
    public void setUp() {
        defaultWoodBlock = new WoodBlock();
        customWoodBlock = new WoodBlock(ResourceType.WOOD, customWeight);
    }

    /**
     * Tests the default constructor to verify if the wood block is initialized
     * with the predefined weight from Const class.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals("Default WoodBlock should have a weight of Const.WOOD_WEIGHT",
                Const.WOOD_WEIGHT, defaultWoodBlock.getWeight(), 0.0);
    }

    /**
     * Tests the constructor with arguments to verify if the wood block can be initialized
     * with a custom weight.
     */
    @Test
    public void testConstructorWithArguments() {
        assertEquals("Custom WoodBlock should have the specified custom weight",
                customWeight, customWoodBlock.getWeight(), 0.0);
    }

    /**
     * Tests the breakBlock method to ensure it returns a new Resource object representing
     * half the weight of the wood block as specified in the WoodBlock class documentation.
     */
    @Test
    public void testBreakBlock() {
        Resource brokenResource = defaultWoodBlock.breakBlock();
        assertEquals("Broken resource should have half the weight of the default WoodBlock",
                Const.WOOD_WEIGHT / 2, brokenResource.getWeight(), 0.0);
        assertEquals("Broken resource should be of ResourceType.WOOD", ResourceType.WOOD, brokenResource.getType());

        Resource customBrokenResource = customWoodBlock.breakBlock();
        assertEquals("Broken resource should have half the weight of the custom WoodBlock",
                customWeight / 2, customBrokenResource.getWeight(), 0.0);
        assertEquals("Broken resource should be of ResourceType.WOOD", ResourceType.WOOD, customBrokenResource.getType());
    }
}
