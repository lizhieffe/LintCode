package Finished;

import java.util.ArrayList;

public class SearchInsertPosition {

	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0)
            return 0;
        return searchInsert(A, 0, A.size() - 1, target);
    }
    
    private int searchInsert(ArrayList<Integer> A, int beg, int end, int target) {
        int mid = beg + (end - beg) / 2;
        if (target <= A.get(beg))
            return beg;
        else if (target < A.get(mid))
            return searchInsert(A, beg + 1, mid - 1, target);
        else if (target == A.get(mid))
            return mid;
        else if (target < A.get(end))
            return searchInsert(A, mid + 1, end - 1, target);
        else if (target == A.get(end))
            return end;
        else
            return end + 1;
    }
}
