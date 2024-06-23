import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The HotelView class is responsible for interacting with the user,
 * displaying menus, and capturing user input.
 */
public class HotelView {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays the main menu and captures user choice.
     * @return the user's menu choice as an integer
     */
    public int displayMainMenu() {
        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│      Hotel Management System     │");
        System.out.println("├──────────────────────────────────┤");
        System.out.println("│ 1. View all available rooms      │");
        System.out.println("│ 2. Update room status            │");
        System.out.println("│ 3. Add a new reservation         │");
        System.out.println("│ 4. Cancel a reservation          │");
        System.out.println("│ 5. View today's reservations     │");
        System.out.println("│ 6. View today's income           │");
        System.out.println("│ 7. Exit system                   │");
        System.out.println("└──────────────────────────────────┘");
        System.out.print("Please choose an operation: ");
        return scanner.nextInt();
    }

    /**
     * Displays a generic option.
     * @param index the option index
     * @param description the description of the option
     */
    public void displayOption(int index, String description) {
        System.out.println(index + ". " + description);
    }

    /**
     * Ensures that the input from the user is a valid integer.
     * @return the validated integer input from the user
     */
    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume non-integer input
            System.out.println("Please enter a valid number:");
        }
        return scanner.nextInt();
    }

    /**
     * Prompts the user for an option selection and returns the integer.
     * @param prompt the prompt to display to the user
     * @return the user-selected option
     */
    public int selectOption(String prompt) {
        System.out.println(prompt);
        int input = getUserInput();
        while (input < 1) {
            System.out.println("Please enter a valid number:");
            input = getUserInput();
        }
        return input; // Directly returns the user input
    }

    /**
     * Prompts the user for an option selection by index and adjusts for 0-based indexing.
     * @param prompt the prompt to display to the user
     * @return the user-selected option, adjusted for 0-based index
     */
    public int selectOptionByIndex(String prompt) {
        System.out.println(prompt);
        int input = getUserInput();
        while (input < 1) {
            System.out.println("Please enter a valid number:");
            input = getUserInput();
        }
        return input - 1; // Adjust for 0-based index
    }

    /**
     * Closes the scanner object, typically when the application is closing.
     */
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Displays a message when an invalid option is selected.
     */
    public void displayInvalidOptionMessage() {
        System.out.println("Invalid option, please try again.");
    }


    // ============================ Display methods for different data views ============================

    /**
     * Displays lists of available rooms by type.
     * @param standardRooms list of standard room numbers
     * @param doubleRooms list of double room numbers
     * @param deluxeDoubleRooms list of deluxe double room numbers
     * @param suites list of suite room numbers
     */
    public void listAvailableRooms(LinkedList<String> standardRooms, LinkedList<String> doubleRooms, LinkedList<String> deluxeDoubleRooms, LinkedList<String> suites) {
        System.out.println("Available Standard Rooms:");
        System.out.println(standardRooms.toString());

        System.out.println("Available Double Rooms:");
        System.out.println(doubleRooms.toString());

        System.out.println("Available deluxeDoubleRooms:");
        System.out.println(deluxeDoubleRooms.toString());

        System.out.println("Available Suite:");
        System.out.println(suites.toString());
    }

    /**
     * Prompts the user to select a new room status and returns the selected status.
     * @return the selected RoomStatus
     */
    public RoomStatus getRoomStatusInput() {
        System.out.println("Select a new status:");
        System.out.println("1. Available");
        System.out.println("2. Reserved");
        System.out.println("3. Occupied");
        System.out.println("4. Cleaning");
        int statusOption = getUserInput();

        switch (statusOption) {
            case 1: return RoomStatus.AVAILABLE;
            case 2: return RoomStatus.RESERVED;
            case 3: return RoomStatus.OCCUPIED;
            case 4: return RoomStatus.CLEANING;
            default:
                System.out.println("Invalid input, defaulting to Available.");
                return RoomStatus.AVAILABLE;
        }
    }

    /**
     * Displays the result of a room status update.
     * @param roomNumber the number of the room updated
     * @param newStatus the new status of the room
     */
    public void displayRoomStatusUpdateResult(int roomNumber, RoomStatus newStatus) {
        System.out.printf("Room number %d has been updated to %s.\n", roomNumber, newStatus);
    }

    /**
     * Displays a menu for adding a new reservation.
     */
    public void showReservationMenu() {
        System.out.println("Add a new reservation: please follow the prompts.");
    }   /**
     * Displays a completion message for operations.
     * @param message the message to display
     */
    public void displayOperationCompleted(String message) {
        System.out.println(message);
    }

    /**
     * Displays a message to the user.
     * @param message the message to display
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }


    /**
     * Displays reservation details.
     * @param reservation the reservation to display
     */
    public void displayReservations(Reservation reservation) {
        System.out.println("Reservation ID: " + reservation.getReservationId() + ", Reservation customer: " + reservation.getCustomer().getName() +
                ", Room number: " + reservation.getBookedRooms().stream().map(AbstractRoom::getRoomNumber).collect(Collectors.toList()) +
                ", Check-in date: " + reservation.getStartDate() + ", Check-out date: " + reservation.getEndDate());
    }

    /**
     * Displays the daily revenue.
     * @param revenue the revenue to display
     */
    public void displayDailyRevenue(double revenue) {
        System.out.printf("Today's total income is: $%.2f\n", revenue);
    }

}
