package org.neet.tree;

public class SameTree {

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        // Base condition
        if (t1.val != t2.val)
            return false;

        boolean left = dfs(t1.left, t2.left);
        boolean right = dfs(t1.right, t2.right);

        return left && right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(7);

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(t1, t2));
    }
}
