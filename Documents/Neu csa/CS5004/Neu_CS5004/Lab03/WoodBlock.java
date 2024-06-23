/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the WoodBlock class
 ******/


/**
 * Represents a block of wood in the Automated House Factory simulation.
 * This class extends the Block class, specifying the behavior for wood blocks.
 */
public class WoodBlock extends Block {

    /**
     * Default constructor for the WoodBlock class.
     * Initializes a wood block with a predefined weight from the Const class.
     */
    public WoodBlock() {
        // Call the parent constructor with wood type and predefined weight
        super(ResourceType.WOOD, Const.WOOD_WEIGHT);
    }

    /**
     * Constructor for the WoodBlock class with arguments
     * Initializes a stone block with a predefined weight.
     */
    public WoodBlock(ResourceType resourceType, double weight) {
        // Call the parent constructor with stone type and predefined weight
        super(ResourceType.WOOD, weight);
    }

    /**
     * Breaks the wood block, returning half of its weight as a new resource.
     * @return A new Resource object representing half the weight of the wood block.
     */
    @Override
    public Resource breakBlock() {
        return new Resource(this.getWeight() / 2, ResourceType.WOOD);
    }
}


