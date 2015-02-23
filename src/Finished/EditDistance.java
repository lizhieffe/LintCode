package Finished;

import java.util.Arrays;

public class EditDistance {

	/**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word2 == null)
            return 0;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length][c2.length];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);
        return minDistanceHelper(c1, 0, c2, 0, dp);
    }
    
    private int minDistanceHelper(char[] c1, int beg1, char[] c2, int beg2, int[][] dp) {
        if (beg1 >= c1.length)
            return c2.length - beg2;
        if (beg2 >= c2.length)
            return c1.length - beg1;
        if (dp[beg1][beg2] != -1)
            return dp[beg1][beg2];
        int result;
        if (c1[beg1] == c2[beg2])
            result = minDistanceHelper(c1, beg1 + 1, c2, beg2 + 1, dp);
        else {
            int tmp = Math.min(minDistanceHelper(c1, beg1 + 1, c2, beg2, dp)
                    , minDistanceHelper(c1, beg1, c2, beg2 + 1, dp));
            result = 1 + Math.min(minDistanceHelper(c1, beg1 + 1, c2, beg2 + 1, dp)
                    , tmp);
            
        }
        dp[beg1][beg2] = result;
        return result;
    }
}
