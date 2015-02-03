package Finished;

import java.util.ArrayList;

public class Permutations {

	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0)
            return result;
        for (int i = 0; i < nums.size(); ++i) {
            result.addAll(permute(nums, i));
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums.size() == 1) {
            ArrayList<Integer> solution = new ArrayList<Integer>();
            solution.add(nums.get(0));
            result.add(solution);
            return result;
        }
        int val = nums.remove(index);
        for (int i = 0; i < nums.size(); ++i) {
            ArrayList<ArrayList<Integer>> solution = permute(nums, i);
            for (ArrayList<Integer> list : solution) {
                list.add(0, val);
            }
            result.addAll(solution);
        }
        nums.add(index, val);
        return result;
    }
}
