package Finished;

import java.util.PriorityQueue;

public class KthPrimeNumber {
	/**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
    	if (k <= 0)
    		return -1;
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        heap.add(3L);
        heap.add(5L);
        heap.add(7L);
        for (int i = 1; i < k; ++i) {
        	Long val = heap.poll();
        	Long newVal = val * 3;
        	if (!heap.contains(newVal))
        		heap.add(newVal);

        	newVal = val * 5;
        	if (!heap.contains(newVal))
        		heap.add(newVal);

        	newVal = val * 7;
        	if (!heap.contains(newVal))
        		heap.add(newVal);
        }
        return heap.poll();
    }
}
