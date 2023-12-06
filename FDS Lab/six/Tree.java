import java.util.*;

class Tree {
    TreeNode root;

    public Tree(String rootData) {
        this.root = new TreeNode(rootData);
    }

    public void addChild(TreeNode parent, TreeNode child) {
        child.parent = parent;
        if (parent.firstChild == null) {
            parent.firstChild = child;
        } else {
            TreeNode sibling = parent.firstChild;
            while (sibling.nextSibling != null) {
                sibling = sibling.nextSibling;
            }
            sibling.nextSibling = child;
        }
    }

    public void displayTree() {
        displayTree(root, 0);
    }

    private void displayTree(TreeNode node, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("->");
        }
        System.out.println(indent.toString() + node.getData());
        TreeNode child = node.getFirstChild();
        while (child != null) {
            displayTree(child, level + 1);
            child = child.getNextSibling();
        }
    }

    public TreeNode findParent(TreeNode node) {
        return node.getParent();
    }

    public int findDepth(TreeNode node) {
        int depth = 0;
        TreeNode currentNode = node;
        while (currentNode != root) {
            currentNode = currentNode.getParent();
            depth++;
        }
        return depth;
    }

    public int findHeight() {
        return findHeight(root);
    }

    private int findHeight(TreeNode node) {
        int maxHeight = -1;
        TreeNode child = node.getFirstChild();
        while (child != null) {
            int childHeight = findHeight(child);
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
            child = child.getNextSibling();
        }
        return maxHeight + 1;
    }
    public Tree findSubtree(TreeNode node) {
        TreeNode newRoot = new TreeNode(node.getData());
        copySubtree(node, newRoot);
        Tree subtree = new Tree(newRoot.getData());
        subtree.root = newRoot;
        return subtree;
    }

    private void copySubtree(TreeNode sourceNode, TreeNode destinationNode) {
        TreeNode sourceChild = sourceNode.getFirstChild();
        while (sourceChild != null) {
            TreeNode newChild = new TreeNode(sourceChild.getData());
            newChild.parent = destinationNode;
            if (destinationNode.firstChild == null) {
                destinationNode.firstChild = newChild;
            } else {
                TreeNode sibling = destinationNode.firstChild;
                while (sibling.nextSibling != null) {
                    sibling = sibling.nextSibling;
                }
                sibling.nextSibling = newChild;
            }
            copySubtree(sourceChild, newChild);
            sourceChild = sourceChild.getNextSibling();
        }
    }
    
    
    public List<TreeNode> findSiblings(String data) {
        TreeNode node = findNode(data);
        if (node != null) {
            return findSiblings(node);
        } else {
            return new ArrayList<>();
        }
    }

    private List<TreeNode> findSiblings(TreeNode node) {
        List<TreeNode> siblings = new ArrayList<>();
        if (node.getParent() != null) {
            TreeNode sibling = node.getParent().getFirstChild();
            while (sibling != null) {
                if (sibling != node) {
                    siblings.add(sibling);
                }
                sibling = sibling.getNextSibling();
            }
        }
        return siblings;
    }

    public List<TreeNode> listLeaves() {
        List<TreeNode> leaves = new ArrayList<>();
        listLeaves(root, leaves);
        return leaves;
    }

    private void listLeaves(TreeNode node, List<TreeNode> leaves) {
        if (node.getChildren().isEmpty()) {
            leaves.add(node);
        }
        TreeNode child = node.getFirstChild();
        while (child != null) {
            listLeaves(child, leaves);
            child = child.getNextSibling();
        }
    }

    public List<TreeNode> listInternalNodes() {
        List<TreeNode> internalNodes = new ArrayList<>();
        listInternalNodes(root, internalNodes);
        return internalNodes;
    }

    private void listInternalNodes(TreeNode node, List<TreeNode> internalNodes) {
        if (!node.getChildren().isEmpty()) {
            internalNodes.add(node);
        }
        TreeNode child = node.getFirstChild();
        while (child != null) {
            listInternalNodes(child, internalNodes);
            child = child.getNextSibling();
        }
    }

    public List<String> listEdges() {
        List<String> edges = new ArrayList<>();
        listEdges(root, edges);
        return edges;
    }

    private void listEdges(TreeNode node, List<String> edges) {
        TreeNode child = node.getFirstChild();
        while (child != null) {
            edges.add(node.getData() + " -> " + child.getData());
            listEdges(child, edges);
            child = child.getNextSibling();
        }
    }

    public List<String> findPath(String data) {
        TreeNode node = findNode(data);
        List<String> path = new ArrayList<>();
        if (node != null) {
            findPath(root, node, path);
        }
        return path;
    }

    private boolean findPath(TreeNode currentNode, TreeNode targetNode, List<String> path) {
        if (currentNode == null) {
            return false;
        }
        path.add(currentNode.getData());
        if (currentNode == targetNode || findPath(currentNode, targetNode, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

     
    
    

}
