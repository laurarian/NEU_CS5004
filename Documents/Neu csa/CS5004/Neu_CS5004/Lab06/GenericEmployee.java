import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class represents the data and operations of any employee. It defines
 * all the operations that either ought to be common to all implementations,
 * or have a reasonable default to be overridden by them.
 */

public abstract class GenericEmployee implements Employee {
    protected String name;
    protected double pay;
    protected Gender gender;

    /**
     * Constructs a generic employee with specified name, pay, and gender.
     *
     * @param name   Employee's name.
     * @param pay    Employee's annual pay.
     * @param gender Employee's gender.
     */
    public GenericEmployee(String name, double pay, Gender gender) {
        this.name = name;
        this.pay = pay;
        this.gender = gender;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public double getAnnualPay() {
        return this.pay;
    }


    /**
     * By default, there is no end date for an employee. Only contract
     * employees have an actual end date.
     *
     * @return
     */
    @Override
    public String getEmploymentEndDate() {
        return "XXXXXXXX";
    }

    /**
     * Counts this employee if they match the given condition.
     *
     * @param condition The condition to match.
     * @return 1 if this employee matches the condition, otherwise 0.
     */
    @Override
    public int count(Predicate<Employee> condition) {
        if (condition.test(this)) {
            return 1;
        }
        return 0;
    }

    /**
     * Converts this employee to a single-item list.
     *
     * @return A list containing just this employee.
     */
    @Override
    public List<Employee> toList() {
        List<Employee> result = new ArrayList<Employee>();
        result.add(this);
        return result;
    }

    /**
     * Converts this employee to a list if they match the given predicate.
     *
     * @param predicate The condition to match.
     * @return A list containing this employee if they match, otherwise an empty list.
     */
    @Override
    public List<Employee> toList(Predicate<Employee> predicate) {
        List<Employee> result = new ArrayList<Employee>();

        if (predicate.test(this)) result.add(this);

        return result;
    }

    public String toString() {
        return "Name : " + name + ", Gender : " + gender + ", Pay : " + pay;
    }

}
