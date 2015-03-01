package Finished;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import Utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
            
        boolean leftToRight = true;
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (queue1.size() > 0) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            for (int i = 0; i < queue1.size(); ++i) {
                if (leftToRight) {
                    solution.add(queue1.get(i).val);
                    if (queue1.get(i).left != null)
                        queue2.add(queue1.get(i).left);
                    if (queue1.get(i).right != null)
                        queue2.add(queue1.get(i).right);
                }
                else {
                    solution.add(queue1.get(queue1.size() - i - 1).val);
                    if (queue1.get(queue1.size() - i - 1).right != null)
                        queue2.addFirst(queue1.get(queue1.size() - i - 1).right);
                    if (queue1.get(queue1.size() - i - 1).left != null)
                        queue2.addFirst(queue1.get(queue1.size() - i - 1).left);
                }
            }
            leftToRight = !leftToRight;
            queue1 = queue2;
            queue2 = new LinkedList<TreeNode>();
            result.add(solution);
        }
        return result;
    }
    
    @Test
    public void test() {
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	root.right.left = new TreeNode(3);
    	ArrayList<ArrayList<Integer>> result = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    	System.out.println(result);
    }
}
