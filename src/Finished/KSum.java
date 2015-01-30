package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class KSum {
	/**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int A[], int k, int target) {
        // write your code here
        if (A == null || A.length == 0 || k <= 0 || target <= 0)
            return 0;
        int[][][] dp = new int[A.length][k + 1][target + 1];
        for (int i = 0; i < dp.length; ++i)
            for (int j = 0; j < dp[0].length; ++j)
                for (int m = 0; m < dp[0][0].length; ++m)
                    dp[i][j][m] = -1;
        int result = 0;
        for (int i = 0; i < A.length - k + 1; ++i) {
            result += find(A, i, k, target, dp);
        }
        return result;
    }
    
    private int find(int A[], int beg, int k, int target, int[][][] dp) {
        if (target < A[beg])
            return 0;
        
        if (dp[beg][k][target] != -1)
            return dp[beg][k][target];
        int result = 0;
        for (int i = beg + 1; i < A.length - k + 2; ++i) {
        	if (k == 1) {
        		if (target - A[beg] == 0)
        			result = 1;
        		else
        			result = 0;
        	}
        	else
        		result += find(A, i, k - 1, target - A[beg], dp);
        }
        dp[beg][k][target] = result;
        return result;
    }
    
    @Test
    public void tc01() {
    	int[] A = {1,2,3,4};
    	int k = 2;
    	int target = 5;
    	int result = new KSum().kSum(A, k, target);
    	assertTrue(result == 2);
    }
}
