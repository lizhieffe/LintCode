package Finished;

import java.util.ArrayList;

public class KSumII {

	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null || A.length < k || k <= 0)
            return result;
        ArrayList<Integer> solution = new ArrayList<Integer>();
        helper(A, 0, k, target, result, solution);
        return result;
    }
    
    private void helper(int[] A, int beg, int k, int target
            , ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution) {
        if (k == 0) {
            if (target == 0)
                result.add(solution);
            else
                return;
        }
        
        if (beg >= A.length)
            return;
            
        for (int i = beg; i < A.length; ++i) {
            if (A[i] <= target) {
                ArrayList<Integer> newSolution = new ArrayList<Integer>(solution);
                newSolution.add(A[i]);
                helper(A, i + 1, k - 1, target - A[i], result, newSolution);
            }
        }
    }
}
