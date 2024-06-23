/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Description: Demonstrates the functionality of a generic linked list managing Tasks, Meetings, and Chores.
 * Showcases methods such as add, getNodeAtIndex, countIf, filter and toString method with detailed output to illustrate
 * the list's behavior and the use of generic types and predicates.
 */

public class Driver {
    public static void main(String[] args) {
        // Initialize a diverse list of tasks
        System.out.println("Initializing Task LinkedList with diverse tasks");
        LinkedList<Task> taskList = new LinkedList<>();
        taskList.addAtTop(new Task(1, "CS5004 Assignment", new Date(2024, 3, 20, 10, 0), false, Priority.MEDIUM));
        taskList.addAtBottom(new Task(2, "CS5008 Task", new Date(2024, 3, 22, 14, 0), false, Priority.HIGH));
        taskList.addAtBottom(new Task(3, "Leetcode", new Date(2024, 3, 25, 9, 0), true, Priority.LOW));
        taskList.addAtBottom(new Task(4, "Project", new Date(2024, 3, 18, 11, 0), true, Priority.HIGH));
        System.out.println("Task LinkedList after adding tasks:\n" + taskList);

        // Initialize a diverse list of meetings
        System.out.println("\nInitializing Meeting LinkedList with diverse meetings");
        LinkedList<Meeting> meetingList = new LinkedList<>();
        meetingList.addAtTop(new Meeting("Project Updates Meeting", "Conference Room A", 2024, 3, 10, 10, 30, 1.5));
        meetingList.addAtBottom(new Meeting("Coding Standards Review", "Conference Room B", 2024, 3, 12, 14, 0, 2.0));
        meetingList.addAtBottom(new Meeting("Brainstorming Session", "Main Auditorium", 2024, 3, 15, 10, 0, 3.0));
        meetingList.addAtBottom(new Meeting("Algorithm Optimization Meeting", "Conference Room B", 2024, 3, 18, 9, 0, 2.5));
        System.out.println("Meeting LinkedList after adding meetings:\n" + meetingList);

        // Initialize a diverse list of chores
        System.out.println("\nInitializing Chore LinkedList with diverse chores");
        LinkedList<Chore> choreList = new LinkedList<>();
        choreList.addAtTop(new Chore("Room cleaning", "Weekly", false));
        choreList.addAtBottom(new Chore("Washing clothes", "Monthly", false));
        choreList.addAtBottom(new Chore("Plant watering", "Daily", true));
        choreList.addAtBottom(new Chore("Cooking", "Monthly", false));
        System.out.println("Chore LinkedList after adding chores:\n" + choreList);

        // Test getNodeAtIndex for each list
        System.out.println("\n*************************** Testing getNodeAtIndex ***************************");
        System.out.println("Task at index 2: " + taskList.getNodeAtIndex(2).getData());
        System.out.println("Meeting at index 1: " + meetingList.getNodeAtIndex(1).getData());
        System.out.println("Chore at index 0: " + choreList.getNodeAtIndex(0).getData());

        // Test countIf for each list
        System.out.println("\n*************************** Test countIf ***************************");
        System.out.println("Count of high priority tasks: " + taskList.countIf(t -> t.getPriority() == Priority.HIGH));
        System.out.println("Count of meetings in Conference Room A: " + meetingList.countIf(m -> m.getLocation().equals("Conference Room A")));
        System.out.println("Count of daily chores: " + choreList.countIf(c -> c.getFrequency().equals("Daily")));

        // Test filter method and use toString to print the filter results for each list
        System.out.println("\n*************************** Test filter and use toString to print the filter results ***************************");
        System.out.println("High priority tasks:\n" + taskList.filter(t -> t.getPriority() == Priority.HIGH));
        System.out.println();
        System.out.println("Meetings in Conference Room B:\n" + meetingList.filter(m -> m.getLocation().equals("Conference Room B")));
        System.out.println();
        System.out.println("Unfinished chores:\n" + choreList.filter(c -> !c.isDone()));

        // Test mixed LinkedList
        System.out.println("\n*************************** Test Mixed LinkedList ***************************");
        LinkedList<Object> mixedList = new LinkedList<>();
        mixedList.addAtTop(taskList.getNodeAtIndex(1).getData());
        mixedList.addAtBottom(meetingList.getNodeAtIndex(2).getData());
        mixedList.addAtBottom(choreList.getNodeAtIndex(1).getData());
        mixedList.addAtBottom(choreList.getNodeAtIndex(2).getData());
        System.out.println("Mixed LinkedList after adding diverse items:\n" + mixedList);

        // Test countIf for the mixed list - Counting all chores as an example
        System.out.println("\n*************************** Test Mixed LinkedList: CountAllChores ***************************");
        System.out.println("Count all chores in mixed list: " + mixedList.countIf(obj -> obj instanceof Chore));

        // Test getNodeAtIndex for the mixed list
        System.out.println("\n*************************** Test Mixed LinkedList: getNodeAtIndex ***************************");
        System.out.println("First item in the mixed list: " + mixedList.getNodeAtIndex(0).getData());
        System.out.println("Second item in the mixed list: " + mixedList.getNodeAtIndex(1).getData());
        System.out.println("Third item in the mixed list: " + mixedList.getNodeAtIndex(2).getData());
        System.out.println("Fourth item in the mixed list: " + mixedList.getNodeAtIndex(3).getData());

        // Test countIf for the mixed list
        System.out.println("\n*************************** Test Mixed LinkedList: countIf ***************************");
        System.out.println("Count of Tasks in the mixed list: " + mixedList.countIf(obj -> obj instanceof Task));
        System.out.println("Count of Meetings in the mixed list: " + mixedList.countIf(obj -> obj instanceof Meeting));
        System.out.println("Count of Chores in the mixed list: " + mixedList.countIf(obj -> obj instanceof Chore));

        // Test filter method for the mixed list
        System.out.println("\n*************************** Test Mixed LinkedList: filter and toString ***************************");
        System.out.println("High priority tasks in the mixed list:\n" + mixedList.filter(obj -> obj instanceof Task && ((Task) obj).getPriority() == Priority.HIGH));
        System.out.println();
        System.out.println("Meetings in Main Auditorium:\n" + mixedList.filter(obj -> obj instanceof Meeting && ((Meeting) obj).getLocation().equals("Main Auditorium")));
        System.out.println();
        System.out.println("Unfinished chores in the mixed list:\n" + mixedList.filter(obj -> obj instanceof Chore && !((Chore) obj).isDone()));

        // Conclude the testing
        System.out.println("\n*************************** Test Complete ***************************");
        System.out.println("Completed testing all functionalities of LinkedList with Tasks, Meetings, and Chores.");
    }
}


