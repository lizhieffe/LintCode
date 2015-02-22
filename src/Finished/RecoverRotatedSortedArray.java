package Finished;

import java.util.ArrayList;
import java.util.List;

public class RecoverRotatedSortedArray {
	/**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() <= 1)
            return;
        int mid = findMid(nums);
        if (mid < 0)
            return;
        reverse(nums, 0, mid - 1);
        reverse(nums, mid, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    
    private int findMid(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; ++i)
            if (nums.get(i) > nums.get(i + 1))
                return i + 1;
        return -1;
    }
    
    private void reverse(List<Integer> nums, int beg, int end) {
        while (beg < end) {
            int tmp = nums.get(beg);
            nums.set(beg, nums.get(end));
            nums.set(end, tmp);
            ++beg;
            --end;
        }
    }
}
