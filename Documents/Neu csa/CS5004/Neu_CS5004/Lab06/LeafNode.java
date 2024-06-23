import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a leaf node in a tree, which has no children.
 * It is used to represent employees without supervisory responsibilities.
 */
public class LeafNode<T> extends AbstractTreeNode<T> {

    /**
     * Constructs a LeafNode with the given data.
     *
     * @param data The data to store in the node.
     */
    public LeafNode(T data) {
        super(data);
    }

    /**
     * Attempts to add a child to this node. Converts to a GroupNode if necessary.
     *
     * @param identifier Predicate to identify the parent node.
     * @param child The child node to add.
     * @return The current node or a new GroupNode with the child added.
     */
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
        // Since it's a leaf node, it cannot have children. However, if this leaf should be the parent,
        // according to the identifier, it needs to transform into a group node and add the child.
        if (identifier.test(this.data)) {
            // Transform this leaf node into a group node.
            GroupNode<T> newParentNode = new GroupNode<>(this.data);
            newParentNode.children.add(child);
            return newParentNode;
        } else {
            // If this leaf shouldn't be the parent, just return it unchanged.
            return this;
        }
    }

    /**
     * Converts this node to a single-item list.
     *
     * @return List containing only this node's data.
     */
    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<T>();
        result.add(this.data);
        return result;
    }

    /**
     * Transforms the data in this node using the given function.
     *
     * @param transform Function to apply to the node's data.
     * @param <R> The type of the transformed data.
     * @return A new LeafNode containing the transformed data.
     */
    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        return new LeafNode<R>(transform.apply(this.data));
    }

    /**
     * Reduces this node's data with the given initial value using the provided combiner.
     *
     * @param initialValue The initial value for the reduction.
     * @param combiner Function to combine the initial value and the node's data.
     * @return The result of applying the combiner.
     */
    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        return combiner.apply(initialValue, this.data);
    }

    /**
     * Prints this node's data to the standard output.
     */
    @Override
    public void print() {
        System.out.println(this.data);
    }
}

