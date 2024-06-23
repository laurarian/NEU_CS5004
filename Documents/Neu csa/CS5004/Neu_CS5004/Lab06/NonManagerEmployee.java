import java.util.ArrayList;
import java.util.List;

/**
 * This class  represents an employee that does not have any managerial
 * responsibilities.
 */

public class NonManagerEmployee extends GenericEmployee {

    /**
     * Initializes a non-managerial employee with name, pay, and gender.
     *
     * @param name Employee's name.
     * @param pay Employee's annual pay.
     * @param gender Employee's gender.
     */
    public NonManagerEmployee(String name, double pay, Gender gender) {
        super(name, pay, gender);
    }

    /**
     * Attempts to add a supervisee under this employee, converting to a Supervisor if successful.
     *
     * @param supervisorName The name of the supervisor.
     * @param supervisee The supervisee to add.
     * @return The employee as a Supervisor with the supervisee added, or itself if not the supervisor.
     */
    @Override
    public Employee addSupervisee(String supervisorName, Employee supervisee) {
        if (this.name.equals(supervisorName)) {
            //must first "promote" this employee
            Supervisor newSelf = new Supervisor(this.name, this.pay, this
                    .gender);
            newSelf.addSupervisee(supervisorName, supervisee);
            return newSelf;
        }
        return this;
    }


    /**
     * A placeholder method for removing a supervisee, not implemented for non-managers.
     *
     * @param supervisorName The name of the supervisor.
     * @param supervisee The supervisee to remove.
     * @return Itself, as non-managers cannot have supervisees.
     */
    @Override
    public Employee removeSupervisee(String supervisorName, Employee supervisee) {
        // Non-manager employees do not have supervisees.
        return this;
    }

    /**
     * Prints the employee's information.
     */
    public void printEmployees() {
        System.out.println(this);
    }
}