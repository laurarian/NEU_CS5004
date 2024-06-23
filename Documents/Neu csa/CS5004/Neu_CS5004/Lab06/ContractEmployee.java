import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents an employee who works on a term-limited contract
 * with the organization. Contract employees cannot manage
 * other employees within this organization.
 */
public class ContractEmployee extends NonManagerEmployee {
    private LocalDate contractEndDate;

    /**
     * Initializes a contract employee with specified details and end date.
     *
     * @param name  The name of the employee.
     * @param pay   The annual pay of the employee.
     * @param gender The gender of the employee.
     * @param date  The end day of the contract.
     * @param month The end month of the contract.
     * @param year  The end year of the contract.
     * @throws IllegalArgumentException if the end date is invalid.
     */
    public ContractEmployee(String name, double pay, Gender gender, int date, int month, int year) throws IllegalArgumentException {
        super(name, pay, gender);
        //validate our date
        try {
            contractEndDate = LocalDate.of(year, month, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid contract end date");
        }
    }

    /**
     * Returns the contract end date in MMddyyyy format.
     *
     * @return A string representing the end date of the employment contract.
     */
    @Override
    public String getEmploymentEndDate() {
        return DateTimeFormatter.ofPattern("MMddyyyy").format(contractEndDate);
    }

    /**
     * Prints information about this contract employee.
     */
    public void printEmployees() {
        System.out.print("CONTRACTOR ");
        super.printEmployees();

    }
}
