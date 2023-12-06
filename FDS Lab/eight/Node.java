/**
 * A class to represent a node in the positional list.
 *
 * @param <E> the type of the element stored in the node.
 */
class Node<E> {

    private E element; // the element stored in the node
    private Node<E> prev; // the previous node in the list
    private Node<E> next; // the next node in the list

    /**
     * Constructs a new node with the given element and links.
     *
     * @param element the element to be stored in the node.
     * @param prev    the previous node in the list.
     * @param next    the next node in the list.
     */
    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Gets the element stored in the node.
     *
     * @return the element stored in the node.
     */
    public E getElement() {
        return element;
    }

    /**
     * Gets the previous node in the list.
     *
     * @return the previous node in the list.
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Gets the next node in the list.
     *
     * @return the next node in the list.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the element of the node.
     *
     * @param element the new element to be stored in the node.
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the new previous node in the list.
     */
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the new next node in the list.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}