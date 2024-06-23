/**
 * Represents the status of a room.
 */
public enum RoomStatus {
    AVAILABLE, // vacant and available for booking.
    RESERVED, // reserved but not yet occupied.
    OCCUPIED, // currently occupied by a guest.
    CLEANING, // cleaned and prepared for the next guest.
}
