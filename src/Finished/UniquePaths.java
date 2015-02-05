package Finished;

import java.util.Arrays;

public class UniquePaths {

	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        if (m == 0 || n == 0)
            return 0;
        int[] ar = new int[n];
        Arrays.fill(ar, 1);
        for (int i = 0; i < m - 1; ++i)
            for (int j = n - 2; j >= 0; --j)
                ar[j] = ar[j + 1] + ar[j];
        return ar[0];
    }
}
