import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a generic linked list providing basic list operations.
 */
public class LinkedList<T> {
    private Node<T> head; // Head of the list

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    /**
     * Constructs an initially empty LinkedList.
     */
    public LinkedList() {
        this.head = new EmptyNode<>(); // Initialize with a sentinel node.
    }


    // ============================ Loop Part============================

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
        Node<T> current = head;
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
     * Finds the index of the first node in the list that matches the given condition.
     * @param condition The condition to evaluate each node.
     * @return The index of the first matching node, or -1 if no match is found.
     */
    public int findIndex(Predicate<T> condition) {
        Node<T> current = head;
        int index = 0;
        while (current instanceof GenericNode) {
            if (condition.test(current.getData())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1; // No matching node found
    }


    /**
     * Removes the first element that satisfies the given predicate.
     * @param condition The predicate to determine which element to remove.
     * @return true if an element was removed, false otherwise.
     */
    public boolean removeIf(Predicate<T> condition) {
        if (head instanceof EmptyNode) {
            return false; // No elements to remove
        }
        // Handle removal of the head node separately
        if (condition.test(head.getData())) {
            head = head.getNext();
            return true;
        }
        // General case: remove non-head node
        Node<T> current = head;
        while (current.getNext() instanceof GenericNode) {
            if (condition.test(current.getNext().getData())) {
                current.setNext(current.getNext().getNext());
                return true; // Element removed
            }
            current = current.getNext();
        }
        return false; // No element found to remove
    }

    // ============================ Recursion Part ============================

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
    public LinkedList<T> filter(Predicate<T> predicate) {
        LinkedList<T> newList = new LinkedList<>(head.filter(predicate));
        return newList;
    }

    /**
     * Transforms the list elements into another form as specified by the function.
     * @param converter The function to transform list elements.
     * @return A new LinkedList containing transformed elements.
     */
    public <R> LinkedList<R> map(Function<T,R> converter) {
        LinkedList<R> newList = new LinkedList<>(head.map(converter));
        return newList;
    }

    /**
     * Reduces the list elements into a single value using a combination function.
     * @param initialValue The initial value to start the reduction.
     * @param combiner The function to combine two elements.
     * @return The reduced value.
     */
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        return head.reduce(initialValue, combiner);
    }


    /**
     * Updates elements in the list based on a condition.
     * @param condition A predicate to test each element.
     * @param updater A function that applies updates to the elements if the condition is true.
     * @return true if at least one element was updated, otherwise false.
     */
    public boolean updateIf(Predicate<T> condition, Function<T, T> updater) {
        return head.updateIf(condition, updater);
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
