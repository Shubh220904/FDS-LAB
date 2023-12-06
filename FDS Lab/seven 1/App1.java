    import java.util.*;

    /**
     * This is a simple program for managing a tree data structure with various
     * operations.
     */
    public class App1{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Root Node : ");
            String rootN = scanner.nextLine();
            Tree<String> tree = new Tree<>(rootN);

            System.out.println("\nMenu:");
            System.out.println("1. Display Tree");
            System.out.println("2. Add Child Node");
            System.out.println("3. Exit");
            System.out.println();

            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1:
                            tree.displayTree1();
                            System.out.println();
                            break;
                        case 2:
                            System.out.print("Enter the value of the parent node: ");
                            String parentValue = scanner.nextLine();
                            Position<String> parent = findNodeWithValue(tree, parentValue);

                            if (parent == null) {
                                System.out.println("Parent node not found.");
                            } else {
                                System.out.print("Enter the value of the new child node: ");
                                String childValue = scanner.nextLine();
                                tree.addChild(parent, childValue);
                                System.out.println("Added " + childValue + " Successfully");
                            }
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("Exiting the program.");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                } catch (Exception e) {
                    // Handle exceptions here, for example, print an error message
                    System.err.println("An error occurred: " + e.getMessage());
                    System.out.println();
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        }

        /**
         * Find a node with a specific value in the tree.
         *
         * @param tree  The tree in which to search for the node.
         * @param value The value to search for.
         * @return The Position of the node with the specified value, or null if not
         *         found.
         */
        private static Position<String> findNodeWithValue(Tree<String> tree, String value) {
            for (Position<String> position : tree.positions()) {
                if (position.getElement().equals(value)) {
                    return position;
                }
            }
            return null;
        }
    }
