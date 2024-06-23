/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the HouseBlockTest class
 ******/


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the HouseBlock class, ensuring the constructor correctly validates
 * wood and stone resources and that the breakBlock method behaves as expected.
 */
public class HouseBlockTest {

    private Resource sufficientWood;
    private Resource sufficientStone;
    private Resource insufficientWood;
    private Resource insufficientStone;
    private HouseBlock houseBlock;

    /**
     * Sets up resources for testing. Some resources meet the construction requirements
     * for a HouseBlock, while others do not.
     */
    @Before
    public void setUp() {
        sufficientWood = new Resource(Const.WOOD_WEIGHT * Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE, ResourceType.WOOD);
        sufficientStone = new Resource(Const.STONE_WEIGHT * Const.STONE_BLOCKS_NEEDED_FOR_HOUSE, ResourceType.STONE);
        insufficientWood = new Resource(Const.WOOD_WEIGHT - 1, ResourceType.WOOD);
        insufficientStone = new Resource(Const.STONE_WEIGHT - 1, ResourceType.STONE);
    }

    /**
     * Tests the HouseBlock constructor with sufficient resources,
     * expecting no exceptions.
     */
    @Test
    public void testConstructorWithSufficientResources() {
        houseBlock = new HouseBlock(sufficientWood, sufficientStone);
        assertNotNull("HouseBlock should be created with sufficient resources", houseBlock);
    }

    /**
     * Tests the HouseBlock constructor with insufficient wood resources,
     * expecting an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInsufficientWood() {
        new HouseBlock(insufficientWood, sufficientStone);
    }

    /**
     * Tests the HouseBlock constructor with insufficient stone resources,
     * expecting an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInsufficientStone() {
        new HouseBlock(sufficientWood, insufficientStone);
    }

    /**
     * Tests breaking the house block to ensure it returns a new Resource object
     * representing the weight of the stone used in construction.
     */
    @Test
    public void testBreakBlock() {
        houseBlock = new HouseBlock(sufficientWood, sufficientStone);
        Resource brokenResource = houseBlock.breakBlock();
        assertEquals("Broken resource should have the weight of the stone used",
                sufficientStone.getWeight(), brokenResource.getWeight(), 0.0);
        assertEquals("Broken resource should be of ResourceType.STONE", ResourceType.STONE, brokenResource.getType());
    }
}
