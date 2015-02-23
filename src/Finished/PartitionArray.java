package Finished;

import java.util.ArrayList;

public class PartitionArray {

	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    if (nums == null || nums.size() == 0)
	        return 0;
	    int mid = 0;
	    for (int i = 0; i < nums.size(); ++i) {
	        if (nums.get(i) < k)
	            swap(nums, i, mid++);
	    }
	    return mid;
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
}
