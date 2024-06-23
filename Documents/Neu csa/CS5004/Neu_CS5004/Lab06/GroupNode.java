import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * This class represents a group node in a tree structure, which can have child nodes.
 * It is analogous to a supervisor in an organization that manages other employees (children nodes).
 */
public class GroupNode<T> extends AbstractTreeNode<T> {
    protected List<TreeNode<T>> children;

    /**
     * Constructs a GroupNode with the specified data.
     *
     * @param data The data stored at this node, representing the supervisor's details.
     */
    public GroupNode(T data) {
        super(data);
        this.children = new LinkedList<TreeNode<T>>();
    }

    /**
     * Adds a child node if it matches a specific condition.
     *
     * @param identifier Condition to identify where to add the child.
     * @param child The child node to be added.
     * @return The node after adding the child.
     */
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
        if (identifier.test(this.data)) {
            this.children.add(child); //add it here and return
            return this;
        }
        for (int i = 0; i < this.children.size(); i++) {
            //add to child and mutate the child
            this.children.set(
                    i,
                    this.children.get(i).addChild(identifier, child));
        }
        return this;
    }

    /**
     * Converts the hierarchy starting from this node into a list.
     *
     * @return A list representation of the hierarchy.
     */
    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<T>();
        result.add(this.data);
        for (TreeNode<T> child : children) {
            result.addAll(child.toList());
        }
        return result;
    }

    /**
     * Transforms the tree structure starting from this node into another tree.
     *
     * @param transform Transformation function.
     * @param <R> The type of data in the resulting tree.
     * @return Root of the transformed tree.
     */
    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        GroupNode<R> newNode = new GroupNode<R>(transform.apply(this.data));
        for (TreeNode<T> child : children) {
            newNode.children.add(child.map(transform));
        }
        return newNode;
    }

    /**
     * Reduces the tree to a single value starting from this node.
     *
     * @param initialValue Initial value for the reduction.
     * @param combiner Combines two values.
     * @return The result of the reduction.
     */
    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        T result = this.data;
        for (TreeNode<T> child : children) {
            result = child.reduce(result, combiner);
        }
        //at this point result is the combination of this.data and reductions of its children
        return combiner.apply(initialValue, result); //combine result and initialValue and return
    }

    /**
     * Prints the data of this node and recursively prints the data of all child nodes.
     */
    @Override
    public void print() {
        super.print();
        for (TreeNode<T> child : children) {
            child.print();
        }
    }
}
