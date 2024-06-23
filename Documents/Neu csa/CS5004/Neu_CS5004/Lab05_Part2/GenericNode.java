/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This class represents a generic node used in a linked list, capable of holding data of any type.
 */

import java.util.function.Predicate;

/**
 * A generic node in a linked list, holding data of type T.
 */
public class GenericNode<T> implements Node<T> {
    private T data; // The data stored within this node.
    private Node<T> next; // Reference to the next node in the list.

    /**
     * Constructs a new GenericNode with the specified data and next node.
     *
     * @param data The data to store in this node.
     * @param next The next node in the linked list.
     */
    public GenericNode(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return The data of this node.
     */
    @Override
    public T getData() {
        return data;
    }

    /**
     * Returns the next node in the list.
     *
     * @return The next node.
     */
    @Override
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next The node to set as the next node.
     */
    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Counts the number of nodes that satisfy a specific predicate.
     *
     * @param predicate the condition to evaluate each node
     * @return the count of nodes satisfying the predicate
     */
    @Override
    public int countIf(Predicate<T> predicate) {
        int count = predicate.test(data) ? 1 : 0; // Count this node if it satisfies the predicate
        return count + next.countIf(predicate); // Recursively count in the next node
    }

    /**
     * Filters the list based on a given predicate.
     *
     * @param predicate The condition to evaluate each node
     * @return The head of the modified list after filtering.
     */
    @Override
    public Node<T> filter(Predicate<T> predicate) {
        // Recursively filter the remaining list
        Node<T> filteredNext = next.filter(predicate);

        // If this node satisfies the predicate, include it in the new list
        if (predicate.test(data)) {
            return new GenericNode<>(data, filteredNext);
        } else {
            // Otherwise, skip this node and proceed with the filtered next nodes
            return filteredNext;
        }
    }

    /**
     * Retrieves the node at the specified index.
     *
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     */
    @Override
    public Node<T> getNodeAtIndex(int index) {
        if (index == 0) {
            return this;
        } else {
            return next.getNodeAtIndex(index - 1);
        }
    }


    /**
     * Returns a string representation of the node.
     *
     * @return A string representation of this node's data.
     */
    @Override
    public String toString() {
        // Check if the next node is the end of the list (EmptyNode)
        // and avoid adding a newline character for the last element.
        return data.toString() + (next instanceof EmptyNode ? "" : "\n" + next.toString());
    }

    /**
     * Generates a string representation of the list based on a predicate.
     *
     * @param predicate The predicate to determine which nodes to include in the string.
     * @return A string representation of the list filtered by the predicate.
     */
    @Override
    public String toString(Predicate<T> predicate) {
        // Check if the current node's data satisfies the predicate
        if (predicate.test(data)) {
            // If yes, include this node's data in the string
            // and check if the next node is an EmptyNode to avoid appending an unnecessary newline
            return data.toString() + (next instanceof EmptyNode ? "" : "\n" + next.toString(predicate));
        } else {
            // If the current node's data doesn't satisfy the predicate,
            // move to the next node and repeat the process
            return next instanceof EmptyNode ? "" : next.toString(predicate);
        }
    }
}
