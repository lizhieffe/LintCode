package Finished;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utils.TreeNode;

public class BinaryTreePostorderTraversalII {

	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        addTillLeftMost(root, stack);
        while (stack.size() > 0) {
            TreeNode first = stack.get(stack.size() - 1);
            if (visited.contains(first)) {
                result.add(stack.remove(stack.size() - 1).val);
            }
            else {
                visited.add(first);
                addTillLeftMost(first.right, stack);
            }
        }
        return result;
    }
    
    private void addTillLeftMost(TreeNode root, List<TreeNode> stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }
}
