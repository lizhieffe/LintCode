package Finished;

import java.util.ArrayList;

public class NextPermutation {
	/**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		int index = -1;
		for (int i = nums.size() - 1; i > 0; --i) {
		    if (nums.get(i) > nums.get(i - 1)) {
		        index = i;
		        break;
		    }
		}
		if (index == -1)
		    reverse(nums, 0, nums.size() - 1);
		else {
		    reverse(nums, index, nums.size() - 1);
		    int index2 = -1;
		    for (int i = index; i < nums.size(); ++i)
		        if (nums.get(index - 1) < nums.get(i)) {
		            index2 = i;
		            break;
		        }
		    swap(nums, index - 1, index2);
		}
		return nums;
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
        if (i != j) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
