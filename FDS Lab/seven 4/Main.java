import java.util.Scanner;

public class Main {

    // Recursive method to perform pre-order traversal and display the tree
    private static void displayPreOrder(TreeNode root, int depth) {
        if (root != null) {
            // Display the current node
            displayNode(root, depth);

            // Recursively display the left and right subtrees
            displayPreOrder(root.left, depth + 1);
            displayPreOrder(root.right, depth + 1);
        }
    }

    // Helper method to display a node with proper indentation
    private static void displayNode(TreeNode node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("|    ");
        }
        System.out.println("└── " + node.data);
    }

    public static void main(String[] args) {
        // Creating the binary tree as shown in the example
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the root value:");
        String rootValue = scanner.nextLine();
        TreeNode root = new TreeNode(rootValue);

        buildTree(root, scanner);


        // Displaying the binary tree using pre-order traversal
        displayPreOrder(root, 0);
    }

    private static void buildTree(TreeNode node, Scanner scanner) {
        System.out.println("Enter left child for " + node.data + " (or type 'end' for no child):");
        String leftValue = scanner.nextLine();
        if (!leftValue.equals("end")) {
            node.left = new TreeNode(leftValue);
            buildTree(node.left, scanner);
        }

        System.out.println("Enter right child for " + node.data + " (or type 'end' for no child):");
        String rightValue = scanner.nextLine();
        if (!rightValue.equals("end")) {
            node.right = new TreeNode(rightValue);
            buildTree(node.right, scanner);
        }
    }
}


 

