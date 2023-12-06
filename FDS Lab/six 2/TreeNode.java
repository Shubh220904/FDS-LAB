import java.util.*;
/**
 * Represents a node in a positional tree.
 *
 * @param <E> the type of element held by the node
 */
class TreeNode<E> implements PositionalTree<E> {
    private E element;
    private TreeNode<E> parent;
    private List<TreeNode<E>> children;

    /**
     * Constructs a new tree node with the specified element and parent node.
     *
     * @param element the element to be held by the node
     * @param parent the parent node of the current node
     */
    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    /**
     * Gets the element held by the node.
     *
     * @return the element held by the node
     */
    public E getElement() {
        return element;
    }

    /**
     * Gets the parent node of the current node.
     *
     * @return the parent node of the current node
     */
    public TreeNode<E> getParent() {
        return parent;
    }

    /**
     * Gets the list of children nodes of the current node.
     *
     * @return the list of children nodes
     */
    public List<TreeNode<E>> getChildren() {
        return children;
    }

    // Additional methods and documentation can be added here

    // ...
}