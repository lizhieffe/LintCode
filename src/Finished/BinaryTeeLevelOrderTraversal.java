package Finished;

import java.util.ArrayList;
import java.util.LinkedList;

import Utils.TreeNode;

public class BinaryTeeLevelOrderTraversal {

	/**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        int count = 1;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> solution = new ArrayList<Integer>();
        while (count > 0) {
            --count;
            TreeNode toRemove = queue.remove(0);
            solution.add(toRemove.val);
            if (toRemove.left != null)
                queue.add(toRemove.left);
            if (toRemove.right != null)
                queue.add(toRemove.right);
            if (count == 0) {
                count = queue.size();
                result.add(solution);
                solution = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
