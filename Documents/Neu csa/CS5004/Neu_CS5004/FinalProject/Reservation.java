import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a reservation in the hotel management system.
 * Manages the rooms booked as part of a reservation and calculates the total price based on room rates and duration.
 */
public class Reservation {
    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Customer customer;
    private List<AbstractRoom> bookedRooms; // Stores booked rooms

    /**
     * Constructs a new Reservation with specified details.
     * @param reservationId the unique ID of the reservation
     * @param startDate the start date of the reservation
     * @param endDate the end date of the reservation
     * @param customer the customer who made the reservation
     */
    public Reservation(int reservationId, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.bookedRooms = new ArrayList<>();
    }

    /**
     * Adds a room to this reservation.
     * @param room the room to be added
     */
    public void addRoom(AbstractRoom room) {
        bookedRooms.add(room);
    }

    /**
     * Removes a room from this reservation.
     * @param room the room to be removed
     */
    public void removeRoom(AbstractRoom room) {
        bookedRooms.remove(room);
    }

    /**
     * Calculates the total price for the reservation, accounting for the duration, room rates, and any VIP discounts.
     * @return the total calculated price
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        int days = startDate.until(endDate).getDays();
        double discountRate = customer.isVIP() ? 0.95 : 1.0; // 5% discount for VIPs

        for (AbstractRoom room : bookedRooms) {
            totalPrice += room.price * days;
        }

        return totalPrice * discountRate;
    }

    /**
     * Provides a comprehensive string representation of this reservation, including details for each booked room.
     * @return a string description of the reservation
     */
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        for (AbstractRoom room : bookedRooms) {
            details.append(String.format("\nRoom Number: %d, Room Type: %s, Price per Night: $%.2f",
                    room.getRoomNumber(), room.getRoomType(), room.getPrice()));
        }
        return String.format("Reservation ID: %d, Customer: %s, From: %s, To: %s, Total Price: $%.2f, Rooms Booked: %s",
                reservationId, customer.getName(), startDate, endDate, calculateTotalPrice(), details);
    }

    // Getter methods for the reservation details
    public int getReservationId() {
        return reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Customer getCustomer() {
        return customer;
    }


    public List<AbstractRoom> getBookedRooms() {
        return new ArrayList<>(bookedRooms); // Return a copy to prevent external modifications
    }
}

