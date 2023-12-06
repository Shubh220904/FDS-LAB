import java.util.List;
import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");

        tree.addChild(tree.root, nodeB);
        tree.addChild(tree.root, nodeC);
        tree.addChild(nodeB, nodeD);
        tree.addChild(nodeB, nodeE);
        tree.addChild(nodeC, nodeF);

        Scanner scanner = new Scanner(System.in);

         while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. List Siblings of a Node");
            System.out.println("2. List Leaves of the Tree");
            System.out.println("3. List Internal Nodes of the Tree");
            System.out.println("4. List Edges in the Tree");
            System.out.println("5. Find Path for a Given Node");
            System.out.println("6. Find Depth of a Node");
            System.out.println("7. Find Height of the Tree");
            System.out.println("8. Find Subtree Rooted at a Given Node");
            System.out.println("9. Display Tree");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter node data: ");
                    String nodeData = scanner.nextLine();
                    TreeNode nodeToFindSiblings = tree.findNode(nodeData);
                    if (nodeToFindSiblings != null) {
                        List<TreeNode> siblings = tree.findSiblings(nodeToFindSiblings);
                        System.out.print("Siblings of " + nodeToFindSiblings.getData() + ": ");
                        for (TreeNode sibling : siblings) {
                            System.out.print(sibling.getData() + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 2:
                    List<TreeNode> leaves = tree.listLeaves();
                    System.out.print("Leaves of the Tree: ");
                    for (TreeNode leaf : leaves) {
                        System.out.print(leaf.getData() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    List<TreeNode> internalNodes = tree.listInternalNodes();
                    System.out.print("Internal Nodes of the Tree: ");
                    for (TreeNode internalNode : internalNodes) {
                        System.out.print(internalNode.getData() + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    List<String> edges = tree.listEdges();
                    System.out.println("Edges in the Tree:");
                    for (String edge : edges) {
                        System.out.println(edge);
                    }
                    break;
                case 5:
                    System.out.print("Enter node data: ");
                    nodeData = scanner.nextLine();
                    TreeNode nodeToFindPath = tree.findNode(nodeData);
                    if (nodeToFindPath != null) {
                        List<String> path = tree.findPath(nodeData);
                        System.out.print("Path for " + nodeToFindPath.getData() + ": ");
                        for (String node : path) {
                            System.out.print(node + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter node data: ");
                    nodeData = scanner.nextLine();
                    TreeNode nodeToFindDepth = tree.findNode(nodeData);
                    if (nodeToFindDepth != null) {
                        int depth = tree.findDepth(nodeData);
                        System.out.println("Depth of " + nodeToFindDepth.getData() + ": " + depth);
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 7:
                    int height = tree.findHeight();
                    System.out.println("Height of the Tree: " + height);
                    break;
                case 8:
                    System.out.print("Enter node data to find subtree: ");
                    nodeData = scanner.nextLine();
                    Tree subtree = tree.findSubtree(nodeData);
                    if (subtree != null) {
                        System.out.println("Subtree rooted at " + nodeData + ":");
                        subtree.displayTree();
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 9:
                    System.out.println("Tree Structure:");
                    tree.displayTree();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
    

 
