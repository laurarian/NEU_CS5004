/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This interface defines the structure and behaviors of a node in a generic linked list.
 */

import java.util.function.Predicate;

/**
 * Represents a generic node in a linked list.
 * This interface defines basic operations such as getting data, setting the next node,
 * counting elements based on a condition, filtering elements, and generating string representations.
 *
 * @param <T> The type of data the node stores.
 */
public interface Node<T> {

    /**
     * Retrieves the data stored in this node.
     *
     * @return The data stored in the node.
     */
    T getData();

    /**
     * Retrieves the next node in the linked list.
     *
     * @return The next node.
     */
    Node<T> getNext();

    /**
     * Sets the next node in the linked list.
     *
     * @param next The node to set as the next node.
     */
    void setNext(Node<T> next);

    /**
     * Counts the number of elements in the list that satisfy a given condition.
     *
     * @param predicate The condition to evaluate each element.
     * @return The count of elements that satisfy the condition.
     */
    int countIf(Predicate<T> predicate);

    /**
     * Filters elements in the list based on a given condition.
     *
     * @param predicate The condition to evaluate each element.
     * @return The head node of the filtered list.
     */
    Node<T> filter(Predicate<T> predicate);

    /**
     * Retrieves the node at the specified index.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     */
    Node<T> getNodeAtIndex(int index);

    /**
     * Generates a string representation of this node.
     *
     * @return A string representation of the node.
     */
    String toString();

    /**
     * Generates a string representation of the list based on a given condition.
     *
     * @param predicate The condition to determine which nodes to include in the string.
     * @return A string representation of the list filtered by the condition.
     */
    String toString(Predicate<T> predicate);
}

