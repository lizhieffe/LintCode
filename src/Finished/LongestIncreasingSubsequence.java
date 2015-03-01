package Finished;

import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSubsequence {
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[dp.length - 1] = 1;
        int result = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i)
            result = Math.max(result, helper(nums, dp, i));
        return result;
    }
    
    private int helper(int[] nums, int[] dp, int beg) {
        if (dp[beg] != -1)
            return dp[beg];
        int result = 1;
        for (int i = beg + 1; i < nums.length; ++i)
            if (nums[beg] <= nums[i])
                result = Math.max(result, helper(nums, dp, i) + 1);
        dp[beg] = result;
        return result;
    }
    
    @Test
    public void tc01() {
    	int[] nums = {9,3,6,2,7};
    	System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(nums));
    }
}
