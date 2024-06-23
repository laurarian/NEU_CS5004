/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Tests for LinkedList.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestLinkedList {
    private LinkedList<Task> taskList;
    private LinkedList<Meeting> meetingList;
    private LinkedList<Chore> choreList;
    private Task task1, task2;
    private Meeting meeting1, meeting2;
    private Chore chore1, chore2;

    @Before
    public void setUp() {
        task1 = new Task(1, "Task 1", new Date(2024, 3, 20, 10, 0), false, Priority.HIGH);
        task2 = new Task(2, "Task 2", new Date(2024, 3, 21, 11, 0), true, Priority.LOW);
        meeting1 = new Meeting("Meeting 1", "Location 1", 2024, 3, 20, 10, 0, 2.0);
        meeting2 = new Meeting("Meeting 2", "Location 2", 2024, 3, 21, 11, 0, 1.5);
        chore1 = new Chore("Chore 1", "Weekly", false);
        chore2 = new Chore("Chore 2", "Daily", true);

        taskList = new LinkedList<>();
        meetingList = new LinkedList<>();
        choreList = new LinkedList<>();
    }

    @Test
    public void testAddAtTop() {
        taskList.addAtTop(task1);
        assertEquals("First element should be task1", task1, taskList.getNodeAtIndex(0).getData());
    }

    @Test
    public void testAddAtBottom() {
        taskList.addAtBottom(task1);
        assertEquals("The first element should be task1 after adding to bottom",
                task1, taskList.getNodeAtIndex(0).getData());

        taskList.addAtBottom(task2);
        assertEquals("The second element should be task2 after adding to bottom",
                task2, taskList.getNodeAtIndex(1).getData());
    }


    @Test
    public void testRemoveAtIndex() {
        taskList.addAtTop(task1);
        taskList.addAtTop(task2);
        taskList.removeAtIndex(0);
        assertEquals("Element should be task1 after removal of task2", task1, taskList.getNodeAtIndex(0).getData());
    }

    @Test
    public void testRemoveAllTasks() {
        taskList.addAtTop(task1);
        taskList.removeAllTasks();
        assertEquals("List should be empty after removing all tasks", "EmptyNode", taskList.toString());
    }

    @Test
    public void testCountIf() {
        choreList.addAtTop(chore1);
        choreList.addAtTop(chore2);
        int count = choreList.countIf(Chore::isDone);
        assertEquals("Count of done chores should be 1", 1, count);
    }

    @Test
    public void testFilter() {
        choreList.addAtTop(chore1);
        choreList.addAtTop(chore2);
        Node<Chore> filtered = choreList.filter(Chore::isDone);
        assertEquals("Filtered list should contain only done chores", chore2, filtered.getData());
    }

    @Test
    public void testGetNodeAtIndex() {
        meetingList.addAtTop(meeting1);
        meetingList.addAtTop(meeting2);
        assertEquals("Should get meeting2 at index 0", meeting2, meetingList.getNodeAtIndex(0).getData());
    }

    @Test
    public void testToString() {
        taskList.addAtTop(task1);
        assertEquals("String representation should match task1", task1.toString(), taskList.toString().trim());
    }

    @Test
    public void testToStringWithPredicate() {
        taskList.addAtTop(task1); // Assuming task1 is HIGH priority
        taskList.addAtTop(task2); // Assuming task2 is LOW priority
        String filteredString = taskList.toString(task -> task.getPriority() == Priority.HIGH);
        assertEquals("String representation should include only high priority tasks", task1.toString(), filteredString.trim());
    }
}

