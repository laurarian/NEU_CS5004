/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the Factory interface
 ******/


/**
 * The Factory interface defines the protocol for different types of factories.
 * Each factory is responsible for taking a resource, producing a block, and displaying its inventory.
 */
public interface Factory {

    /**
     * Takes a resource and adds it to the factory's inventory.
     *
     * @param obj The resource to be added to the factory.
     */
    public void takeResource(Object obj);

    /**
     * Produces a block based on the resources available in the factory's inventory.
     *
     * @return The block produced by the factory.
     */
    public Block produceBlock();

    /**
     * Displays the current inventory of the factory, including the types and quantities of resources.
     */
    public void displayInventory();
}

