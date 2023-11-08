package org.neet.tree;

public class SubTreeOfAnotherTree {

    public boolean isSubTree(TreeNode t, TreeNode subTree) {
        if (t == null)
            return false;

        // Check root level whether matching sub tree 2(root) -> 1(left) -> 3(right)
        if (subTree == null || isSameTree(t, subTree))
            return true;

        // Check left and right sub trees
        return isSameTree(t.left, subTree) || isSameTree(t.right, subTree);
    }

    private boolean isSameTree(TreeNode t, TreeNode s) {
        if (t == null && s == null)
            return true;

        if (t == null || s == null)
            return false;

        // Base Condition
        if (t.val != s.val)
            return false;

        boolean left = isSameTree(t.left, s.left);
        boolean right = isSameTree(t.right, s.right);

        return left && right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode subTree = new TreeNode(7);
        subTree.left = new TreeNode(6);
        subTree.right = new TreeNode(9);

        SubTreeOfAnotherTree s = new SubTreeOfAnotherTree();
        System.out.println(s.isSubTree(root, subTree));
    }
}
