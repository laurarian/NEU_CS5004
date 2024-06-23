/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This class represents a generic linked list supporting various operations like add, remove, and search.
 */
import java.util.function.Predicate;

/**
 * A generic linked list supporting various operations.
 */
public class LinkedList<T> {
    private Node<T> head; // Head of the list

    /**
     * Constructs an initially empty LinkedList.
     */
    public LinkedList() {
        this.head = new EmptyNode<>(); // Initialize with a sentinel node.
    }

    /*
    Loop Part
     */

    /**
     * Adds a generic node at the top of the list.
     * @param data The data to be added.
     */
    public void addAtTop(T data) {
        this.head = new GenericNode<>(data, this.head);
    }


    /**
     * Adds a generic node at the bottom of the list.
     * @param data The data to be added.
     */
    public void addAtBottom(T data) {
        if (this.head instanceof EmptyNode) {
            this.head = new GenericNode<>(data, new EmptyNode<>());
        } else {
            // Traverse the list to find the last task node.
            Node<T> current = this.head;
            while (!(current.getNext() instanceof EmptyNode)) {
                current = current.getNext();
            }
            // Insert the new task node before the EmptyNode.
            current.setNext(new GenericNode<>(data, new EmptyNode<>()));
        }
    }

    /**
     * Removes a generic node at a specific index from the to-do list.
     * Adjusts pointers to bypass the removed node.
     * @param index The index of the task to remove.
     */
    public void removeAtIndex(int index) {
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
        for (int i = 0; current.getNext() instanceof GenericNode && i < index - 1; i++) {
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
     * Counts elements in the list based on a condition.
     * @param predicate The condition to count elements.
     * @return The count of elements that match the condition.
     */
    public int countIf(Predicate<T> predicate) {
        return head.countIf(predicate);
    }

    /**
     * Filters elements in the list based on a condition.
     * @param predicate The condition to filter elements.
     * @return A new list of filtered elements.
     */
    public Node<T> filter(Predicate<T> predicate) {
        return head.filter(predicate);
    }


    /**
     * Gets the element at a specific index.
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public Node<T> getNodeAtIndex(int index) {
        return head.getNodeAtIndex(index);
    }

    /**
     * Returns a string representation of the list.
     * @return The string representation of the list.
     */
    @Override
    public String toString() {
        return head.toString();
    }

    /**
     * Returns a string representation of the list based on a condition.
     * @param predicate The condition to filter elements for the string representation.
     * @return The string representation of the filtered list.
     */
    public String toString(Predicate<T> predicate) {
        return head.toString(predicate);
    }
}
