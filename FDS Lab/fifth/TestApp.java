import java.util.*;

/** A class to test the positional list implementation using switch case*/
public class TestApp {
  public static void main(String[] args) {
    PositionalList<Integer> list = new PositionalList<>(); /** create a new positional list of integers*/ 
    Scanner sc = new Scanner(System.in); /** create a scanner object for user input*/ 
    boolean exit = false; /** flag to exit the loop*/
    while (!exit) {
      System.out.println();
      System.out.println("Choose an option:");
      System.out.println("1. Insert element at the first position");
      System.out.println("2. Insert element at the last position");
      System.out.println("3. Insert element before a given position");
      System.out.println("4. Insert element after a given position");
      System.out.println("5. Insert element at a given position");
      System.out.println("6. Remove an element at a given position");
      System.out.println("7. Get first position");
      System.out.println("8. Get last position");
      System.out.println("9. Get position before a given position");
      System.out.println("10. Get the position after a given position");
      System.out.println("11. Check if the list is empty");
      System.out.println("12. Get the size of the list");
      System.out.println("13. Iterate over the list elements");
      System.out.println("14. Exit");
      System.out.println("Type Your Option:");
      int choice = sc.nextInt(); // read the user's choice
      switch (choice) {
        case 1: // add an element at the first position
          System.out.println("Enter the element to add:");
          int e1 = sc.nextInt(); // read the element to add
          Position<Integer> p1 = list.addFirst(e1); // add the element at the first position and get its position
           
          break;
        case 2: // add an element at the last position
          System.out.println("Enter the element to add:");
          int e2 = sc.nextInt(); // read the element to add
          Position<Integer> p2 = list.addLast(e2); // add the element at the last position and get its position
           
          break;
        case 3: // add an element before a given position
          System.out.println("Enter the index of the position before which to add (starting from 0):");
          int i3 = sc.nextInt(); // read the index of the position before which to add
          Position<Integer> p3 = getPositionByIndex(list, i3); // get the position by index
          if (p3 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          System.out.println("Enter the element to add:");
          int e3 = sc.nextInt(); // read the element to add
          Position<Integer> p4 = list.addBefore(p3, e3); // add the element before the given position and get its position
          
          break;
        case 4: // add an element after a given position
          System.out.println("Enter the index of the position after which to add (starting from 0):");
          int i4 = sc.nextInt(); // read the index of the position after which to add
          Position<Integer> p5 = getPositionByIndex(list, i4); // get the position by index
          if (p5 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          System.out.println("Enter the element to add:");
          int e4 = sc.nextInt(); // read the element to add
          Position<Integer> p6 = list.addAfter(p5, e4); // add the element after the given position and get its position
          
          break;
        case 5: // set an element at a given position
          System.out.println("Enter the index of the position to set (starting from 0):");
          int i5 = sc.nextInt(); // read the index of the position to set
          Position<Integer> p7 = getPositionByIndex(list, i5); // get the position by index
          if (p7 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          System.out.println("Enter the new element:");
          int e5 = sc.nextInt(); // read the new element
          int old5 = list.set(p7, e5); // set the new element at the given position and get its old element
                  
          break;
        case 6: // remove an element at a given position
          System.out.println("Enter the index of the position to remove (starting from 0):");
          int i6 = sc.nextInt(); // read the index of the position to remove
          Position<Integer> p8 = getPositionByIndex(list, i6); // get the position by index
          if (p8 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          int e6 = list.remove(p8); // remove the element at the given position and get its element
           
          break;
        case 7: // get the first position
          Position<Integer> p9 = list.first(); // get the first position in the list (or null if empty)
          if (p9 == null) { // if the position is null, print a message and break
            System.out.println("The list is empty");
            break;
          }
          int e7 = p9.getElement(); // get the element at the first position
          System.out.println("The first position is " + p9 + " and its element is " + e7);
          break;
        case 8: // get the last position
          Position<Integer> p10 = list.last(); // get the last position in the list (or null if empty)
          if (p10 == null) { // if the position is null, print a message and break
            System.out.println("The list is empty");
            break;
          }
          int e8 = p10.getElement(); // get the element at the last position
          System.out.println("The last position is " + p10 + " and its element is " + e8);
          break;
        case 9: // get the position before a given position
          System.out.println("Enter the index of the position before which to get (starting from 0):");
          int i9 = sc.nextInt(); // read the index of the position before which to get
          Position<Integer> p11 = getPositionByIndex(list, i9); // get the position by index
          if (p11 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          Position<Integer> p12 = list.before(p11); // get the position before the given position (or null if first)
          if (p12 == null) { // if the position is null, print a message and break
            System.out.println("There is no position before " + p11);
            break;
          }
          int e9 = p12.getElement(); // get the element at the previous position
          System.out.println("The position before " + p11 + " is " + p12 + " and its element is " + e9);
          break;
        case 10: // get the position after a given position
          System.out.println("Enter the index of the position after which to get (starting from 0):");
          int i10 = sc.nextInt(); // read the index of the position after which to get
          Position<Integer> p13 = getPositionByIndex(list, i10); // get the position by index
          if (p13 == null) { // if the position is null, print an error message and break
            System.out.println("Invalid index");
            break;
          }
          Position<Integer> p14 = list.after(p13); // get the position after the given position (or null if last)
          if (p14 == null) { // if the position is null, print a message and break
            System.out.println("There is no position after " + p13);
            break;
          }
          int e10 = p14.getElement(); // get the element at the next position
          System.out.println("The position after " + p13 + " is " + p14 + " and its element is " + e10);
          break;
        case 11: // check if the list is empty
          boolean empty = list.isEmpty(); // check if the list is empty or not
          System.out.println("The list is " + (empty ? "" : "not ") + "empty");
          break;
        case 12: // get the size of the list
          int s = list.size(); // get the number of elements in the list
          System.out.println("The size of the list is " + s);
          break;
        case 13: // iterate over the list elements
          System.out.println("The list elements are:");
          Iterator<Integer> it = list.iterator(); // get an iterator for the list
          while (it.hasNext()) { // while there is a next element
            int e = it.next(); // get the next element
            System.out.print(e + " "); // print the element
          }
          System.out.println(); // print a new line
          break;
        case 14: // exit
          exit = true; // set the flag to true
           
          break;
        default: // invalid choice
          System.out.println("Invalid choice");
          break;
      }
    }
    sc.close(); /** close the scanner object*/ 
  }

  /** A helper method to get the position by index in the list*/ 
  public static Position<Integer> getPositionByIndex(PositionalList<Integer> list, int index) {
    if (index < 0 || index >= list.size()) return null; /**return null if index is out of bounds */ 
    Position<Integer> p = list.first(); /** start with the first position in the list*/ 
    for (int i = 0; i < index; i++) { /**loop until index is reached */
      p = list.after(p); /** get the next position in the list*/
    }
    return p; /** return the position at index*/ 
  }
}    