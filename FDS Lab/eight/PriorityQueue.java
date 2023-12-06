import java.util.*;

/**
 * A class to represent a priority queue using a positional list.
 *
 * @param <K> the type of keys in the priority queue.
 * @param <V> the type of values associated with the keys.
 */
class PriorityQueue<K, V> {

    private Node<Entry<K, V>> head; // the head node of the list
    private Node<Entry<K, V>> tail; // the tail node of the list
    private int size; // the size of the list
    private Comparator<K> comp; // the comparator to compare keys

    /**
     * Constructs an empty priority queue with the specified comparator.
     *
     * @param comp the comparator to compare keys.
     */
    public PriorityQueue(Comparator<K> comp) {
        head = new Node<>(null, null, null); // create a dummy head node
        tail = new Node<>(null, head, null); // create a dummy tail node
        head.setNext(tail); // link the head and tail nodes
        size = 0; // set the size to zero
        this.comp = comp; // set the comparator
    }

    /**
     * Compares two keys using the comparator.
     *
     * @param a the first key.
     * @param b the second key.
     * @return a negative integer, zero, or a positive integer as the first key is less than, equal to,
     *         or greater than the second key.
     */
    private int compare(K a, K b) {
        return comp.compare(a, b);
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the priority queue.
     *
     * @return the size of the priority queue.
     */
    public int size() {
        return size;
    }

    /**
     * Inserts a new entry with the given key and value into the priority queue.
     *
     * @param key   the key of the entry.
     * @param value the value associated with the key.
     */
    public void insert(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value); // create a new entry
        Node<Entry<K, V>> node = new Node<>(entry, null, null); // create a new node
        Node<Entry<K, V>> curr = head.getNext(); // start from the first node after the head
        while (curr != tail && compare(key, curr.getElement().getKey()) > 0) {
            // loop until the end of the list or find a node with a smaller or equal key
            curr = curr.getNext(); // move to the next node
        }
        // insert the new node before the current node
        node.setPrev(curr.getPrev()); // link the new node with the previous node of the current node
        node.setNext(curr); // link the new node with the current node
        curr.getPrev().setNext(node); // link the previous node of the current node with the new node
        curr.setPrev(node); // link the current node with the new node
        size++; // increment the size
    }

    /**
     * Returns (but does not remove) the entry with the minimum key.
     *
     * @return the entry with the minimum key, or null if the priority queue is empty.
     */
    public Entry<K, V> min() {
        if (isEmpty()) return null; // if the priority queue is empty, return null
        return head.getNext().getElement(); // otherwise, return the element of the first node after the head
    }

    /**
     * Removes and returns the entry with the minimum key.
     *
     * @return the entry with the minimum key, or null if the priority queue is empty.
     */
    public Entry<K, V> removeMin() {
        if (isEmpty()) return null; // if the priority queue is empty, return null
        Node<Entry<K, V>> node = head.getNext(); // get the first node after the head
        Entry<K, V> entry = node.getElement(); // get the element of the node
        // remove the node from the list
        node.getPrev().setNext(node.getNext()); // link the previous node of the node with the next node of the node
        node.getNext().setPrev(node.getPrev()); // link the next node of the node with the previous node of the node
        node.setElement(null); // nullify the element of the node
        node.setPrev(null); // nullify the previous link of the node
        node.setNext(null); // nullify the next link of the node
        size--; // decrement the size
        return entry; // return the removed entry
    }
}