package Finished;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	/**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        // write your code here
        LinkedList<ArrayList<Integer>> result = new LinkedList<ArrayList<Integer>>();
        if (root == null)
            return new ArrayList<ArrayList<Integer>>(result);
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int size = 1;
        ArrayList<Integer> solution = new ArrayList<Integer>();
        while (queue.size() > 0) {
            --size;
            TreeNode first = queue.remove(0);
            solution.add(first.val);
            if (first.left != null)
                queue.add(first.left);
            if (first.right != null)
                queue.add(first.right);
            if (size == 0) {
                result.addFirst(solution);
                solution = new ArrayList<Integer>();
                size = queue.size();
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}
