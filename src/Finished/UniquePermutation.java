package Finished;

import java.util.ArrayList;
import java.util.Collections;

public class UniquePermutation {

	/**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0)
            return result;
        Collections.sort(nums);
        return find(nums);
    }
    
    private ArrayList<ArrayList<Integer>> find(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums.size() == 1) {
            result.add(new ArrayList<Integer>(nums));
            return result;
        }
        int last = nums.get(0) + 1;
        for (int i = 0; i < nums.size(); ++i) {
            if (last != nums.get(i)) {
                last = nums.remove(i);
                result.addAll(combine(last, find(nums)));
                nums.add(i, last);
            }
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> combine(int val, ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> curr : list)
            curr.add(0, val);
        return list;
    }
}
