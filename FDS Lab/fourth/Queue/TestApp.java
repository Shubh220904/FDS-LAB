package Queue;
import java.util.*;


public class TestApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Capacity Of Queue: ");
        int capacity = sc.nextInt();
        Queue<Integer> queue = new Queue<>(capacity);
        System.out.println("1.Enqueue\n2.Dequeue\n3.First\n4.Size\n5.isEmpty\n6.Exit");

        while (true) {
            System.out.print("Enter Your Choice: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Element to be added: ");
                        int element = sc.nextInt();
                        queue.enqueue(element);
                        break;
                    case 2:
                        Integer dequeued = queue.dequeue();
                        if (dequeued == null) {
                            System.out.println("Queue is Empty");
                        } else {
                            System.out.println("Dequeued Element: " + dequeued);
                        }
                        break;
                    case 3:
                        Integer first = queue.first();
                        if (first == null) {
                            System.out.println("Queue is Empty");
                        } else {
                            System.out.println("First Element: " + first);
                        }
                        break;
                    case 4:
                        System.out.println("Size of Queue: " + queue.size());
                        break;
                    case 5:
                        if (queue.isEmpty()) {
                            System.out.println("Queue is Empty");
                        } else {
                            System.out.println("Queue is Not Empty");
                        }
                        break;
                    case 6:
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
