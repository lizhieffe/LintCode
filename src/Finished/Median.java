package Finished;

import org.junit.Test;

public class Median {

	/**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        return findKthLargest(nums, 0, nums.length - 1, (nums.length - 1) / 2);
    }
    
    private int findKthLargest(int[] nums, int beg, int end, int k) {
        int pivot = nums[end];
        int mid = 0;
        for (int i = 0; i < end - beg; ++i) {
            if (nums[i + beg] < pivot)
                swap(nums, i + beg, beg + (mid++));
        }
        swap(nums, mid + beg, end);
        if (k == mid)
            return pivot;
        else if (k < mid)
            return findKthLargest(nums, beg, mid - 1 + beg, k);
        else
            return findKthLargest(nums, mid + 1 + beg, end, k - mid - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    @Test
    public void tc01() {
    	int[] nums = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
    	int result = median(nums);
    	System.out.println(result);
    }
}
