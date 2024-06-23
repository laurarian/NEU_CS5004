/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the Block class
 ******/


/**
 * Abstract class representing a block in the game.
 * Defines common properties and functionalities for different types of blocks,
 * such as stone, wood, and house. It is designed to be extended by specific block types
 * and cannot be instantiated directly.
 */
public abstract class Block {
    private ResourceType type;
    private double weight;

    /**
     * Constructs a Block with a specified resource type and weight.
     *
     * @param type The type of the resource as defined in the ResourceType enum.
     * @param weight The weight of the block.
     */
    protected Block(ResourceType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    /**
     * Constructs a Block based on two resources. This constructor is specifically
     * designed for creating a house block. It calculates the block's weight by directly
     * summing the weights of stone and wood resources based on their types.
     *
     * @param resourceOne The first resource, can be either stone or wood.
     * @param resourceTwo The second resource, can be either stone or wood.
     */
    protected Block(Resource resourceOne, Resource resourceTwo) {
        this.type = ResourceType.HOUSE;
        this.weight = calculateTotalWeight(resourceOne, resourceTwo);
    }

    /**
     * Calculates the total weight for a house block given two resources.
     * It determines the type of each resource and applies the appropriate weight factor.
     *
     * @param resourceOne The first resource.
     * @param resourceTwo The second resource.
     * @return The total weight calculated for the house block.
     */
    private double calculateTotalWeight(Resource resourceOne, Resource resourceTwo) {
        double totalWeight = 0;

        // Accumulate weight from resourceOne
        totalWeight += resourceOne.getType() == ResourceType.STONE ?
                Const.STONE_WEIGHT * Const.STONE_BLOCKS_NEEDED_FOR_HOUSE :
                Const.WOOD_WEIGHT * Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE;

        // Accumulate weight from resourceTwo
        totalWeight += resourceTwo.getType() == ResourceType.STONE ?
                Const.STONE_WEIGHT * Const.STONE_BLOCKS_NEEDED_FOR_HOUSE :
                Const.WOOD_WEIGHT * Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE;

        return totalWeight;
    }

    /**
     * Abstract method to define how a block is broken down.
     * Must be implemented by subclasses.
     *
     * @return The Resource resulting from breaking the block.
     */
    public abstract Resource breakBlock();

    /**
     * Gets the block's resource type.
     *
     * @return The ResourceType of the block.
     */
    public ResourceType getType() {
        return type;
    }

    /**
     * Gets the block's weight.
     *
     * @return The weight of the block.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the block, including its type and weight.
     *
     * @return A string representation of the block.
     */
    @Override
    public String toString() {
        return "Block{type=" + type + ", weight=" + weight + '}';
    }
}





