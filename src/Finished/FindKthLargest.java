package Finished;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class FindKthLargest {
	
	Random rand = new Random(47);
    
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (k <= 0 || numbers == null || numbers.size() < k)
            return -1;
        int[] ar = new int[numbers.size()];
        for (int i = 0; i < ar.length; ++i)
            ar[i] = numbers.get(i);
        return find(ar, 0, ar.length - 1, k);
    }
    
    private int find(int[] ar, int beg, int end, int k) {
        int pivot = rand.nextInt(end - beg + 1) + beg;
        swap(ar, pivot, end);
        int mid = beg;
        for (int i = beg; i < end; ++i) {
            if (ar[i] > ar[end])
                swap(ar, i, mid++);
        }
        swap(ar, mid, end);
        if (mid - beg + 1 == k)
            return ar[mid];
        if (mid - beg + 1 > k)
            return find(ar, beg, mid - 1, k);
        else
            return find(ar, mid + 1, end, k - mid + beg - 1);
    }
    
    private void swap(int[] ar, int i, int j) {
        if (i != j) {
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }
    }
    
    @Test
    public void tc01() {
    	ArrayList<Integer> numbers = new ArrayList<Integer>();
    	numbers.add(9);
    	numbers.add(3);
    	numbers.add(2);
    	numbers.add(4);
    	numbers.add(8);
    	int k = 4;
    	int result = new FindKthLargest().kthLargestElement(k, numbers);
    	assertTrue(result == 3);
	
    }
}
