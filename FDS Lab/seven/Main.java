import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PositionalTreeExample treeExample = new PositionalTreeExample("1");
        TreeNode<String> root = treeExample.getRoot();

        treeExample.displayTree1();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Siblings of the node");
            System.out.println("2. List leaves of the tree");
            System.out.println("3. List internal nodes of the tree");
            System.out.println("4. List of edges");
            System.out.println("5. Path for a given node");
            System.out.println("6. Depth of the node");
            System.out.println("7. Height of the tree");
            System.out.println("8. Subtree rooted at a given node");
            System.out.println("9. Add Child");
            System.out.println("10.Display Tree");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the node element: ");
                    String element = scanner.nextLine();
                    TreeNode<String> node = treeExample.findNode(root, element);
                    if (node != null) {
                        System.out.println("Siblings of " + element + ": " + treeExample.siblings(node));
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 2:
                    System.out.println("Leaves of the tree: " + treeExample.leaves(root));
                    break;
                case 3:
                    System.out.println("Internal nodes of the tree: " + treeExample.internalNodes(root));
                    break;
                case 4:
                    System.out.println("Edges of the tree: " + treeExample.edges(root));
                    break;
                case 5:
                    System.out.print("Enter the node element: ");
                    element = scanner.nextLine();
                    node = treeExample.findNode(root, element);
                    if (node != null) {
                        System.out.println("Path for " + element + ": " + treeExample.path(node));
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter the node element: ");
                    element = scanner.nextLine();
                    node = treeExample.findNode(root, element);
                    if (node != null) {
                        System.out.println("Depth of " + element + ": " + treeExample.depth(node));
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 7:
                    System.out.println("Height of the tree: " + treeExample.height(root));
                    break;
                case 8:
                    System.out.print("Enter the node element: ");
                    element = scanner.nextLine();
                    node = treeExample.findNode(root, element);
                    if (node != null) {
                        treeExample.displayTree1();
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 9:
                    System.out.print("Enter the parent node element to add a child: ");
                    String parentElement = scanner.nextLine();
                    TreeNode<String> parentNode = treeExample.findNode(root, parentElement);
                
                    if (parentNode != null) {
                        System.out.print("Enter the element for the new child: ");
                        String newChildElement = scanner.nextLine();
                        treeExample.addChild(parentNode, newChildElement);
                        System.out.println("Child added successfully.");
                        treeExample.displayTree1();  // Display the updated tree
                    } else {
                        System.out.println("Parent node not found.");
                    }
                    break;
                case 10:
                    treeExample.displayTree1();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        }
    }
}
