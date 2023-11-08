package org.neet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS - Tree
 *
 * 1. Use a queue and initialize with root
 * 2. Pop the 1st element, add the value to a list and add the left and right child to the queue
 *
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return result;

        // 1. Add tree root to queue
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>(len);

            for (int i=0; i<len; i++) {
                // 2. Remove the element from queue and add to list
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
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

        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> result = lot.levelOrderTraversal(root);
        System.out.println(result);
    }

}
