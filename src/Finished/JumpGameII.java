package Finished;

import java.util.Arrays;

public class JumpGameII {

	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length < 2)
            return 0;
        int[] dp = new int[A.length];
        Arrays.fill(dp, -1);
        dp[dp.length - 1] = 0;
        for (int i = A.length - 1; i >= 0; --i)
            getJump(A, dp, i);
        return getJump(A, dp, 0);
    }
    
    private int getJump(int[] A, int[] dp, int beg) {
        if (dp[beg] != -1)
            return dp[beg];
        int result = Integer.MAX_VALUE;
        if (A[beg] == 0)
            result = 0;
        else if (A[beg] >= A.length - beg - 1)
            result = 1;
        else {
            for (int i = 1; i <= A[beg]; ++i) {
                result = Math.min(result, 1 + getJump(A, dp, beg + i));
                if (result == 2)
                    break;
            }
        }
        dp[beg] = result;
        return result;
    }
}
