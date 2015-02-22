package Finished;

public class Heapify {
	/**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length <= 1)
            return;
        int mid = A.length / 2;
        for (int i = mid; i >= 0; --i)
            moveDown(A, i);
    }
    
    private void moveDown(int[] A, int index) {
        int left = left(index);
        int leftVal = (left < A.length) ? A[left] : Integer.MAX_VALUE;
        int right = right(index);
        int rightVal = (right < A.length) ? A[right] : Integer.MAX_VALUE;
        int next = -1;
        if (A[index] > Math.min(leftVal, rightVal)) {
            if (leftVal < rightVal) {
                next = left;
                swap(A, index, left);
            }
            else {
                next = right;
                swap(A, index, right);
            }
        }
        if (next != -1)
            moveDown(A, next);
    }
    
    private void swap (int[] A, int i, int j) {
        if (i != j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    private int left(int index) {
        return index * 2 + 1;
    }
    
    private int right(int index) {
        return index * 2 + 2;
    }
}
