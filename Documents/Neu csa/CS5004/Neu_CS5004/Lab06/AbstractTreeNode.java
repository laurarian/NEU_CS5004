import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * This abstract class provides a skeletal implementation of the TreeNode interface
 * to minimize the effort required to implement tree nodes.
 */
public abstract class AbstractTreeNode<T> implements TreeNode<T> {
    protected T data; // Node's data

    /**
     * Constructs a node with the specified data.
     *
     * @param data The data to be stored in this node.
     */
    public AbstractTreeNode(T data) {
        this.data = data;
    }

    /**
     * Adds a child to the node that matches the given identifier.
     *
     * @param identifier the condition to find the matching node
     * @param child      the child node to add
     * @return the updated node
     */
    @Override
    public abstract TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);

    /**
     * Converts the subtree rooted at this node into a list.
     *
     * @return a list representation of the subtree
     */
    @Override
    public abstract List<T> toList();

    /**
     * Transforms the subtree rooted at this node into another subtree with potentially different node types.
     *
     * @param <R>       the type of the nodes in the resulting tree
     * @param transform the function to transform node data
     * @return the root of the resulting subtree
     */
    @Override
    public abstract <R> TreeNode<R> map(Function<T, R> transform);

    /**
     * Reduces the subtree rooted at this node to a single value.
     *
     * @param initialValue the initial value for the reduction
     * @param combiner     the function to combine two nodes' data
     * @return the result of the reduction
     */
    @Override
    public abstract T reduce(T initialValue, BiFunction<T, T, T> combiner);

    /**
     * Prints the data of this node.
     */
    @Override
    public void print() {
        System.out.println(this.data.toString());
    }
}

