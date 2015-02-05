package Finished;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DistinctSubsequences {

	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null || S.length() < T.length())
            return 0;
        int[][] dp = new int[S.length()][T.length()];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);
        return find(S, 0, T, 0, dp);
    }
    
    private int find(String S, int beg1, String T, int beg2, int[][] dp) {
        if (beg2 >= T.length())
            return 1;
        if (S.length() - beg1 < T.length() - beg2)
            return 0;
        if (dp[beg1][beg2] != -1)
            return dp[beg1][beg2];
        int result = 0;
        for (int i = beg1; i < S.length() - (T.length() - beg2) + 1; ++i)
            if (S.charAt(i) == T.charAt(beg2))
                result += find(S, i + 1, T, beg2 + 1, dp);
        dp[beg1][beg2] = result;
        return result;
    }
    
    @Test
    public void tc01() {
    	String S = "aacaacca";
    	String T = "ca";
    	int result = new DistinctSubsequences().numDistinct(S, T);
    	assertEquals(result, 5);
    }
}
