package Finished;

import Utils.ListNode;
import Utils.TreeNode;

public class ConvertSortedLinkedListToBinarySearchTree {

	/**
     * @param head: The first node of linked list.
     * @return: a tree node
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
        TreeNode left = getRoot(length - mid);
        curr = curr.next;
        TreeNode root = new TreeNode(curr.val);
        TreeNode right = getRoot(length - mid - 1);
        
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
