package Finished;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Utils.ListNode;

public class MergeKSortedLists {
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if (lists == null || lists.size() == 0)
            return dummy.next;
        ListNode[] array = new ListNode[lists.size()];
        for (int i = 0; i < array.length; ++i) {
        	array[i] = new ListNode(0);
        	array[i].next = lists.get(i);
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
        Map<ListNode, Integer> relation = new HashMap<ListNode, Integer>();
        for (int i = 0; i < lists.size(); ++i)
            if (array[i].next != null) {
                ListNode node = array[i].next;
                array[i].next = array[i].next.next;
                pq.add(node);
                relation.put(node, i);
            }
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            int i = relation.remove(node);
            if (array[i].next != null) {
            	ListNode tmp = array[i].next;
                array[i].next = array[i].next.next;
                pq.add(tmp);
                relation.put(tmp, i);
            }
        }
        return dummy.next;
    }
}

class ListNodeComparator implements Comparator <ListNode> {
    @Override
    public int compare(ListNode n1, ListNode n2) {
        if (n1.val < n2.val)
            return -1;
        else if (n1.val > n2.val)
            return 1;
        else
            return 0;
    }
}
