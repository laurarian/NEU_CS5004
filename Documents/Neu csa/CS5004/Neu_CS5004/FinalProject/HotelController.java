import java.time.LocalDate;

public class HotelController {
    private final HotelModel model;
    private final HotelView view;

    public HotelController(HotelModel model, HotelView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            int choice = view.displayMainMenu();
            switch (choice) {
                case 1:
                    listAvailableRooms();
                    break;
                case 2:
                    updateRoomStatus();
                    break;
                case 3:
                    addReservation();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    viewTodayReservations();
                    break;
                case 6:
                    viewDailyRevenue();
                    break;
                case 7:
                    running = false; // Exit the program
                    break;
                default:
                    view.displayInvalidOptionMessage();
            }
        }
    }

    /**
     * 1. List all available rooms
     */
    private void listAvailableRooms() {
        LinkedList<String> standardRooms = model.getAvailableRooms(RoomType.STANDARD);
        LinkedList<String> doubleRooms = model.getAvailableRooms(RoomType.DOUBLE);
        LinkedList<String> deluxeDoubleRooms = model.getAvailableRooms(RoomType.DELUXE_DOUBLE);
        LinkedList<String> suites = model.getAvailableRooms(RoomType.SUITE);
        view.listAvailableRooms(standardRooms, doubleRooms, deluxeDoubleRooms, suites);
    };

    /**
     * 2. Update room status
     */
    private void updateRoomStatus() {
        // Show all rooms and their status
        int size = model.getRooms().countIf(x -> true);
        for (int i = 0; i < size; i++) {
            AbstractRoom room = model.getRoomByIndex(i);
            view.displayOption(i + 1, "Room Number: " + room.getRoomNumber() + ", Current Status: " + room.getStatus().toString());
        }

        // Let users enter room number
        int roomNumber = view.selectOption("Please enter the room number to update:");
        AbstractRoom selectedRoom;
        try {
            selectedRoom = model.getRoomByRoomNumber(roomNumber);
        } catch (IllegalArgumentException e) {
            view.displayMessage(e.getMessage());
            return;
        }

        RoomStatus newStatus = view.getRoomStatusInput();
        model.updateRoomStatus(selectedRoom.getRoomNumber(), newStatus);
        view.displayRoomStatusUpdateResult(selectedRoom.getRoomNumber(), newStatus);
    }

    /**
     * 3. Add a new reservation
     */
    public void addReservation() {
        view.showReservationMenu();
        //Display customer list and select customer
        int customerCount = model.getCustomers().countIf(x -> true);
        for (int i = 0; i < customerCount; i++) {
            Customer cust = model.getCustomerByIndex(i);
            view.displayOption(i + 1, cust.getName() + ", Phone: " + cust.getPhoneNumber());
        }
        int customerIndex = view.selectOptionByIndex("Select a customer number:");
        Customer customer = model.getCustomerByIndex(customerIndex);

        // Display the room list and select a room
        view.displayMessage("Available room list:");
        listAvailableRooms();
        int roomNumber = view.selectOption("Please enter the room number:");
        AbstractRoom room = model.getRoomByRoomNumber(roomNumber);

        int startDateOffset = view.selectOption("Select check-in date: 1 - Today, 2 - Tomorrow, 3 - Day after tomorrow") - 1;
        LocalDate startDate = LocalDate.now().plusDays(startDateOffset);
        int endDateOffset = view.selectOption("Select check-out date: 1 - Today, 2 - Tomorrow, 3 - Day after tomorrow") - 1;
        LocalDate endDate = LocalDate.now().plusDays(endDateOffset);

        //Create and add reservations
        Reservation newReservation = new Reservation(model.generateReservationId(), startDate, endDate, customer);
        newReservation.addRoom(room);
        model.addReservation(newReservation);
        view.displayOperationCompleted("Reservation added. Room Number: " + room.getRoomNumber() + ", Number of nights: " + startDate.until(endDate).getDays());
    }

    /**
     * 4. Cancel reservation
     */
    private void cancelReservation() {
        view.displayMessage("Current reservations:");
        for (int i = 0; i < model.getReservations().countIf(x -> true); i++) {
            Reservation res = model.getReservations().getNodeAtIndex(i).getData();
            view.displayMessage((i + 1) + ". Reservation ID: " + res.getReservationId() + ", Customer: " + res.getCustomer().getName() + ", Room Number: " + res.getBookedRooms().get(0).getRoomNumber());
        }

        int reservationIndex = view.selectOptionByIndex("Please select a reservation number to cancel:");
        Reservation selectedReservation = model.getReservations().getNodeAtIndex(reservationIndex).getData();
        model.removeReservation(selectedReservation.getReservationId());
        view.displayOperationCompleted("Reservation cancelled. Reservation ID: " + selectedReservation.getReservationId());
    }

    /**
     * 5. Check the booking status of the day
     */
    private void viewTodayReservations() {
        LocalDate today = LocalDate.now();
        LinkedList<Reservation> todayReservations = model.getReservationsForDay(today);
        if (todayReservations.countIf(x -> true) == 0) {
            view.displayMessage("No reservations today.");
        } else {
            view.displayMessage("Today's reservations:");
            for (int i = 0; i < todayReservations.countIf(x -> true); i++) {
                Reservation res = todayReservations.getNodeAtIndex(i).getData();
                view.displayReservations(res);
            }
        }
    }

    /**
     * 6. View today's revenue
     */
    private void viewDailyRevenue() {
        LocalDate today = LocalDate.now();
        double revenue = model.calculateDailyRevenue(today);
        view.displayDailyRevenue(revenue);
    }
}