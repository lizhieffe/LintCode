package Finished;

import java.util.Arrays;

public class ParlindromePartitionII {
	/**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() <= 1)
            return 0;
        int[][] isPalindrome = new int[s.length()][s.length()];
        for (int[] ar : isPalindrome)
            Arrays.fill(ar, -1);
        int[] min = new int[s.length()];
        Arrays.fill(min, -1);
        char[] c = s.toCharArray();
        return helper(c, 0, isPalindrome, min);
    }
    
    private int helper(char[] c, int beg, int[][] isPalindrome, int[] min) {
        if (beg >= c.length - 1)
            return 0;
        if (min[beg] != -1)
            return min[beg];
        if (isPalindrome(c, beg, c.length - 1, isPalindrome))
            return 0;
        int result = Integer.MAX_VALUE;
        for (int i = beg + 1; i < c.length; ++i) {
            if (isPalindrome(c, beg, i - 1, isPalindrome))
                result = Math.min(result, 1 + helper(c, i, isPalindrome, min));
        }
        min[beg] = result;
        return result;
    }
    
    private boolean isPalindrome(char[] c, int beg, int end, int[][] isPalindrome) {
        if (beg >= end)
            return true;
        if (isPalindrome[beg][end] != -1)
            return isPalindrome[beg][end] == 1 ? true : false;
        boolean result = false;
        if (c[beg] != c[end])
            result = false;
        else
            result = isPalindrome(c, beg + 1, end - 1, isPalindrome);
        isPalindrome[beg][end] = (result == true) ? 1 : 0;
        return result;
    }
}
