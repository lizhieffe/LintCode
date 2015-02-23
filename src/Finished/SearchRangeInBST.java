package Finished;

import java.util.ArrayList;

import Utils.TreeNode;

public class SearchRangeInBST {

	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k1 > k2 || root == null)
            return result;
        searchRangeHelper(root, result, k1, k2);
        return result;
    }
    
    private void searchRangeHelper(TreeNode root, ArrayList<Integer> result
            , int k1, int k2) {
        if (root == null)
            return;
        if (root.val < k1)
            searchRangeHelper(root.right, result, k1, k2);
        else if (root.val > k2)
            searchRangeHelper(root.left, result, k1, k2);
        else {
            searchRangeHelper(root.left, result, k1, k2);
            result.add(root.val);
            searchRangeHelper(root.right, result, k1, k2);
        }
    }
}
