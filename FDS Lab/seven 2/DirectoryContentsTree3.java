import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a node in a directory tree, storing information about a file or directory.
 */
class TreeNode {
    String name;
    int fileType; // 0-file, 1-directory
    long size;
    Date date;
    List<TreeNode> children;

    /**
     * Constructor to initialize a TreeNode with file/directory information.
     *
     * @param name     The name of the file or directory.
     * @param fileType The type of the file (0 for file, 1 for directory).
     * @param size     The size of the file in bytes.
     * @param date     The last modified date of the file or directory.
     */
    TreeNode(String name, int fileType, long size, Date date) {
        this.name = name;
        this.fileType = fileType;
        this.size = size;
        this.date = date;
        this.children = new ArrayList<>();
    }
}

/**
 * A program that displays the contents of a directory and calculates the total disk space.
 */
public class DirectoryContentsTree3 {

    /**
     * Recursively builds a tree structure representing the contents of a directory.
     *
     * @param directory The directory to build the tree for.
     * @return The root node of the directory tree.
     */
    private static TreeNode buildTree(File directory) {
        TreeNode root = new TreeNode(directory.getName(), 1, 0, new Date());

        for (File file : directory.listFiles()) {
            TreeNode node = getFileInfo(file);
            root.children.add(node);

            if (file.isDirectory()) {
                node.children.addAll(buildTree(file).children);
            }
        }
        return root;
    }

    /**
     * Retrieves information about a file and creates a corresponding TreeNode.
     *
     * @param file The file to get information for.
     * @return A TreeNode representing the file information.
     */
    private static TreeNode getFileInfo(File file) {
        String name = file.getName();
        int fileType = file.isFile() ? 0 : 1;
        long size = file.length();
        Date date = new Date(file.lastModified());
        return new TreeNode(name, fileType, size, date);
    }

    /**
     * Displays the contents of a directory tree with indentation.
     *
     * @param node   The current node in the directory tree.
     * @param indent The indentation string based on the depth of the node.
     */
    private static void displayDirectoryContents(TreeNode node, String indent) {
        System.out.printf("%s%s | Type: %s | Size: %d bytes | Date: %s%n",
                indent,
                node.name,
                node.fileType == 0 ? "File" : "Directory",
                node.size,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(node.date));

        for (TreeNode child : node.children) {
            displayDirectoryContents(child, indent + "  ");
        }
    }

    /**
     * The main method of the program that initiates the directory tree display.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Replace "your_directory_path" with the path to the directory you want to analyze
        Scanner sc = new Scanner(System.in);
        String directoryPath = sc.nextLine();
        System.out.println("this is output " + directoryPath);
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            TreeNode root = buildTree(directory);
            displayDirectoryContents(root, "");
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
