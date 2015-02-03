package Finished;

import java.util.ArrayList;

import org.junit.Test;

public class MergeSortedArray {

	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || B == null)
            return result;
        if (A.size() < B.size()) {
            ArrayList<Integer> tmp = A;
            A = B;
            B = tmp;
        }
        result.addAll(A);
        int i = 0, j = 0;
        while (i < result.size() && j < B.size()) {
            if (result.get(i) >= B.get(j)) {
                result.add(i++, B.get(j++));
            }
            else
            	++i;
        }
        if (j >= B.size())
            return result;
        else {
            while (j < B.size())
                result.add(result.size(), B.get(j++));
            return result;
        }
    }
    
    @Test
    public void tc01() {
    	ArrayList<Integer> A = new ArrayList<Integer>();
    	A.add(7);
    	ArrayList<Integer> B = new ArrayList<Integer>();
    	B.add(5);
    	B.add(7);
    	ArrayList<Integer> result = new MergeSortedArray().mergeSortedArray(A, B);
    	System.out.println(result);
    }
}
