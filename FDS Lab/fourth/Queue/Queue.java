package Queue;
import java.util.*;

/**
 * This class represents a generic queue implemented using an array with methods
 * to perform common queue operations.
 *
 * @param <T> the type of elements to be stored in the queue
 */
class Queue<T> {
    private T[] arr;
    private int front;
    private int rear;
    private int size;

    /**
     * Initializes an empty queue with the specified capacity.
     *
     * @param capacity the maximum capacity of the queue
     */
    public Queue(int capacity) {
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to be added to the queue
     */
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is Full");
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = element;
        size++;
    }

    /**
     * Removes and returns the first element from the queue.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T removed = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return removed;
    }

    /**
     * Returns the first element of the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return arr[front];
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return size == arr.length;
    }
}

