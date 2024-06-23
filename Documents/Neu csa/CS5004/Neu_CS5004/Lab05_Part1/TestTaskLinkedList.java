import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * Tests for the TaskLinkedList class. These tests check adding, removing, updating,
 * and listing tasks work as expected, ensuring the list functions smoothly.
 */

public class TestTaskLinkedList {

    private TaskLinkedList list;
    private Date earlyDate, laterDate, newDate;
    private Task task1, task2, task3;

    @Before
    public void setUp() {
        list = new TaskLinkedList();
        earlyDate = new Date(2023, 3, 10, 9, 30);
        laterDate = new Date(2023, 4, 20, 11, 0);
        newDate = new Date(2023, 5, 15, 10, 45); // New date for changing task date

        task1 = new Task(1, "Task 1 Description", earlyDate, false, Priority.LOW);
        task2 = new Task(2, "Task 2 Description", laterDate, true, Priority.HIGH);
        task3 = new Task(3, "Task 3 Description", earlyDate, false, Priority.MEDIUM);
    }

    @Test
    public void testConstructor() {
        // Since we cannot directly check a private field, we verify the list's initial state indirectly.
        // An empty list should return an empty string when listing all tasks or have a count of 0 tasks.
        assertEquals("An newly initialized list should have no tasks", "", list.listAllTasks());
        assertEquals("An newly initialized list should have a count of 0 tasks", 0, list.countAllTasks());
    }

    @Test
    public void testAddAndListTasks() {
        // Test adding tasks and listing them correctly
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        assertEquals("ID: 1 - Date: 2023/3/10 09:30 - Description: Task 1 Description - Priority: LOW - Completed: No\n" +
                        "ID: 2 - Date: 2023/4/20 11:00 - Description: Task 2 Description - Priority: HIGH - Completed: Yes",
                list.listAllTasks());

        // Test adding a task by priority
        list.addTaskByPriority(task3);
        assertEquals("ID: 3 - Date: 2023/3/10 09:30 - Description: Task 3 Description - Priority: MEDIUM - Completed: No\n" +
                        "ID: 1 - Date: 2023/3/10 09:30 - Description: Task 1 Description - Priority: LOW - Completed: No\n" +
                        "ID: 2 - Date: 2023/4/20 11:00 - Description: Task 2 Description - Priority: HIGH - Completed: Yes",
                list.listAllTasks());
    }

    @Test
    public void testRemoveTaskAtIndex() {
        // Test removing a task at a specific index
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        list.removeTaskAtIndex(0); // Remove task1
        assertEquals("ID: 2 - Date: 2023/4/20 11:00 - Description: Task 2 Description - Priority: HIGH - Completed: Yes", list.listAllTasks());
    }

    @Test
    public void testRemoveAllTasks() {
        // Test removing all tasks
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        list.removeAllTasks();
        assertEquals("", list.listAllTasks());
    }

    @Test
    public void testChangeTaskDate() {
        list.addTaskAtTop(task1);
        list.changeTaskDate(0, newDate);
        assertEquals("Task date should be changed to newDate", newDate, task1.getDate());
    }

    @Test
    public void testCountTasks() {
        // Test counting tasks, completed tasks, and tasks by priority
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        list.addTaskByPriority(task3);
        assertEquals(3, list.countAllTasks());
        assertEquals(1, list.countCompletedTasks());
        assertEquals(1, list.countTasksByPriority(Priority.HIGH));
    }

    @Test
    public void testRemoveCompletedTasks() {
        // Test removing completed tasks
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        list.removeCompletedTasks();
        assertEquals("ID: 1 - Date: 2023/3/10 09:30 - Description: Task 1 Description - Priority: LOW - Completed: No", list.listAllTasks());
    }

    @Test
    public void testListTasksByPriority() {
        list.addTaskAtTop(task1); // LOW
        list.addTaskAtTop(task2); // HIGH
        list.addTaskAtTop(task3); // MEDIUM
        String mediumPriorityTasks = list.listTasksByPriority(Priority.MEDIUM);
        assertTrue("List should contain task3 when listing MEDIUM priority tasks", mediumPriorityTasks.contains("Task 3 Description"));
        assertFalse("List should not contain task1 or task2 when listing MEDIUM priority tasks", mediumPriorityTasks.contains("Task 1 Description") || mediumPriorityTasks.contains("Task 2 Description"));
    }

    @Test
    public void testListExpiredTasks() {
        // Test listing expired tasks based on a current date
        Date currentDate = new Date(2023, 3, 15, 0, 0);
        list.addTaskAtTop(task1); // This task should be expired based on currentDate
        list.addTaskAtBottom(task2);
        assertEquals("ID: 1 - Date: 2023/3/10 09:30 - Description: Task 1 Description - Priority: LOW - Completed: No", list.listExpiredTasks(currentDate));
    }

    @Test
    public void testGetTaskByID() {
        // Test retrieving a task by its ID
        list.addTaskAtTop(task1);
        list.addTaskAtBottom(task2);
        assertEquals(task1, list.getTaskByID(1));
        assertNull(list.getTaskByID(999)); // Test for a non-existing ID
    }
}

