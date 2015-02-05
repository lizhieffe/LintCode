package Finished;

import java.util.ArrayList;

public class MinSubarray {

	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0)
            return 0;
        int max = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (Integer num : nums) {
            sum += num;
            result = Math.min(result, sum - max);
            max = Math.max(max, sum);
        }
        return result;
    }
}
