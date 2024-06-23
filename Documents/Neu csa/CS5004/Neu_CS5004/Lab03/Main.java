/******
 * Name: Rong Huang
 * Assignment: Lab 3: Automated House Factory
 * Date: 2/14/2024
 * Notes:the Driver file
 ******/


import java.util.Random;
import java.lang.Math;

/*
Driver file for Automated House Factory Assignment.

This file simulates the operation of an automated house factory, where resources are mined, processed into blocks, and then used to build houses.
The simulation continues indefinitely until manually stopped.

6/21/2022
-Dr. G
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Resource resource;

        // Initialize factories for producing stone blocks, wood blocks, and houses.
        Factory stoneBlockProducer = new StoneBlockFactory();
        Factory woodBlockProducer = new WoodBlockFactory();
        Factory houseBlockProducer = new HouseBlockFactory();

        Block h1;

        // Infinite simulation loop. Use CTRL + C to terminate the simulation.
        while(true) {
            // Mine a random resource (stone or wood) with a random weight.
            resource = mineResource();

            // Direct the mined resource to the appropriate block producer factory.
            switch(resource.getType()) {
                case STONE: stoneBlockProducer.takeResource(resource); break;
                case WOOD: woodBlockProducer.takeResource(resource); break;
            }

            // Attempt to produce stone and wood blocks and then take them to the house producer.
            try{
                houseBlockProducer.takeResource(stoneBlockProducer.produceBlock());
            }
            catch(Exception e){}
            try{
                houseBlockProducer.takeResource(woodBlockProducer.produceBlock());
            }
            catch(Exception e){}



            // Attempt to produce a house block.
            h1 = houseBlockProducer.produceBlock();
            // If house block is produced successfully,print "House Built"
            if (h1 != null) System.out.println("House Built");

            // Reset the house block variable for the next iteration.
            h1 = null;

            // Display inventory levels of each producer factory.
            System.out.println("Stone Producer");
            stoneBlockProducer.displayInventory();
            System.out.println("Wood Producer");
            woodBlockProducer.displayInventory();
            System.out.println("House Producer");
            houseBlockProducer.displayInventory();

            System.out.println();

            // Pauses the simulation for 2 seconds to make the output visible.
            Thread.sleep(2000);
        }
    }

    /**
     * Generates a random Resource with a random weight.
     * @return A new Resource object with a type (STONE or WOOD) and a random weight.
     */
    public static Resource mineResource() {
        Random r = new Random();

        // Default resource type is STONE.
        ResourceType type = ResourceType.STONE;
        // Generate a random weight for the resource.
        double weight = Math.round((Math.abs(r.nextDouble())) * 100.0) / 10.0;
        // Randomly select the resource type.
        int select = r.nextInt(2);

        switch(select) {
            case 0: type = ResourceType.STONE; break;
            case 1: type = ResourceType.WOOD; break;
        }

        return new Resource(weight, type);
    }
}





