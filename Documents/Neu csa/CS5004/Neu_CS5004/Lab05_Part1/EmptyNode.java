/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * This class represents an empty node used as the end of the linked list.
 * It implements the Node interface and contains no task, signifying the end of the list.
 */
public class EmptyNode implements Node {

    // Method to return the next node in the list, which is null for an empty node.
    @Override
    public Node getNext() {
        return null;
    }

    // Method to return the task stored in the node, which is null for an empty node.
    @Override
    public Task getTask() {
        return null;
    }


    // Method to setNext,Empty node cannot have a next node, so this method does nothing.
    @Override
    public void setNext(Node next) {
    }

    // toString Method
    @Override
    public String toString() {
        return "EmptyNode";
    }

    // override recursive part method in interface
    @Override
    public void changeTaskDate(int index, Date newDate) {
        // Do nothing
    }

    @Override
    // Returns 0 as there are no tasks in an empty node.
    public int countAllTasks() {
        return 0;
    }

    // Returns 0 as an empty node cannot have completed tasks.
    @Override
    public int countCompletedTasks() {
        return 0;
    }

    // Returns 0 as an empty node does not contain any tasks of any priority.
    @Override
    public int countTasksByPriority(Priority priority) {
        return 0;
    }

    @Override
    public Node removeCompletedTasks() {
        return this;
    }

    @Override
    public Node removeTasksByPriority(Priority priority) {
        return this;
    }

    @Override
    public String listAllTasks() {
        return "";
    }

    @Override
    public String listTasksByPriority(Priority priority) {
        return "";
    }

    @Override
    public String listExpiredTasks(Date currentDate) {
        return "";
    }

    @Override
    public Task getTaskByID(int taskID) {
        return null; // No task found, return null.
    }
}

