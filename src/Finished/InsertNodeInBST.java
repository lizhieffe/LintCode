package Finished;

import Utils.TreeNode;

public class InsertNodeInBST {

	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null)
            return node;
        if (node == null)
            return root;
        if (root.val > node.val) {
            if (root.left == null)
                root.left = node;
            else
                insertNode(root.left, node);
        }
        else {
            if (root.right == null)
                root.right = node;
            else
                insertNode(root.right, node);
        }
        return root;
    }
}
