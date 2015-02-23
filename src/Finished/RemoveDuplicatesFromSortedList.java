package Finished;

import Utils.ListNode;

public class RemoveDuplicatesFromSortedList {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null)
            return null;
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return dummy.next;
    }  
}
