import java.util.List;

/**
 * Abstract implementation of a hotel room that implements IRoom.
 * Provides common functionality that can be inherited by specific room types.
 */
public abstract class AbstractRoom implements IRoom {
    private final int roomNumber;
    protected final RoomType roomType;
    protected double price;
    protected final BedType bedType;
    protected final int beds;
    protected RoomStatus status;
    protected final List<String> amenities; // Using List interface; implementation specifics provided in subclasses

    public AbstractRoom(int roomNumber, RoomType roomType, double price, BedType bedType, int beds, RoomStatus status, List<String> amenities) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.bedType = bedType;
        this.beds = beds;
        this.status = status;
        this.amenities = amenities;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public RoomStatus getStatus() {
        return status;
    }

    public void updateStatus(RoomStatus newStatus) {
        this.status = newStatus;
    }

    /**
     * Provides detailed information about the room, combining description, amenities, and current status.
     * Subclasses must implement this method to provide specific details.
     * @return a comprehensive string with all room details.
     */
    public abstract String toString();


    public int getRoomNumber() {
        return roomNumber;
    }


    public double getPrice() {
        return price;
    }


    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public List<String> getAmenities() {
        return amenities;
    }

}

