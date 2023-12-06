class TreeNode {
    private String data;
    TreeNode parent;
    TreeNode firstChild;
    TreeNode nextSibling;
    

    public TreeNode(String data) {
        this.data = data;
        this.parent = null;
        this.firstChild = null;
        this.nextSibling = null;
    }

    public String getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

     
    public String getChildren() {
        return null;
    }
}
    


   