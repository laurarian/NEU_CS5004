/**
 * Interface for hotel room operations.
 */
public interface IRoom {

    /**
     * Gets the room type.
     * @return the room type
     */
    RoomType getRoomType();

    /**
     * Gets the room's current status.
     * @return the status
     */
    RoomStatus getStatus();

    /**
     * Sets the room's status.
     * @param newStatus the new status to set
     */
    void updateStatus(RoomStatus newStatus);

    /**
     * Returns a string representation of the room.
     * @return room details as a string
     */
    String toString();

}


