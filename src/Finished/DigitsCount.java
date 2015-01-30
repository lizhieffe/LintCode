package Finished;

public class DigitsCount {

	/*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if (k < 0 || n < 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; ++i)
            dp[i] = -1;
        int result = 0;
        for (int i = 0; i <= n; ++i) {
            result += getCount(k, i, dp);
        }
        return result;
    }
    
    private int getCount(int k, int val, int[] dp) {
        if (dp[val] != -1)
            return dp[val];
        if (val == 0 && k == 0)
            return 1;
        int result = 0;
        while (val > 0) {
            if (val % 10 == k)
                ++result;
            val = val / 10;
        }
        dp[val] = result;
        return result;
    }
}
