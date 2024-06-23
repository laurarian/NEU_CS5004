/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the HouseBlock class
 ******/


/**
 * Represents a house block in the game.
 * This class extends the Block class, customizing it with specific behavior for house construction,
 * which requires both wood and stone resources.
 */
public class HouseBlock extends Block {
    private double stoneWeight;//store the weight of the stone resource

    /**
     * Constructs a HouseBlock with specified wood and stone resources.
     * It validates the resources to ensure there's a sufficient amount of each to construct a house.
     * The total weight of the house block is calculated by the parent Block class.
     *
     * @param wood The wood resource used to construct the house block.
     * @param stone The stone resource used to construct the house block.
     * @throws IllegalArgumentException If there is not a sufficient amount of either resource.
     */
    public HouseBlock(Resource wood, Resource stone) {
        super(wood, stone);
        // check if the first resource is wood and the second one is stone
        if (wood.getType() != ResourceType.WOOD || stone.getType() != ResourceType.STONE) {
            throw new IllegalArgumentException("Resources must be wood followed by stone.");
        }
        // check if the provided wood and stone resources meet the quantity requirements
        validateResources(wood, stone);
        this.stoneWeight = stone.getWeight();
    }

    /**
     * Validates the provided wood and stone resources to ensure they meet the quantity requirements for constructing a house block.
     * Throws IllegalArgumentException if the resources are insufficient based on predefined constants.
     *
     * @param wood The wood resource to be validated.
     * @param stone The stone resource to be validated.
     */
    private void validateResources(Resource wood, Resource stone) {

        // Calculate the total minimum weight of wood and stone needed for house construction
        double requiredWoodWeight = Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE * Const.WOOD_WEIGHT;
        double requiredStoneWeight = Const.STONE_BLOCKS_NEEDED_FOR_HOUSE * Const.STONE_WEIGHT;

        // Validate if the provided resources meet these requirements
        if (wood.getWeight() < requiredWoodWeight || stone.getWeight() < requiredStoneWeight) {
            throw new IllegalArgumentException("Insufficient resources for HouseBlock construction: " +
                    "Required wood weight: " + requiredWoodWeight + ", provided: " + wood.getWeight() +
                    "; Required stone weight: " + requiredStoneWeight + ", provided: " + stone.getWeight() + ".");
        }
    }

    /**
     * Breaks the house block, returning the weight of the stone resource used in its construction.
     * only the stone's weight contributes to the return value, ignoring the wood.
     *
     * @return A new Resource object representing the weight of the stone used.
     */
    @Override
    public Resource breakBlock() {
        // Return a new Resource object with the recorded stone weight
        return new Resource(this.stoneWeight, ResourceType.STONE);
    }
}


