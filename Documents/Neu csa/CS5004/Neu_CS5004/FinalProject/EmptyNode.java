import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents an empty node (sentinel or end marker) in a generic linked list.
 */

public class EmptyNode<T> implements Node<T> {

    /**
     * Returns the data stored in the node, which is null for an empty node.
     * @return null as EmptyNode does not store data.
     */
    @Override
    public T getData() {
        return null;
    }

    /**
     * Returns the next node in the list, which is null for an empty node.
     * @return null as EmptyNode does not have a next node.
     */
    @Override
    public Node<T> getNext() {
        return null;
    }

    /**
     * Sets the next node in the list. This method does nothing for an empty node.
     * @param next The next node to be set.
     */
    @Override
    public void setNext(Node<T> next) {
        // No operation performed as this is an empty node.
    }

    /**
     * Counts elements based on a condition. Always returns 0 for an empty node.
     * @param predicate The condition to evaluate each node.
     * @return 0 as there are no elements to count in an empty node.
     */
    @Override
    public int countIf(Predicate<T> predicate) {
        return 0;
    }

    /**
     * Filters the list based on a given condition. Returns itself as there is nothing to filter in an empty node.
     * @param predicate The condition to evaluate each node.
     * @return this empty node, signifying the end of a filtered sequence.
     */
    @Override
    public Node<T> filter(Predicate<T> predicate) {
        return this;
    }

    @Override
    public <R> Node<R> map(Function<T,R> converter) {return new EmptyNode<>();}

    @Override
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {return initialValue;}

    @Override
    public boolean updateIf(Predicate<T> condition, Function<T, T> updater) {
        return false; // No updates possible in an empty node.
    }


    /**
     * Retrieves the node at the specified index. Throws an exception as an empty node does not have any next elements.
     * @param index The index of the node to retrieve.
     * @return Never returns normally as this method always throws an exception.
     */
    @Override
    public Node<T> getNodeAtIndex(int index) {
        return null;
    }

    /**
     * Provides a string representation of the node. Always returns a descriptive string for an empty node.
     * @return A string "EmptyNode" indicating this is an empty node.
     */
    @Override
    public String toString() {
        return "EmptyNode";
    }

    /**
     * Generates a string representation based on a predicate. Always returns an empty string for an empty node.
     * @param predicate The predicate to determine which nodes to include in the string.
     * @return An empty string as there is no data to represent in an empty node.
     */
    @Override
    public String toString(Predicate<T> predicate) {
        return ""; // Empty nodes do not contain data to list.
    }
}


