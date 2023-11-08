package org.neet.tree;

/**
 * Left sub node val < root val < right sub node val
 *
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
        System.out.println(bst.isValidBST(root));
    }
}
