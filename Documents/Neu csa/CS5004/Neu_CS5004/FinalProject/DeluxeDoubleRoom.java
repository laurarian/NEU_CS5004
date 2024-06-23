import java.util.List;

/**
 * Represents a Deluxe Double Room that offers premium amenities and luxurious accommodation for business travelers or small families.
 */
public class DeluxeDoubleRoom extends AbstractRoom {

    public DeluxeDoubleRoom(int roomNumber, double price, RoomStatus status) {
        super(roomNumber, RoomType.DELUXE_DOUBLE, price, BedType.KINGSIZE, 1, status,
                List.of("Ultra High-speed WiFi", "Two Flat-screen TVs", "Minibar", "Separate Living Room", "Open Kitchen", "Multiple Bathrooms", "Luxury Bathroom Amenities", "Air Conditioning", "Bathtub"));
    }


    @Override
    public String toString() {
        return "DeluxeDoubleRoom{" +
                "roomNumber='" + getRoomNumber() + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                ", bedType=" + bedType +
                ", beds=" + beds +
                ", status=" + status +
                '}';
    }
}


