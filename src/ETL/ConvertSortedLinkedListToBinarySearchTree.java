package ETL;

import Utils.ListNode;
import Utils.TreeNode;

public class ConvertSortedLinkedListToBinarySearchTree {

	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
     
	/*
	 * ETL
	 * But the solution is the same as GeeksForGeeks
	 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
	 */
    private ListNode curr;
    
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null)
            return null;
        int length = getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        curr = dummy;
        return getRoot(length);
    }
    
    private TreeNode getRoot(int length) {
        if (length == 0)
            return null;
        else if (length == 1) {
            curr = curr.next;
            return new TreeNode(curr.val);
        }
        
        int mid = length / 2;
        int leftLength = length - mid - 1;
        int rightLength = length - 1 - leftLength;
        TreeNode left = getRoot(leftLength);
        curr = curr.next;
        TreeNode root = new TreeNode(curr.val);
        TreeNode right = getRoot(rightLength);
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
