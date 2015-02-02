package Finished;

import java.util.ArrayList;
import java.util.List;

public class SingleNumIII {

	/**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0 || A.length % 2 != 0)
            return result;
        int xor = 0;
        for (int a : A)
            xor ^= a;
        if (xor == 0)
            return result;
        int rightMostOne = (xor ^ (xor - 1)) & xor;
        int first = 0;
        for (int a : A) {
            if ((a & rightMostOne) != 0)
                first ^= a;
        }
        result.add(first);
        result.add(xor ^ first);
        return result;
    }
}
