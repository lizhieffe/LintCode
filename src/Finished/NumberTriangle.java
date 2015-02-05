package Finished;

import java.util.ArrayList;

public class NumberTriangle {

	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null)
            return 0;
        int[] ar = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); ++i)
            ar[i] = triangle.get(triangle.size() - 1).get(i);
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j)
                ar[j] = triangle.get(i).get(j) + Math.min(ar[j], ar[j + 1]);
        }
        return ar[0];
    }
}
