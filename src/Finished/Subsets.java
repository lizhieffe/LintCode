package Finished;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (S == null || S.size() == 0)
            return result;
        Collections.sort(S);
        for (Integer i : S) {
            ArrayList<ArrayList<Integer>> addition = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : result) {
                addition.add(new ArrayList<Integer>(list));
                list.add(i);
            }
            result.addAll(addition);
        }
        return result;
    }
}
