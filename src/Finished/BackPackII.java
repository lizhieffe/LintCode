package Finished;

import java.util.Arrays;

public class BackPackII {

	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (m <= 0 || A.length <= 0 || V.length != A.length)
            return 0;
        int[][] dp = new int[A.length][m + 1];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);
        int result = 0;
        for (int i = 0; i < A.length; ++i)
            result = Math.max(find(m, A, V, i, dp), result);
        return result;
    }
    
    private int find(int m, int A[], int V[], int beg, int[][] dp) {
        if (m <= 0 || beg >= A.length)
            return 0;
        if (dp[beg][m] != -1)
            return dp[beg][m];
        if (m < A[beg]) {
            dp[beg][m] = 0;
            return 0;
        }
        int result = 0;
        for (int i = beg + 1; i < A.length; ++i)
            result = Math.max(result, find(m - A[beg], A, V, i, dp));
        result += V[beg];
        dp[beg][m] = result;
        return result;
    }
}
