package org.neet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1. Traverse the tree "inorder" and populate arraylist
 * 2. Then retrieve by index
 *
 */
public class KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
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

        KthSmallestElement kse = new KthSmallestElement();
        System.out.println(kse.kthSmallest(root, 3));
    }

}
