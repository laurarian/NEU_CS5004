/**
 * Represents the types of rooms available in a hotel.
 * Each room type has a descriptive name associated with it.
 */
public enum RoomType {
    STANDARD("Standard"),
    DOUBLE("Double"),
    DELUXE_DOUBLE("Deluxe Double"),
    SUITE("Suite");

    private final String description;

    /**
     * Constructs a RoomType with a description.
     *
     * @param description A textual description of the room type.
     */
    RoomType(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the room type.
     *
     * @return The textual description of the room type.
     */
    @Override
    public String toString() {
        return this.description;
    }
}


