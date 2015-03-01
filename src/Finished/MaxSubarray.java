package Finished;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxSubarray {
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null)
            return 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(sum);
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums.get(i);
            if (result < sum - heap.peek())
                result = sum - heap.peek();
            heap.add(sum);
        }
        return result;
    }
}
