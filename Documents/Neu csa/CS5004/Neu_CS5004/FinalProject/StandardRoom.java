import java.util.List;

/**
 * Represents a Standard Room in the hotel, equipped with basic amenities.
 * This room is ideal for individuals or couples.
 */
public class StandardRoom extends AbstractRoom {

    /**
     * Constructs a Standard Room with specified properties.
     *
     * @param roomNumber The room number.
     * @param price The price per night for the room.
     * @param status The current availability status of the room.
     */
    public StandardRoom(int roomNumber, double price, RoomStatus status) {
        super(roomNumber, RoomType.STANDARD, price, BedType.QUEENSIZE, 1, status,
                List.of("Free WiFi", "Satellite TV", "Air Conditioning", "Electric Kettle"));
    }


    /**
     * Returns a string representation of the Standard Room.
     * Includes room number, type, price, bed type, number of beds, and current status.
     *
     * @return A string detailing the Standard Room's attributes.
     */
    @Override
    public String toString() {
        return "StandardRoom{" +
                "roomNumber='" + getRoomNumber() + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                ", bedType=" + bedType +
                ", beds=" + beds +
                ", status=" + status +
                '}';
    }
}

