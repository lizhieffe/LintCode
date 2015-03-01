package Finished;

import Utils.ListNode;

public class NthToLastNodeInList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode second = dummy;
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            if (i >= n)
                second = second.next;
            ++i;
        }
        return second;
    }
}
