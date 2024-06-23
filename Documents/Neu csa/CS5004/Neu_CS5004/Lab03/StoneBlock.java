/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the StoneBlock class
 ******/


/**
 * Represents a block of stone in the Automated House Factory simulation.
 * This class extends the Block class, specifying the behavior for stone blocks.
 */
public class StoneBlock extends Block {

    /**
     * Default constructor for the StoneBlock class.
     * Initializes a stone block with a predefined weight from the Const class.
     */
    public StoneBlock() {
        // Call the parent constructor with stone type and predefined weight
        super(ResourceType.STONE, Const.STONE_WEIGHT);
    }

    /**
     * Constructor for the StoneBlock class with arguments
     * Initializes a stone block with a predefined weight.
     */
    public StoneBlock(ResourceType resourceType, double weight) {
        // Call the parent constructor with stone type and predefined weight
        super(ResourceType.STONE, weight);
    }

    /**
     * Breaks the stone block, returning all of its weight as a new resource.
     * @return A new Resource object representing the full weight of the stone block.
     */
    @Override
    public Resource breakBlock() {
        return new Resource(this.getWeight(), ResourceType.STONE);
    }
}


