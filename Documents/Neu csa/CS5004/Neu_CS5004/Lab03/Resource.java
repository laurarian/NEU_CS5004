/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the Resource class
 ******/


/**
 * Class representing a container for storing raw material.
 */
public class Resource {
    private double weight;
    private ResourceType type;

    /**
     * Constructor for Resource class.
     *
     * @param weight The weight of the resource.
     * @param type   The type of the resource.
     */
    public Resource(double weight, ResourceType type) {
        this.weight = weight;
        this.type = type;
    }

    /**
     * Getter for resource weight.
     *
     * @return The weight of the resource.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Getter for resource type.
     *
     * @return The type of the resource.
     */
    public ResourceType getType() {
        return type;
    }

    /**
     * Method to add to the amount of an existing resource of the same type.
     *
     * @param additionalWeight Weight to be added to the resource.
     */
    public void combineResource(double additionalWeight) {
        if (additionalWeight > 0) {
            this.weight += additionalWeight;
        }
    }

    /**
     * Method to subtract from the resource weight.
     *
     * @param weightToReduce Weight to be reduced from the resource.
     * @throws IllegalArgumentException if weightToReduce is greater than current weight.
     */
    public void reduceResource(double weightToReduce) {
        if (weightToReduce > 0) {
            if (weightToReduce > this.weight) {
                throw new IllegalArgumentException("Attempting to reduce more weight than is available.");
            }
            this.weight -= weightToReduce;
        }
        // If weightToReduce is <= 0, do nothing
    }

    @Override
    public String toString() {
        return ("weight:" + weight);
    }
}




