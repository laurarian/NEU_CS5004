/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the WoodBlockFactory class
 ******/


/**
 * Represents a factory that produces wood blocks from wood resources.
 * Implements the Factory interface to handle resources and block production.
 */
public class WoodBlockFactory implements Factory {
    private Resource resourceBin;

    /**
     * Default constructor that initializes the factory with an empty wood resource bin.
     */
    public WoodBlockFactory() {
        this.resourceBin = new Resource(0, ResourceType.WOOD);
    }

    /**
     * Adds a wood resource to the factory's inventory.
     * Validates the resource type and throws an exception for non-wood resources.
     *
     * @param obj The wood resource to be added.
     * @throws IllegalArgumentException if the provided resource is not of type WOOD.
     */
    @Override
    public void takeResource(Object obj) {
        if (obj == null) return; // Do nothing if the object is null

        if (obj instanceof Resource) {
            Resource resource = (Resource) obj;
            if (resource.getType() == ResourceType.WOOD) {
                // Add the weight of the resource to the resource bin
                resourceBin.combineResource(resource.getWeight());
            } else {
                throw new IllegalArgumentException("Resource type mismatch. Expected WOOD.");
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
     * Produces a wood block if enough resources are available.
     *
     * @return A new WoodBlock if resources suffice, otherwise null.
     */
    @Override
    public Block produceBlock() throws NullPointerException {
        if (this.resourceBin.getWeight() >= Const.WOOD_WEIGHT) {
            // Deduct a block's amount of weight
            this.resourceBin.reduceResource(Const.WOOD_WEIGHT);
            return new WoodBlock(ResourceType.WOOD, this.resourceBin.getWeight());
        } else {
//            System.out.println("Not enough stone resources to produce a WoodBlock.");
            return null;
        }
    }
}

