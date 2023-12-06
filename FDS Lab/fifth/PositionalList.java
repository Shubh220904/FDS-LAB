import java.util.*;

/** A class to represent a node of a linked list */ 
class Node<E> {
  private E element; /** reference to the element stored at this node */ 
  private Node<E> prev; /** reference to the previous node in the list */
  private Node<E> next; /** reference to the subsequent node in the list*/

  /**
   * Constructor
   * @param e element 
   * @param p prev pointer
   * @param n next pointer
   */
  public Node(E e, Node<E> p, Node<E> n) {
    element = e;
    prev = p;
    next = n;
  }

  /** Accessor methods*/
  public E getElement() {
    return element;
  }

  public Node<E> getPrev() {
    return prev;
  }

  public Node<E> getNext() {
    return next;
  }

  /** Modifier methods */ 
  public void setElement(E e) {
    element = e;
  }

  public void setPrev(Node<E> p) {
    prev = p;
  }

  public void setNext(Node<E> n) {
    next = n;
  }
}

/** A class to represent a position of a linked list */
class Position<E> {
    private Node<E> node; /** reference to the node at this position */ 

    /** Constructor */ 
    public Position(Node<E> n) {
        node = n;
    }

    /** Accessor method*/ 
    public Node<E> getNode() {
        return node;
    }

    /** New method to get the element at this position*/ 
    public E getElement() {
        return node.getElement();
    }
}

/** A class to implement the positional list ADT using linked list*/ 
class PositionalList<E> {
  private Node<E> header; /** header sentinel*/ 
  private Node<E> trailer; /** trailer sentinel*/
  private int size; /** number of elements in the list*/

  /** Constructor*/
  public PositionalList() {
    header = new Node<>(null, null, null); // create header
    trailer = new Node<>(null, header, null); // create trailer
    header.setNext(trailer); // make header and trailer point to each other
    size = 0; // initialize size as zero
  }

  /** Private method to validate a position and return its node*/ 
  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Position)) throw new IllegalArgumentException("Invalid position");
    Node<E> node = p.getNode(); // get the node at this position
    if (node.getPrev() == null || node.getNext() == null) throw new IllegalArgumentException("Position is no longer in the list");
    return node;
  }

  /**
   * Private method to create and return a position for a given node
   * @param node
   * @return
   */
  private Position<E> position(Node<E> node) {
    if (node == header || node == trailer) return null; // do not expose user to the sentinels
    return new Position<>(node); // create and return a new position for this node
  }

  /** Accessor methods provided by the positional list ADT*/

  public Position<E> first() {
    return position(header.getNext()); // return the position of the first node after header sentinel (or null if empty)
  }

  public Position<E> last() {
    return position(trailer.getPrev()); // return the position of the last node before trailer sentinel (or null if empty)
  }

  public Position<E> before(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    return position(node.getPrev()); // return the position of the previous node (or null if p is the first position)
  }

  public Position<E> after(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    return position(node.getNext()); // return the position of the next node (or null if p is the last position)
  }

  public boolean isEmpty() {
    return size == 0; // return true if size is zero (or false otherwise)
  }

  public int size() {
    return size; // return the number of elements in the list
  }

  
/** Update methods provided by the positional list ADT*/

  public Position<E> addFirst(E e) {
    return addBetween(e, header, header.getNext()); // add a new node between header and the first node, and return its position
  }

  public Position<E> addLast(E e) {
    return addBetween(e, trailer.getPrev(), trailer); // add a new node between the last node and trailer, and return its position
  }

  public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    return addBetween(e, node.getPrev(), node); // add a new node before this node, and return its position
  }

  public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    return addBetween(e, node, node.getNext()); // add a new node after this node, and return its position
  }

  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    E old = node.getElement(); // store the old element at this node
    node.setElement(e); // replace the element at this node with the new one
    return old; // return the old element
  }

  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p); // validate the position and get its node
    Node<E> prev = node.getPrev(); // get the previous node
    Node<E> next = node.getNext(); // get the next node
    prev.setNext(next); // make prev point to next
    next.setPrev(prev); // make next point to prev
    size--; // decrement size
    E old = node.getElement(); // store the old element at this node
    node.setElement(null); // help with garbage collection
    node.setPrev(null); // help with garbage collection
    node.setNext(null); // help with garbage collection
    return old; // return the old element
  }

  /** Private method to add a new node between two given nodes and return its position*/ 
  private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
    Node<E> newest = new Node<>(e, pred, succ); // create a new node with element e and references to pred and succ
    pred.setNext(newest); // make pred point to newest
    succ.setPrev(newest); // make succ point to newest
    size++; // increment size
    return new Position<>(newest); // return the position of the new node
  }

  /**  class to implement an iterator for the positional list using iterator interface*/
  class PositionalListIterator implements Iterator<E> {
    private Position<E> cursor; // position of the next element to report
    private Position<E> recent; // position of last reported element

    /**
     * Constructor
     * @param list
     */
    public PositionalListIterator(PositionalList<E> list) {
      cursor = list.first(); // start with the first position in the list (or null if empty)
      recent = null; // no element has been reported yet
    }

    /** Methods of iterator interface*/ 

    public boolean hasNext() {
      return cursor != null; // return true if cursor is not null (or false otherwise)
    }

    public E next() throws NoSuchElementException {
      if (cursor == null) throw new NoSuchElementException("Nothing left"); // throw an exception if cursor is null
      recent = cursor; // store the current cursor as recent
      cursor = after(cursor); // advance cursor to the next position (or null if end of list)
      return recent.getElement(); // return the element at recent position
    }

    public void remove() throws IllegalStateException {
      if (recent == null) throw new IllegalStateException("Nothing to remove"); // throw an exception if recent is null (no valid call to next)
      PositionalList.this.remove(recent); // remove the element at recent position from the list (using outer class's method)
      recent = null; // set recent to null (do not allow remove again until next is called)
      if (cursor == recent) cursor = after(cursor); // if cursor was at recent position, advance it to the next position (or null if end of list)
      else size--; // otherwise, decrement size (as remove method does not do it in this case)
    }
  }

    public Iterator<E> iterator() {
    return new PositionalListIterator(this); // create and return a new iterator for this list 
  }

}
