/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * Manages a linked list of tasks, supporting operations to add, remove, update, and query tasks.
 * Tasks can be manipulated based on their position, priority, completion status, or due date,
 */
public class TaskLinkedList {
    private Node head; // Head of the list

    /**
     * Constructs an initially empty TaskLinkedList.
     */
    public TaskLinkedList() {
        this.head = new EmptyNode(); // Initialize with a sentinel node.
    }

    /*
    Loop Part
     */
    /**
     * Adds a task to the bottom of the to-do list.
     * Traverses the list to find the last task node and insert the new task before the EmptyNode.
     * @param task The task to be added.
     */
    public void addTaskAtBottom(Task task) {
        Node current = head;
        // Traverse the list to find the last task node.
        while (!(current.getNext() instanceof EmptyNode)) {
            current = current.getNext();
        }
        // Insert the new task node before the EmptyNode.
        current.setNext(new TaskNode(task, new EmptyNode()));
    }

    /**
     * Adds a task to the top of the to-do list.
     * Inserts the new task node at the beginning of the list, making it the new head of the list.
     * @param task The task to be added.
     */
    public void addTaskAtTop(Task task) {
        head = new TaskNode(task, head);
    }

    /**
     * Adds a task to the list according to its priority. Higher priority tasks
     * are inserted closer to the list head, ensuring they are processed before
     * lower priority tasks. The list is never empty as it contains an EmptyNode
     * at the end to signify the end of the list.
     * @param newTask The task to be added.
     */
    public void addTaskByPriority(Task newTask) {
        // If the list is effectively empty (head is an EmptyNode) or the new task has a higher priority than the first actual task,
        // insert this new task at the beginning.
        if (head instanceof EmptyNode || newTask.getPriority().compareTo(head.getTask().getPriority()) > 0) {
            head = new TaskNode(newTask, head);
            return;
        }

        // Start from the head of the list to find the correct spot for the new task.
        Node current = head;
        while (!(current.getNext() instanceof EmptyNode) &&
                newTask.getPriority().compareTo(current.getNext().getTask().getPriority()) <= 0) {
            // Move forward in the list until we find where the new task fits.
            current = current.getNext();
        }

        // Insert the new task right before the next node. This could be before an EmptyNode
        // if we've reached the end of our actual tasks, or before a lower priority task.
        Node newTaskNode = new TaskNode(newTask, current.getNext());
        current.setNext(newTaskNode);
    }


    /**
     * Removes a task at a specific index from the to-do list.
     * Adjusts pointers to bypass the removed node.
     * @param index The index of the task to remove.
     */
    public void removeTaskAtIndex(int index) {
        // invalid negative index
        if (index < 0) {
            // Index is invalid, do nothing.
            return;
        }
        // Special case: removing the first task
        if (index == 0 && !(head instanceof EmptyNode)) {
            // Remove the first task.
            head = head.getNext();
            return;
        }
        // Normal case
        // Find the node just before the one we want to remove
        Node current = head;
        for (int i = 0; current.getNext() instanceof TaskNode && i < index - 1; i++) {
            current = current.getNext();
        }
        // If current.getNext is not the EmptyNode, remove it by adjusting pointers.
        if (!(current.getNext() instanceof EmptyNode)) {
            // Bypass the node to be removed.
            current.setNext(current.getNext().getNext());
        }
    }

    /**
     * Removes all tasks from the to-do list, resetting it to only contain the sentinel node.
     */
    public void removeAllTasks() {
        head = new EmptyNode(); // Reset the list to only have the sentinel node.
    }

    /*
    Recursion Part
     */

    /**
     * Changes the date of the task at the specified index.
     * @param index The index of the task to change.
     * @param newDate The new date for the task.
     */
    public void changeTaskDate(int index, Date newDate) {
        head.changeTaskDate(index, newDate);
    }

    /**
     * Counts all tasks in the list.
     * @return The total number of tasks in the list.
     */
    public int countAllTasks() {
        // Call the recursive method from the head node.
        return head.countAllTasks();
    }

    /**
     * Counts all completed tasks in the list.
     * @return The total number of completed tasks in the list.
     */
    public int countCompletedTasks() {
        // Call the recursive method from the head node.
        return head.countCompletedTasks();
    }

    /**
     * Counts tasks with a specific priority in the list.
     * @param priority The priority to count.
     * @return The total number of tasks with the specified priority in the list.
     */
    public int countTasksByPriority(Priority priority) {
        // Call the recursive method from the head node.
        return head.countTasksByPriority(priority);
    }

    /**
     * Removes all completed tasks from the list.
     */
    public void removeCompletedTasks() {
        // Call the recursive method from the head node and update the head reference if necessary.
        head = head.removeCompletedTasks();
    }

    /**
     * Removes tasks with a specific priority from the list.
     * @param priority The priority of tasks to remove.
     */
    public void removeTasksByPriority(Priority priority) {
        // Call the recursive method from the head node and update the head reference if necessary.
        head = head.removeTasksByPriority(priority);
    }

    /**
     * Lists all tasks in the list.
     * @return A string representation of all tasks in the list.
     */
    public String listAllTasks() {
        // Call the recursive method from the head node.
        return head.listAllTasks();
    }

    /**
     * Lists tasks with a specific priority in the list.
     * @param priority The priority of tasks to list.
     * @return A string representation of tasks with the specified priority in the list.
     */
    public String listTasksByPriority(Priority priority) {
        // Call the recursive method from the head node.
        return head.listTasksByPriority(priority);
    }

    /**
     * Lists expired tasks based on the current date.
     * @param currentDate The current date.
     * @return A string representation of expired tasks in the list.
     */
    public String listExpiredTasks(Date currentDate) {
        // Call the recursive method fromm the head node.
        return head.listExpiredTasks(currentDate);
    }

    /**
     * Initiates a recursive search for a task with the specified ID in the list.
     * @param taskID The ID of the task to find.
     * @return The task with the specified ID if found; otherwise, null.
     */
    public Task getTaskByID(int taskID) {
        // Start the recursive search from the head node.
        return head.getTaskByID(taskID);
    }
}
