import java.util.*;

/**
 * A class to test the priority queue implementation.
 */
public class Main {

  /**
   * The main method to test the priority queue implementation.
   *
   * @param args the command line arguments (not used).
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // create a Scanner object
    PriorityQueue<Integer, String> pq = new PriorityQueue<>((a, b) -> a - b); // create a priority queue of integers and
                                                                              // strings
    boolean exit = false; // a flag to exit the loop
    while (!exit) {
      // display the menu options
      System.out.println("Choose an option:");
      System.out.println("1. Insert a new entry");
      System.out.println("2. Remove the minimum entry");
      System.out.println("3. Display the minimum entry");
      System.out.println("4. Display the size of the queue");
      System.out.println("5. Check if the queue is empty");
      System.out.println("6. Exit the program");
      System.out.print("Enter your choice: ");
      int choice = sc.nextInt(); // read the user's choice
      switch (choice) {
        case 1: // insert a new entry
          System.out.print("Enter the key (integer): ");
          int key = sc.nextInt(); // read the key
          System.out.print("Enter the value (string): ");
          String value = sc.next(); // read the value
          pq.insert(key, value); // insert the entry into the queue
          System.out.println("Entry inserted successfully.");
          break;
        case 2: // remove the minimum entry
          Entry<Integer, String> min = pq.removeMin(); // remove and get the minimum entry
          if (min == null) { // if the queue is empty
            System.out.println("The queue is empty.");
          } else { // if the queue is not empty
            System.out.println("The minimum entry is: (" + min.getKey() + ", " + min.getValue() + ")");
            System.out.println("Entry removed successfully.");
          }
          break;
        case 3: // display the minimum entry
          min = pq.min(); // get the minimum entry
          if (min == null) { // if the queue is empty
            System.out.println("The queue is empty.");
          } else { // if the queue is not empty
            System.out.println("The minimum entry is: (" + min.getKey() + ", " + min.getValue() + ")");
          }
          break;
        case 4: // display the size of the queue
          System.out.println("The size of the queue is: " + pq.size());
          break;
        case 5: // check if the queue is empty
          System.out.println("The queue is " + (pq.isEmpty() ? "empty." : "not empty."));
          break;
        case 6: // exit the program
          exit = true;
          System.out.println("Thank you for using the program.");
          break;
        default: // invalid choice
          System.out.println("Invalid choice. Please try again.");
          break;
      }
      System.out.println(); // print a blank line
    }
    sc.close(); // close the scanner
  }
}
