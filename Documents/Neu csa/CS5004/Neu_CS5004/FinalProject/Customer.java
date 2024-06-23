/**
 * Represents a customer in a hotel management system.
 * This class holds information about the customer, including their VIP status,
 * which affects pricing and service preferences.
 */
public class Customer {
    private String name;
    private String phoneNumber;
    private boolean isVIP;

    /**
     * Constructs a new Customer with the specified details.
     * @param name the full name of the customer
     * @param phoneNumber the contact phone number of the customer
     * @param isVIP the VIP status of the customer
     */
    public Customer(String name, String phoneNumber, boolean isVIP) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isVIP = isVIP;
    }

    /**
     * Returns the phone number of the customer.
     * @return the phone number of the customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isVIP() {
        return isVIP;
    }

    /**
     * Updates the VIP status of the customer.
     * @param vip the new VIP status to be set
     */
    public void setVIP(boolean vip) {
        isVIP = vip;
    }

    public String getName() {
        return name;
    }

    /**
     * Provides a string representation of this customer, useful for logs and UI displays.
     * @return a string describing the customer
     */
    @Override
    public String toString() {
        return String.format("Customer{name='%s', phoneNumber='%s', VIP=%b}", name, phoneNumber, isVIP);
    }

}

