package Finished;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class UniqueSubsets {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0)
            return result;
        Collections.sort(S);
        result = helper(S);
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (list.size() == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        int repeat = 0;
        int last = list.get(0);
        while (list.size() > 0) {
            if (last == list.get(0)) {
                ++repeat;
                list.remove(0);
            }
            else
                break;
        }
        
        ArrayList<ArrayList<Integer>> solution = helper(list);
        for (int i = 1; i <= repeat; ++i) {
            ArrayList<ArrayList<Integer>> newSolution = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> soluList : solution) {
                ArrayList<Integer> newList = new ArrayList<Integer>(soluList);
                for (int j = 1; j <= i; ++j)
                    newList.add(0, last);
                newSolution.add(newList);
            }
            result.addAll(newSolution);
        }
        result.addAll(solution);
        
        return result;
    }
    
    @Test
    public void tc01() {
    	ArrayList<Integer> S = new ArrayList<Integer>();
    	S.add(1);
    	S.add(1);
    	ArrayList<ArrayList<Integer>> result = new UniqueSubsets().subsetsWithDup(S);
    	System.out.println(result);
    }
}
