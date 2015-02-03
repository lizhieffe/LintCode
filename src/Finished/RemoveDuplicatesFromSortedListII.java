package Finished;

import Utils.ListNode;

public class RemoveDuplicatesFromSortedListII {

	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null && curr.next != null && curr.next.next != null) {
            if (curr.next.val != curr.next.next.val)
                curr = curr.next;
            else {
                ListNode end = curr.next.next.next;
                while (end != null && curr.next.val == end.val)
                    end = end.next;
                curr.next = end;
            }
        }
        return dummy.next;
    }
}
