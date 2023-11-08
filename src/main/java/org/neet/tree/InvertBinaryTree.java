package org.neet.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root
 */
public class InvertBinaryTree {

    private static TreeNode invert(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = invert(root);
        traversePreOrder(inverted);
    }

    private static void traversePreOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

}
