class TreeNode {
    String value;
    TreeNode left, right;

    TreeNode(String item) {
        value = item;
        left = right = null;
    }

    void displayInfix() {
        if (this != null) {
            boolean isOperator = value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
            boolean hasParentheses = this.left != null && this.right != null && isOperator;

            if (hasParentheses) {
                System.out.print("(");
            }

            if (left != null) {
                left.displayInfix();
            }

            System.out.print(value);

            if (right != null) {
                right.displayInfix();
            }

            if (hasParentheses) {
                System.out.print(")");
            }
        }
    }
}

