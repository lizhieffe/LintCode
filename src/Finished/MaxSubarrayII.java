package Finished;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MaxSubarrayII {
	/**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() < 2)
            return 0;
        int[] leftMax = new int[nums.size()];
        int[] rightMax = new int[nums.size()];
        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        int i = 0;
        for (Integer num : nums) {
            sum += num;
            if (sum - min > max) {
                max = sum - min;
            }
            if (sum < min)
                min = sum;
            leftMax[i++] = max;
        }
        max = Integer.MIN_VALUE;
        min = 0;
        sum = 0;
        for (int j = nums.size() - 1; j >= 0; --j) {
            int num = nums.get(j);
            sum += num;
            if (sum - min > max) {
                max = sum - min;
            }
            if (sum < min)
                min = sum;
            rightMax[j] = max;
        }
        int result = Integer.MIN_VALUE;
        for (int j = 0; j < nums.size() - 1; ++j)
            result = Math.max(result, leftMax[j] + rightMax[j + 1]);
        return result;
    }
    
    
    @Test
    public void test01() {
    	Integer[] array = {1,3,-1,2,-1,2};
    	ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(array));
    	new MaxSubarrayII().maxTwoSubArrays(nums);
    }
}
