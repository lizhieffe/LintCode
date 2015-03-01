package Finished;

import Utils.ListNode;

public class TwoListSum {
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode d1 = new ListNode(0);
        d1.next = l1;
        ListNode d2 = new ListNode(0);
        d2.next = l2;
        ListNode d = new ListNode(0);
        ListNode curr = d;
        int mod = 0;
        while (d1.next != null || d2.next != null) {
            int n1 = removeFirst(d1);
            int n2 = removeFirst(d2);
            int tmp = n1 + n2 + mod;
            curr.next = new ListNode(tmp % 10);
            curr = curr.next;
            mod = tmp / 10;
        }
        if (mod == 1)
            curr.next = new ListNode(1);
        return d.next;
    }
    
    private int removeFirst(ListNode node) {
        if (node.next == null)
            return 0;
        ListNode tmp = node.next;
        node.next = node.next.next;
        return tmp.val;
    }
}
