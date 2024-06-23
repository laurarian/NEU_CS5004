import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * Tests for the TaskNode class. These tests verify task manipulation within TaskNodes.
 */

public class TestTaskNode {

    private TaskNode node1;
    private TaskNode node2;
    private EmptyNode emptyNode;
    private Date earlyDate;
    private Date laterDate;

    @Before
    public void setUp() {
        // Initialize some dates for testing
        earlyDate = new Date(2023, 3, 15, 14, 30); // Earlier date
        laterDate = new Date(2023, 3, 16, 16, 45); // Later date

        // Initialize tasks with different properties
        Task task1 = new Task(1, "Task 1", earlyDate, false, Priority.MEDIUM);
        Task task2 = new Task(2, "Task 2", laterDate, true, Priority.HIGH);

        // Initialize nodes
        emptyNode = new EmptyNode();
        node1 = new TaskNode(task1, emptyNode); // Node with task1 and pointing to an EmptyNode
        node2 = new TaskNode(task2, node1); // Node with task2 and pointing to node1
    }

    @Test
    public void testGetTask() {
        // Validate the correct task is returned
        assertEquals("Task 1", node1.getTask().getDescription());
        assertEquals("Task 2", node2.getTask().getDescription());
    }

    @Test
    public void testGetNext() {
        // Validate the correct next node is returned
        assertEquals(emptyNode, node1.getNext());
        assertEquals(node1, node2.getNext());
    }

    @Test
    public void testSetNext() {
        // Change next of node1 and validate
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void testToString() {
        // Validate toString output
        String expected = "TaskNode{task=" + node1.getTask() + ", next=EmptyNode}";
        assertEquals(expected, node1.toString());
    }

    @Test
    public void testChangeTaskDate() {
        // Change the date of node1's task and validate
        Date newDate = new Date(2023, 4, 1, 12, 0);
        node1.changeTaskDate(0, newDate); // Index 0 refers to node1's task
        assertEquals(newDate, node1.getTask().getDate());
    }

    @Test
    public void testCountAllTasks() {
        // Count tasks including node2 and node1
        assertEquals(2, node2.countAllTasks());
    }

    @Test
    public void testCountCompletedTasks() {
        // Only node2's task is completed
        assertEquals(1, node2.countCompletedTasks());
    }

    @Test
    public void testCountTasksByPriority() {
        // Both tasks have different priorities
        assertEquals(1, node2.countTasksByPriority(Priority.HIGH));
        assertEquals(1, node2.countTasksByPriority(Priority.MEDIUM));
    }

    @Test
    public void testRemoveCompletedTasks() {
        // After removing completed tasks, only node1 should remain
        Node resultNode = node2.removeCompletedTasks();
        assertFalse(resultNode.getTask().getCompleted());
    }

    @Test
    public void testRemoveTasksByPriority() {
        // Remove HIGH priority tasks, only node1 (MEDIUM priority) should remain
        Node resultNode = node2.removeTasksByPriority(Priority.HIGH);
        assertEquals(Priority.MEDIUM, resultNode.getTask().getPriority());
    }

    @Test
    public void testListAllTasks() {
        // List all tasks starting from node2
        String expected = node2.getTask().toString() + "\n" + node1.getTask().toString();
        assertEquals(expected, node2.listAllTasks());
    }

    @Test
    public void testListTasksByPriority() {
        // List tasks by priority, starting from node2
        assertEquals(node2.getTask().toString(), node2.listTasksByPriority(Priority.HIGH));
        assertEquals(node1.getTask().toString(), node2.listTasksByPriority(Priority.MEDIUM));
    }

    @Test
    public void testListExpiredTasks() {
        // Assuming current date is before both task dates, no tasks should be expired
        Date currentDate = new Date(2023, 1, 1, 0, 0);
        assertEquals("", node2.listExpiredTasks(currentDate));

        // Change node1's task date to be before current date and test again
        node1.getTask().setDate(new Date(2022, 12, 31, 23, 59));
        assertEquals(node1.getTask().toString(), node2.listExpiredTasks(currentDate));
    }

    @Test
    public void testGetTaskByID() {
        // Test finding tasks by ID
        assertEquals(node1.getTask(), node2.getTaskByID(1));
        assertEquals(node2.getTask(), node2.getTaskByID(2));
        assertNull(node2.getTaskByID(3)); // ID 3 does not exist
    }
}


