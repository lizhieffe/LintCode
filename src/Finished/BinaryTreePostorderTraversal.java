package Finished;

import java.util.ArrayList;

import Utils.TreeNode;

public class BinaryTreePostorderTraversal {

	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }
    
    private void traversal(TreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        traversal(node.left, result);
        traversal(node.right, result);
        result.add(node.val);
    }
}
