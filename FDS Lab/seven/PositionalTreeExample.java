

import java.util.*;
 

/**
 * Represents a positional tree example with various operations on tree nodes.
 */
public class PositionalTreeExample {
    private TreeNode<String> root;

    /**
     * Constructs a positional tree example with a specified root element.
     *
     * @param rootElement the element for the root node
     */
    
    public PositionalTreeExample(String rootElement) {
        this.root = new TreeNode<>(rootElement, null);
    }

    /**
     * Gets the root node of the tree.
     *
     * @return the root node of the tree
     */
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Displays the tree starting from the given node.
     *
     * @param node the starting node
     * @param depth the initial depth of the node
     */
    public void displayTree1() {
        displayTree1(root, "", 1);
    }
    
    private void displayTree1(TreeNode<String> node, String parentNumber, int childNumber) {
        String nodeNumber = parentNumber + childNumber;
        System.out.println("  ".repeat(depth(node))+nodeNumber + ". " + node.getElement());
    
        List<TreeNode<String>> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            displayTree1(children.get(i), nodeNumber + ".", i + 1);
        }
    }


    // Additional properties:

    // 1. Siblings of the node
    public List<String> siblings(TreeNode<String> node) {
        if (node.getParent() != null) {
            List<String> siblings = new ArrayList<>();
            for (TreeNode<String> sibling : node.getParent().getChildren()) {
                if (!sibling.equals(node)) {
                    siblings.add(sibling.getElement());
                }
            }
            return siblings;
        } else {
            return null;
        }
    }

    // 2. List leaves of the tree
    public List<String> leaves(TreeNode<String> node) {
        List<String> leafList = new ArrayList<>();
        if (node.getChildren().isEmpty()) {
            leafList.add(node.getElement());
        } else {
            for (TreeNode<String> child : node.getChildren()) {
                leafList.addAll(leaves(child));
            }
        }
        return leafList;
    }

    // 3. List internal nodes of the tree
    public List<String> internalNodes(TreeNode<String> node) {
        List<String> internalNodes = new ArrayList<>();
        if (!node.getChildren().isEmpty()) {
            internalNodes.add(node.getElement());
            for (TreeNode<String> child : node.getChildren()) {
                internalNodes.addAll(internalNodes(child));
            }
        }
        return internalNodes;
    }

    // 4. List of edges
    public List<String[]> edges(TreeNode<String> node) {
        List<String[]> edgeList = new ArrayList<>();
        for (TreeNode<String> child : node.getChildren()) {
            edgeList.add(new String[]{node.getElement(), child.getElement()});
            edgeList.addAll(edges(child));
        }
        return edgeList;
    }

    // 5. Path for a given node
    public List<String> path(TreeNode<String> node) {
        List<String> pathList = new ArrayList<>();
        while (node != null) {
            pathList.add(0, node.getElement());
            node = node.getParent();
        }
        return pathList;
    }

    // 6. Depth of the node
    public int depth(TreeNode<String> node) {
        int depth = 0;
        while (node.getParent() != null) {
            depth++;
            node = node.getParent();
        }
        return depth;
    }

    // 7. Height of the tree
    public int height(TreeNode<String> node) {
        if (node == null || node.getChildren().isEmpty()) {
            return 0;
        }

        int maxHeight = 0;
        for (TreeNode<String> child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, height(child));
        }

        return 1 + maxHeight;
    }

    // 8. Subtree rooted at a given node
    public TreeNode<String> subtree(TreeNode<String> node) {
        return node;
    }
        /**
     * Finds a node in the tree with a given target element.
     *
     * @param node the starting node
     * @param target the target element to find
     * @return the node with the target element, or null if not found
     */
    public TreeNode<String> findNode(TreeNode<String> node, String target) {
        if (node == null) {
            return null;
        }
        if (node.getElement().equals(target)) {
            return node;
        }
        for (TreeNode<String> child : node.getChildren()) {
            try {
                TreeNode<String> result = findNode(child, target);
                if (result != null) {
                    return result;
                }
            } catch (Exception e) {
                // Handle any exceptions thrown during recursion
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Adds a child with the specified element to a given parent node.
     *
     * @param parentNode the parent node to which the child will be added
     * @param element the element for the new child
     * @return the newly added child node, or null if the parent node is null
     */
    public TreeNode<String> addChild(TreeNode<String> parentNode, String element) {
        try {
            if (parentNode != null) {
                TreeNode<String> child = new TreeNode<>(element, parentNode);
                parentNode.getChildren().add(child);
                return child;
            } else {
                return null; // Handle the case where the parent node is null
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur during child addition
            e.printStackTrace();
            return null;
        }
    }
}