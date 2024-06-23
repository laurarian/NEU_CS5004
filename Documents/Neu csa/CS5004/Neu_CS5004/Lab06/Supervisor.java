//package organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
//import util.Gender;

/**
 * This class represents an employee in a supervisory role. This means that this
 * employee supervises at least one other employee
 */
public class Supervisor extends GenericEmployee {

    private List<Employee> superviseeList;

    /**
     * Constructs a supervisor with name, pay, and gender.
     *
     * @param name Supervisor's name.
     * @param pay Supervisor's annual pay.
     * @param gender Supervisor's gender.
     */
    public Supervisor(String name, double pay, Gender gender) {
        super(name, pay, gender);
        superviseeList = new LinkedList<Employee>();
    }

    /**
     * Adds a supervisee under this supervisor.
     *
     * @param supervisorName Name of the supervisor.
     * @param supervisee The employee to be supervised.
     * @return The updated supervisor.
     */
    @Override
    public Employee addSupervisee(String supervisorName, Employee supervisee) {
        if (this.name.equals(supervisorName)) {
            this.superviseeList.add(supervisee);
            return this;
        }
        for (int i = 0; i < this.superviseeList.size(); i++) {
            this.superviseeList.set(
                    i,
                    this.superviseeList.get(i).addSupervisee(supervisorName,
                            supervisee));
        }
        return this;
    }

    /**
     * Removes a supervisee from under this supervisor.
     *
     * @param supervisorName Name of the supervisor.
     * @param supervisee The employee to stop supervising.
     * @return The updated supervisor.
     */
    @Override
    public Employee removeSupervisee(String supervisorName, Employee supervisee) {
        if (this.name.equals(supervisorName)) {
            this.superviseeList.remove(supervisee);
            return this;
        }
        for (int i = 0; i < this.superviseeList.size(); i++) {
            this.superviseeList.set(
                    i,
                    this.superviseeList.get(i).removeSupervisee(supervisorName,
                            supervisee));
        }
        return this;
    }

    /**
     * Counts the number of supervisees matching a specific condition.
     *
     * @param condition The condition to match against.
     * @return The count of matching supervisees.
     */
    @Override
    public int count(Predicate<Employee> condition) {
        Stream<Employee> stream = this.superviseeList.stream();
        return this.superviseeList.stream()
                .mapToInt(b -> b.count(condition))
                .sum()
                + super.count(condition);
    }

    /**
     * Converts the supervisee list to a flat list of all employees under supervision.
     *
     * @return List of all supervised employees.
     */
    @Override
    public List<Employee> toList() {
        List<Employee> result = new ArrayList<Employee>();
        result.add(this);
        for (Employee e : superviseeList) {
            result.addAll(e.toList());
        }
        return result;
    }

    /**
     * Converts the supervisee list to a list filtered by a given condition.
     *
     * @param predicate The condition to filter supervisees.
     * @return Filtered list of supervisees.
     */
    @Override
    public List<Employee> toList(Predicate<Employee> predicate) {
        List<Employee> result = new ArrayList<Employee>();

        if (predicate.test(this)) result.add(this);

        for (Employee e : superviseeList) {
            result.addAll(e.toList(predicate));
        }
        return result;
    }

    /**
     * Prints information about the supervisor and their supervisees.
     */
    public void printEmployees() {
        System.out.println("SUPERVISOR " + this);

        for (Employee e : superviseeList) {
            e.printEmployees();
        }
    }
}