/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the StoneBlockTest class
 ******/


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the StoneBlock class, ensuring both constructors
 * and the breakBlock method work as expected.
 */
public class StoneBlockTest {

    private StoneBlock defaultStoneBlock;
    private StoneBlock customStoneBlock;
    private final double customWeight = 10.0;

    /**
     * Initialize StoneBlock instances with different constructors before each test.
     */
    @Before
    public void setUp() {
        defaultStoneBlock = new StoneBlock();
        customStoneBlock = new StoneBlock(ResourceType.STONE, customWeight);
    }

    /**
     * Tests the default constructor to ensure the stone block is initialized
     * with the predefined weight from the Const class.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals("Default StoneBlock should have a weight of Const.STONE_WEIGHT",
                Const.STONE_WEIGHT, defaultStoneBlock.getWeight(), 0.0);
    }

    /**
     * Tests the constructor with arguments to ensure the stone block can be initialized
     * with a custom weight. Even though ResourceType is passed, it's predefined to STONE.
     */
    @Test
    public void testConstructorWithArguments() {
        assertEquals("Custom StoneBlock should have a custom weight",
                customWeight, customStoneBlock.getWeight(), 0.0);
    }

    /**
     * Tests the breakBlock method to ensure it correctly returns a Resource object
     * with the same weight as the stone block and of type STONE.
     */
    @Test
    public void testBreakBlock() {
        Resource resource = defaultStoneBlock.breakBlock();
        assertEquals("Resource should have the same weight as the default StoneBlock",
                Const.STONE_WEIGHT, resource.getWeight(), 0.0);
        assertEquals("Resource type should be STONE", ResourceType.STONE, resource.getType());

        Resource customResource = customStoneBlock.breakBlock();
        assertEquals("Resource should have the same weight as the custom StoneBlock",
                customWeight, customResource.getWeight(), 0.0);
        assertEquals("Resource type should be STONE", ResourceType.STONE, customResource.getType());
    }
}




