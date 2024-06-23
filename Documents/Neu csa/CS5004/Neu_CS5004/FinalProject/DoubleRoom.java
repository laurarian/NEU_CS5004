import java.util.List;

/**
 * Represents a Double Room in the hotel, designed for friends or colleagues with two twin beds.
 */
public class DoubleRoom extends AbstractRoom {
    public DoubleRoom(int roomNumber, double price, RoomStatus status) {
        super(roomNumber, RoomType.DOUBLE, price, BedType.KINGSIZE, 1, status,
                List.of("Ultra High-speed WiFi", "Two Flat-screen TVs", "Minibar",
                        "Separate Living Room", "Open Kitchen", "Multiple Bathrooms",
                        "Luxury Bathroom Amenities", "Air Conditioning", "Bathtub"));
    }


    @Override
    public String toString() {
        return "DoubleRoom{" +
                "roomNumber='" + getRoomNumber() + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                ", bedType=" + bedType +
                ", beds=" + beds +
                ", status=" + status +
                '}';
    }
}

