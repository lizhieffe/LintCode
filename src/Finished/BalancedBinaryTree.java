package Finished;

import Utils.TreeNode;

public class BalancedBinaryTree {

	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return getHeight(root) == -1 ? false : true;
        
    }
    
    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        if (left == -1)
            return -1;
        int right = getHeight(node.right);
        if (right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
