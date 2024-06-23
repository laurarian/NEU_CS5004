import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * This interface represents the generic structure and operations for a tree node.
 */
public interface TreeNode<T> {

    /**
     * Add the given node as a child to a node in this tree
     * identified by the predicate. If no node is identified by the predicate the tree
     * remains unchanged.
     *
     * @param identifier a predicate that is used to
     *                   identify the node.
     * @param child      the node that must be added as a child
     * @return the resulting hierarchy starting at this node
     */
    TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);


    /**
     * Convert the tree into a list.
     *
     * @return the resulting list
     */
    List<T> toList();

    /**
     * A map higher-order function on this tree. Produces a tree with identical
     * structure but whose data is of the specified return type
     *
     * @param transform the function that maps from the
     *                  data in this tree to the data in the resulting tree
     * @param <R>       the type of the resulting data
     * @return the root of the corresponding mapped tree
     */
    <R> TreeNode<R> map(Function<T, R> transform);

    /**
     * A reduce higher-order function on this tree. Produces a single value of
     * type T
     *
     * @param initialValue the initial value of the accumulator of the reduce
     * @param combiner     a function that takes two values of type T and combines
     *                     them into a single value of type T
     * @return the result of the reduce, as an object of type T
     */
    T reduce(T initialValue, BiFunction<T, T, T> combiner);

    /**
     * Prints the tree structure, starting from this node, in a structured format.
     */
    void print();
}
