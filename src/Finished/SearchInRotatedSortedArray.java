package Finished;

public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0)
            return -1;
        return search(A, 0, A.length - 1, target);
    }
    
    private int search(int[] A, int beg, int end, int target) {
        if (end < beg)
            return -1;
        int mid = beg + (end - beg) / 2;
        if (A[beg] == target)
            return beg;
        if (A[mid] == target)
            return mid;
        if (A[end] == target)
            return end;
        if (A[beg] < A[beg]) {
            if (A[mid] > target)
                return search(A, beg, mid - 1, target);
            else
                return search(A, mid + 1, end, target);
        }
        if (A[mid] > A[beg]) {
            if (A[mid] > target && A[beg] < target)
                return search(A, beg, mid - 1, target);
            else
                return search(A, mid + 1, end, target);
        }
        else {
            if (A[mid] < target && A[end] > target)
                return search(A, mid + 1, end, target);
            else
                return search(A, beg, mid - 1, target);
        }
    }
}
