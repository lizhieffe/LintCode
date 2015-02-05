package Finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationSum {

	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return result;
        Arrays.sort(candidates);
        int last = candidates[0];
        int j = 1;
        for (int i = 1; i < candidates.length; ++i) {
            if (candidates[i] != last) {
                candidates[j++] = candidates[i];
                last = candidates[i];
            }
        }
        int length = j;
        List<Integer> solution = new ArrayList<Integer>();
        for (int i = 0; i < length; ++i)
            find(candidates, i, length, target, solution, result);
        return result;
    }
    
    private void find(int[] candidates, int beg, int length, int target,
            List<Integer> solution, List<List<Integer>> result) {
        if (beg >= length)
            return;
        if (candidates[beg] > target)
            return;
        List<Integer> tmpSolution = new ArrayList<Integer>(solution);
        tmpSolution.add(candidates[beg]);
        if (target - candidates[beg] == 0) {
            result.add(tmpSolution);
            return;
        }
        for (int i = beg; i < length; ++i)
            find(candidates, i, length, target - candidates[beg], tmpSolution, result);
    }
    
    @Test
    public void tc01() {
    	int[] candidates = {1,2};
    	int target = 2;
    	List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
    	System.out.println();
    }
}
