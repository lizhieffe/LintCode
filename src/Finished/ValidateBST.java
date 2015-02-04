package Finished;

import Utils.TreeNode;

public class ValidateBST {

	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val < min || root.val > max)
            return false;
        if (!isValidBST(root.left, min, root.val - 1))
            return false;
        if (!isValidBST(root.right, root.val + 1, max))
            return false;
        return true;
    }
}
