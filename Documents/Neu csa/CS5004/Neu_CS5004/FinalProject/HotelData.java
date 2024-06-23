import java.time.LocalDate;

public class HotelData {
    public static void initializeHotelData(HotelModel model) {
        initializeRooms(model);
        initializeCustomers(model);
        initializeReservations(model);
    }

    private static void initializeRooms(HotelModel model) {
        int roomNumber;
        // Ensure at least two rooms of each type are AVAILABLE
        for (int floor = 1; floor <= 3; floor++) {
            for (int room = 1; room <= 12; room++) {
                roomNumber = floor * 100 + room;
                AbstractRoom newRoom;
                RoomStatus status;

                // Ensure at least one room of each type per floor is available
                if ((room % 3 == 1 && floor % 3 == 1) || (room % 3 == 2 && floor % 3 == 2)) { // 简单轮换模式
                    status = RoomStatus.AVAILABLE;
                } else if (room % 4 == 1) {
                    status = RoomStatus.RESERVED;
                } else if (room % 4 == 2) {
                    status = RoomStatus.OCCUPIED;
                } else {
                    status = RoomStatus.CLEANING;
                }

                switch (room % 4) {
                    case 0:
                        newRoom = new StandardRoom(roomNumber, 100.0, status);
                        break;
                    case 1:
                        newRoom = new DeluxeDoubleRoom(roomNumber, 200.0, status);
                        break;
                    case 2:
                        newRoom = new Suite(roomNumber, 300.0, status);
                        break;
                    default:
                        newRoom = new DoubleRoom(roomNumber, 150.0, status);
                        break;
                }
                model.addRoom(newRoom);
            }
        }
    }

    private static void initializeCustomers(HotelModel model) {
        // Create 24 customers
        for (int i = 1; i <= 24; i++) {
            String name = "Customer" + i;
            String phone = String.format("(555) 123-%04d", 4000 + i);
            boolean isVIP = i % 2 == 0; // Make every second customer a VIP
            Customer customer = new Customer(name, phone, isVIP);
            model.addCustomer(customer);
        }
    }

    private static void initializeReservations(HotelModel model) {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Create 24 reservations, ensuring some start yesterday and end today
        for (int i = 0; i < 24; i++) {
            Customer customer = model.getCustomers().getNodeAtIndex(i).getData();
            AbstractRoom room = model.getRooms().getNodeAtIndex(i % 36).getData();

            // Set some reservations to start yesterday and end today
            LocalDate startDate = (i < 12) ? today.minusDays(1) : today.plusDays(i % 3);
            LocalDate endDate = (i < 12) ? today : startDate.plusDays(3);

            Reservation reservation = new Reservation(i + 1, startDate, endDate, customer);
            reservation.addRoom(room);
            model.addReservation(reservation);
        }
    }
}
