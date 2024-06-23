import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implements organizational structure and operations using a tree data model.
 */
public class OrganizationImpl implements Organization {
    private TreeNode<Employee> root;

    /**
     * Initializes the organization with a CEO as the root node.
     *
     * @param nameCEO CEO's name.
     * @param pay CEO's annual pay.
     * @param gender CEO's gender.
     */
    public OrganizationImpl(String nameCEO, double pay, Gender gender) {
        this.root = new LeafNode<>(new InternalEmployee(nameCEO, pay, gender));
    }

    /**
     * Adds an employee under a specified supervisor.
     *
     * @param name Employee's name.
     * @param pay Employee's pay.
     * @param gender Employee's gender.
     * @param supervisorName Supervisor's name.
     */
    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        TreeNode<Employee> newEmployee = new LeafNode<>(new NonManagerEmployee(name, pay, gender));
        root = root.addChild(e -> e.getName().equals(supervisorName), newEmployee);
    }

    /**
     * Adds an existing employee under a specified supervisor.
     *
     * @param employee Employee to add.
     * @param supervisorName Supervisor's name.
     */
    public void addEmployee(Employee employee, String supervisorName) {
        TreeNode<Employee> newEmployeeNode = new LeafNode<>(employee);
        root = root.addChild(e -> e.getName().equals(supervisorName), newEmployeeNode);
    }


    /**
     * Adds a contract employee.
     *
     * @param name Employee's name.
     * @param pay Employee's pay.
     * @param gender Employee's gender.
     * @param endDate Contract end date.
     * @param endMonth Contract end month.
     * @param endYear Contract end year.
     * @param supervisorName Supervisor's name.
     */
    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth, int endYear, String supervisorName) {
        Employee newEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth, endYear);
        root = root.addChild(e -> e.getName().equals(supervisorName), new LeafNode<>(newEmployee));
    }

    /**
     * Gets the total number of employees.
     *
     * @return Total number of employees.
     */
    @Override
    public int getSize() {
        // Maps each Employee to 1, then uses reduce to sum these values to get the total number of employees
        return root.map(e -> 1).reduce(0, (a, b) -> a + b);
    }


    /**
     * Filters employees by a condition.
     *
     * @param predicate Condition to filter by.
     * @return Number of employees meeting the condition.
     */
    public int getSize(Predicate<Employee> predicate) {
        // Map each employee to 1 if they meet the condition, otherwise to 0, then sum these values.
        return root.map(e -> predicate.test(e) ? 1 : 0).reduce(0, (a, b) -> a + b);
    }

    /**
     * Counts employees by gender.
     *
     * @param gender Gender to count by.
     * @return Number of employees of specified gender.
     */
    @Override
    public int getSizeByGender(Gender gender) {
        // Map each Employee to 1 or 0, depending on whether their gender matches.
        // Then, sum these values.
        return root.map(e -> e.getGender() == gender ? 1 : 0).reduce(0, (a, b) -> a + b);
    }

    /**
     * Lists all employees.
     *
     * @return List of employee names.
     */
    @Override
    public List<String> allEmployees() {
        // Convert the tree of employees into a list of their names
        return root.map(e -> e.getName()).toList();
    }

    /**
     * Lists employees matching a predicate.
     *
     * @param predicate Condition to match.
     * @return List of matching employee names.
     */
    @Override
    public List<String> allEmployees(Predicate<Employee> predicate){
        List<Employee> employees = root.toList();
        List<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                result.add(employee.getName());
            }
        }
        return result;
    }

    /**
     * Counts employees terminated before a certain date.
     *
     * @param date Termination date.
     * @param month Termination month.
     * @param year Termination year.
     * @return Number of employees terminated before specified date.
     */
    @Override
    public int terminatedBefore(int date, int month, int year) {
        LocalDate threshold = LocalDate.of(year, month, date);
        // Maps employees whose termination date is before the specified threshold to 1, others to 0
        // then sums these values to count employees meeting the condition.
        return root.map(e -> {
            if (!e.getEmploymentEndDate().equals("XXXXXXXX")) {
                LocalDate endDate = LocalDate.parse(e.getEmploymentEndDate(), DateTimeFormatter.ofPattern("MMddyyyy"));
                return endDate.isBefore(threshold) ? 1 : 0;
            }
            return 0;
        }).reduce(0, (a, b) -> a + b);
    }


    /**
     * Prints all employees in the organization.
     */
    public void printEmployees() {
        root.print();
    }
}
