package Finished;

import Utils.ListNode;

public class MergeTwoSortedList {

	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy1 = new ListNode(-1);
        dummy1.next = l1;
        ListNode dummy2 = new ListNode(-1);
        dummy2.next = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (dummy1.next != null && dummy2.next != null) {
            if (dummy1.next.val < dummy2.next.val) {
                curr.next = remove(dummy1);
            }
            else {
                curr.next = remove(dummy2);
            }
            curr = curr.next;
        }
        if (dummy1.next != null)
            curr.next = dummy1.next;
        if (dummy2.next != null)
            curr.next = dummy2.next;
        return dummy.next;
    }
    
    private ListNode remove(ListNode node) {
        ListNode result = node.next;
        node.next = result.next;
        return result;
    }
}
