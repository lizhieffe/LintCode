package Finished;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n < k || n <= 0)
		    return result;
		return combine(1, n, k);
    }
    
    private List<List<Integer>> combine(int beg, int end, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 1) {
            for (int i = beg; i <= end; ++i) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(i);
                result.add(solution);
            }
            return result;
        }
        for (int i = beg; i <= end - k + 1; ++i) {
            List<List<Integer>> solution = combine(i + 1, end, k - 1);
            addOne(i, solution);
            result.addAll(solution);
        }
        return result;
    }
    
    private void addOne(int val, List<List<Integer>> solution) {
        for (List<Integer> list : solution)
            list.add(0, val);
    }
}
