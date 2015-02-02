package Finished;

import java.util.Arrays;

public class InterleavingString {

	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length())
            return false;
        int[][] valid = new int[s1.length() + 1][s2.length() + 1];
        for (int[] ar : valid)
            Arrays.fill(ar, -1);
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        return isInterleave(c1, 0, c2, 0, c3, valid);
    }
    
    private boolean isInterleave(char[] c1, int beg1, char[] c2, int beg2, char[] c3, int[][] valid) {
        if (valid[beg1][beg2] != -1)
            return valid[beg1][beg2] == 0 ? false : true;
        if (beg1 >= c1.length && beg2 >= c2.length)
            return true;
        boolean result = false;
        if (beg1 < c1.length && c1[beg1] == c3[beg1 + beg2])
            result = isInterleave(c1, beg1 + 1, c2, beg2, c3, valid);
        if (!result && beg2 < c2.length && c2[beg2] == c3[beg1 + beg2])
            result = isInterleave(c1, beg1, c2, beg2 + 1, c3, valid);
        if (!result)
            valid[beg1][beg2] = 0;
        else
            valid[beg1][beg2] = 1;
        return result;
    }
}
