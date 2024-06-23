/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the HouseBlockFactory  class
 ******/


/**
 * HouseBlockFactory class implements the Factory interface to handle both stone and wood resources
 * and produce house blocks.
 */
public class HouseBlockFactory implements Factory {
    private int woodCount; // store the number of wood
    private int stoneCount; // store the number of stone

    /**
     * Default constructor that initializes the factory with zero counts for both wood and stone.
     */
    public HouseBlockFactory() {
        this.woodCount = 0;
        this.stoneCount = 0;
    }

    /**
     * Takes an object and adds it to the factory's inventory if it's a valid block of wood or stone.
     * Increases the corresponding resource counter based on the block type.
     *
     * @param obj The object to be added to the factory, expected to be a Block of type WOOD or STONE.
     * @throws IllegalArgumentException if the provided object is null, not a Block, or not of type WOOD or STONE.
     */
    @Override
    public void takeResource(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }

        if (obj instanceof Block) {
            Block block = (Block) obj;
            switch (block.getType()) {
                case WOOD:
                    this.woodCount++;
                    break;
                case STONE:
                    this.stoneCount++;
                    break;
                default:
                    throw new IllegalArgumentException("Block type mismatch. Expected WOOD or STONE.");
            }
        } else {
            throw new IllegalArgumentException("Invalid object type. Expected Block.");
        }
    }

    /**
     * Displays the current inventory of the factory, including the counts of wood and stone blocks.
     */
    @Override
    public void displayInventory() {
        System.out.println("Wood Blocks: " + this.woodCount + ", Stone Blocks: " + this.stoneCount);
    }

    /**
     * Produces a house block if enough resources of wood and stone are available.
     *
     * @return A new HouseBlock if resources suffice, otherwise null.
     */
    @Override
    public Block produceBlock() {
        // Check if we have enough number of wood and stone bock
        if (this.woodCount >= Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE && this.stoneCount >= Const.STONE_BLOCKS_NEEDED_FOR_HOUSE) {
            // Create a new House block
            HouseBlock houseBlock = new HouseBlock(new Resource(Const.WOOD_WEIGHT * Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE, ResourceType.WOOD),
                    new Resource(Const.STONE_WEIGHT * Const.STONE_BLOCKS_NEEDED_FOR_HOUSE, ResourceType.STONE));

            // Reduce the amounts of wood and stone block
            this.woodCount -= Const.WOOD_BLOCKS_NEEDED_FOR_HOUSE;
            this.stoneCount -= Const.STONE_BLOCKS_NEEDED_FOR_HOUSE;

            return houseBlock;
        } else {
//            System.out.println("Not enough resources to produce a HouseBlock.");
            return null;
        }
    }
}
