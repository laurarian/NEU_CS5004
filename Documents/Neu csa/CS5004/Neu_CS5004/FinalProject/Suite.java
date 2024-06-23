import java.util.List;

/**
 * Represents the Suite in the hotel, offering the ultimate luxury experience with extensive amenities for families or high-profile guests.
 */
public class Suite extends AbstractRoom {

    /**
     * Constructs a Suite with specific properties.
     *
     * @param roomNumber The room number.
     * @param price The price per night for the room.
     * @param status The current availability status of the room.
     */
    public Suite(int roomNumber, double price, RoomStatus status) {
        super(roomNumber, RoomType.SUITE, price, BedType.KINGSIZE, 1, status,
                List.of("Ultra High-speed WiFi", "Two Flat-screen TVs", "Minibar", "Separate Living Room", "Open Kitchen", "Multiple Bathrooms", "Luxury Bathroom Amenities", "Air Conditioning", "Bathtub"));
    }

    /**
     * Returns a string representation of the Suite.
     * Includes room number, type, price, bed type, number of beds, and current status.
     *
     * @return A string detailing the Suite's attributes.
     */
    @Override
    public String toString() {
        return "Suite{" +
                "roomNumber='" + getRoomNumber() + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                ", bedType=" + bedType +
                ", beds=" + beds +
                ", status=" + status +
                '}';
    }
}

