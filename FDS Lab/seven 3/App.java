import java.util.Scanner;

class TreeNode {
    String value;
    TreeNode left, right;

    public TreeNode(String value) {
        this.value = value;
        this.left = this.right = null;
    }

    public void displayInfix() {
        if (left != null || right != null) {
            System.out.print("(");
        }

        if (left != null) {
            left.displayInfix();
        }

        System.out.print(value);

        if (right != null) {
            right.displayInfix();
        }

        if (left != null || right != null) {
            System.out.print(")");
        }
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the root value:");
        String rootValue = scanner.nextLine();
        TreeNode root = new TreeNode(rootValue);

        buildTree(root, scanner);

        System.out.print("Arithmetic expression in infix order: ");
        root.displayInfix();
        System.out.println();
        displayPreOrder(root, 0);

        scanner.close();
    }

    private static void buildTree(TreeNode node, Scanner scanner) {
        System.out.println("Enter left child for " + node.value + " (or type 'end' for no child):");
        String leftValue = scanner.nextLine();
        if (!leftValue.equals("end")) {
            node.left = new TreeNode(leftValue);
            buildTree(node.left, scanner);
        }

        System.out.println("Enter right child for " + node.value + " (or type 'end' for no child):");
        String rightValue = scanner.nextLine();
        if (!rightValue.equals("end")) {
            node.right = new TreeNode(rightValue);
            buildTree(node.right, scanner);
        }
    }

    private static void displayNode(TreeNode node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("|    ");
        }
        System.out.println("└── " + node.value);
    }

    private static void displayPreOrder(TreeNode root, int depth) {
        if (root != null) {
            // Display the current node
            displayNode(root, depth);

            // Recursively display the left and right subtrees
            displayPreOrder(root.left, depth + 1);
            displayPreOrder(root.right, depth + 1);
        }
    }
}

