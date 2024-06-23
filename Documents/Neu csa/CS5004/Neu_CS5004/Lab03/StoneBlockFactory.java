/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the StoneBlockFactory class
 ******/


/**
 * StoneBlockFactory class implements the Factory interface to handle stone resources
 * and produce stone blocks.
 */
public class StoneBlockFactory implements Factory {
    private Resource resourceBin;

    /**
     * Default constructor that initializes the factory with an empty stone resource bin.
     */
    public StoneBlockFactory() {
        this.resourceBin = new Resource(0, ResourceType.STONE);
    }

    /**
     * Adds a resource to the factory's inventory.
     * Validates the resource type and throws an exception for non-stone resources.
     *
     * @param obj The object to be added, expected to be a Resource of type STONE.
     * @throws IllegalArgumentException if the provided object is not a Resource or is not of type STONE.
     */
    @Override
    public void takeResource(Object obj) {
        if (obj == null) return; // Do nothing if the object is null

        if (obj instanceof Resource) {
            Resource resource = (Resource) obj;
            if (resource.getType() == ResourceType.STONE) {
                // Add the weight of the resource to the resource bin
                resourceBin.combineResource(resource.getWeight());
            } else {
                throw new IllegalArgumentException("Resource type mismatch. Expected STONE.");
            }
        } else {
            throw new IllegalArgumentException("Invalid object type. Expected Resource.");
        }
    }

    /**
     * Displays the current inventory of the factory.
     */
    @Override
    public void displayInventory() {
        System.out.println(this.resourceBin.toString());
    }

    /**
     * Produces a stone block if enough resources are available.
     *
     * @return A new StoneBlock if resources suffice, otherwise null.
     */
    @Override
    public Block produceBlock() throws NullPointerException{
        if (this.resourceBin.getWeight() >= Const.STONE_WEIGHT) {
            // Deduct a block's amount of weight
            this.resourceBin.reduceResource(Const.STONE_WEIGHT);
            return new StoneBlock(ResourceType.STONE, this.resourceBin.getWeight());
        } else {
//            System.out.println("Not enough stone resources to produce a StoneBlock.");
            return null;
        }
    }
}


