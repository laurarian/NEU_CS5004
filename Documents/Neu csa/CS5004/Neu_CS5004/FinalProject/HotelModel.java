import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The HotelModel class encapsulates the business logic for managing hotel operations.
 * It handles operations related to rooms, reservations, customers, and service requests.
 */
public class HotelModel {
    private LinkedList<AbstractRoom> rooms;
    private LinkedList<Reservation> reservations;
    private LinkedList<Customer> customers;
    private static int nextReservationId = 25;

    public HotelModel(LinkedList<AbstractRoom> rooms, LinkedList<Reservation> reservations,
                      LinkedList<Customer> customers) {
        this.rooms = rooms;
        this.reservations = reservations;
        this.customers = customers;
    }

    // ============================ Room Management ============================
    /**
     * Adds a new room to the hotel.
     * @param room the room to be added
     */
    public void addRoom(AbstractRoom room) {
        rooms.addAtBottom(room);
    }

    /**
     * Removes a room by its number.
     * @param roomNumber the number of the room to be removed
     */
    public void removeRoom(int roomNumber) {
        int index = rooms.findIndex(room -> room.getRoomNumber() == roomNumber);
        if (index != -1) {
            rooms.removeAtIndex(index);
        }
    }

    /**
     * Updates the status of a room.
     * @param roomNumber the number of the room to update
     * @param newStatus the new status to be set
     * @return true if the update was successful, false otherwise
     */
    public boolean updateRoomStatus(int roomNumber, RoomStatus newStatus) {
        boolean updated = rooms.updateIf(
                room -> room.getRoomNumber() == roomNumber,
                room -> {
                    room.setStatus(newStatus);
                    return room;
                }
        );
        if (updated) {
            System.out.println("Room status updated: room number " + roomNumber + " newStatus: " + newStatus);
        } else {
            System.out.println("Room update failed: room number not found " + roomNumber);
        }
        return updated;
    }

    /**
     * Lists all available rooms of a specific type.
     * @param roomType the type of room to filter by
     * @return a list of room numbers that are available and match the room type
     */
    public LinkedList<String> getAvailableRooms(RoomType roomType) {
        Predicate<AbstractRoom> isTypeAndAvailable = room -> {
            return room.getRoomType() == roomType && room.getStatus() == RoomStatus.AVAILABLE;
        };
        Function<AbstractRoom, String> getRoomNumber = room -> Integer.toString(room.getRoomNumber());
        return rooms.filter(isTypeAndAvailable).map(getRoomNumber);
    }

    /** Retrieves a room by its index in the list. */
    public AbstractRoom getRoomByIndex(int index) {
        Node<AbstractRoom> node = rooms.getNodeAtIndex(index);
        if (node == null) {
            throw new IllegalArgumentException("No room found at index: " + index);
        }
        return node.getData();
    }

    /** Retrieves a room by its room number. */
    public AbstractRoom getRoomByRoomNumber(int roomNumber) {
        for (int i = 0; i < rooms.countIf(x -> true); i++) {
            AbstractRoom room = rooms.getNodeAtIndex(i).getData();
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        throw new IllegalArgumentException("No room found with number: " + roomNumber);
    }

    // ============================ Reservation Management ============================
    public synchronized int generateReservationId() {
        return nextReservationId++;
    }

    /**
     * Adds a new reservation.
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        reservations.addAtBottom(reservation);
    }

    /**
     * Removes a reservation by its ID.
     * @param reservationId the ID of the reservation to remove
     * @return true if the reservation was successfully removed, false otherwise
     */
    public boolean removeReservation(int reservationId) {
        return reservations.removeIf(res -> res.getReservationId() == reservationId);
    }

    /**
     * Retrieves all reservations for a specific date.
     * This is useful for viewing and managing daily bookings.
     *
     * @param date The date for which reservations are to be retrieved.
     * @return A list of reservations for that date.
     */
    public LinkedList<Reservation> getReservationsForDay(LocalDate date) {
        Predicate<Reservation> isToday = reservation -> reservation.getStartDate().equals(date) || reservation.getEndDate().equals(date);
        return reservations.filter(isToday);
    }

    // ============================ Customer Management ============================
    /**
     * Adds a customer to the hotel's customer list.
     * @param customer The customer to be added.
     */
    public void addCustomer(Customer customer) {
        customers.addAtBottom(customer);
    }


    /** Retrieves a customer by their index in the list. */
    public Customer getCustomerByIndex(int index) {
        return customers.getNodeAtIndex(index).getData();  // 通过节点获取客户数据
    }


    // ============================ Financial Management ============================
    /**
     * Calculates total revenue for the day from reservations ending on the specified date.
     * This helps in financial reporting and management.
     * @param date The day for which revenue is calculated.
     * @return Total daily revenue.
     */
    public double calculateDailyRevenue(LocalDate date) {
        Predicate<Reservation> endsToday = reservation -> reservation.getEndDate().equals(date);
        Function<Reservation, Double> toPrice = Reservation::calculateTotalPrice;

        // Debugging output
        System.out.println("Today's reservations : " + reservations.filter(endsToday).countIf(x -> true));

        return reservations.filter(endsToday).map(toPrice).reduce(0.0, Double::sum);
    }

    // ============================ Others ============================

    // Getters
    public LinkedList<AbstractRoom> getRooms() {
        return rooms;
    }

    public LinkedList<Reservation> getReservations() {
        return reservations;
    }

    public LinkedList<Customer> getCustomers() {
        return customers;
    }

}
