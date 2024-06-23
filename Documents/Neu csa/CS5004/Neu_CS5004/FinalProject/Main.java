/**
 * Entry point for the Hotel Management System.
 */
public class Main {
    public static void main(String[] args) {
        // Set up the Model and data
        HotelModel model = new HotelModel(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        HotelData.initializeHotelData(model);

        // Set up the Controller and View
        HotelView view = new HotelView();
        HotelController controller = new HotelController(model, view);

        // Run the system
        controller.run();
        view.closeScanner();
    }
}
