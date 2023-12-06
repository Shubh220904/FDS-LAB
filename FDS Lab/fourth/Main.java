import java.util.*; 
import java.util.EmptyStackException;

/**
 * This class represents a generic stack with methods to perform stack operations.
 *
 * @param <T> the type of elements to be stored in the stack
 */
class Stack<T> {
    private T[] arr;
    private int top;

    /**
     * Initializes a new stack with the specified size.
     *
     * @param size the maximum capacity of the stack
     */
    public Stack(int size) {
        arr = (T[]) new Object[size];
        top = -1;
    }

    /**
     * Returns the current size of the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element the element to be pushed onto the stack
     * @throws IllegalStateException if the stack is full
     */
    public void push(T element) {
        if (size() == arr.length) {
            throw new IllegalStateException("Stack is Full");
        }
        arr[++top] = element;
    }

    /**
     * Pops and returns the top element from the stack.
     *
     * @return the element that was removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }
}

 
 
/* * * This is the main class for a simple Stack program that allows users to perform basic
 * stack operations including push, pop, size, isEmpty, and peek.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length Of Stack: ");
        int length = sc.nextInt();
        Stack<Integer> stack = new Stack<>(length);
        System.out.println("1.Push\n2.Pop\n3.Size\n4.isEmpty\n5.Peek\n6.Exit");

        while (true) {
            System.out.print("Enter Your Choice: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Element to be added: ");
                        int element = sc.nextInt();
                        stack.push(element);
                        break;
                    case 2:
                        System.out.println("Popped Element: " + stack.pop());
                        break;
                    case 3:
                        System.out.println("Size Of Stack: " + stack.size());
                        break;
                    case 4:
                        if (stack.isEmpty()) {
                            System.out.println("Stack is Empty");
                        } else {
                            System.out.println("Stack is Not Empty");
                        }
                        break;
                    case 5:
                        System.out.println("Peek Element: " + stack.peek());
                        break;
                    case 6:
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice...");
                }
            } else {
                System.out.println("Invalid Choice. Please enter an integer.");
                sc.next();
            }
        }
    }
}

