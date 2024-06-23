/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * This interface defines the basic structure and functionality of a node in a linked list.
 */
public interface Node {
    public Task getTask();  // Returns the task stored in the node.
    public Node getNext();  // Returns the next node in the list.
    public void setNext(Node next);  // Sets the next node in the list.

    public String toString();  // Returns a string representation of the node.

    // Methods for recursion
    void changeTaskDate(int index, Date newDate);
    int countAllTasks();
    int countCompletedTasks();
    int countTasksByPriority(Priority priority);
    Node removeCompletedTasks();
    Node removeTasksByPriority(Priority priority);
    String listAllTasks();
    String listTasksByPriority(Priority priority);
    String listExpiredTasks(Date currentDate);
    Task getTaskByID(int taskID);
}

