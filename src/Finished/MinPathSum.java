package Finished;

import java.util.Arrays;

public class MinPathSum {

	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[][] min = new int[grid.length][grid[0].length];
        for (int[] ar : min)
            Arrays.fill(ar, -1);
        return getMin(grid, min, 0, 0);
    }
    
    private int getMin(int[][] grid, int[][] min, int i, int j) {
        if (min[i][j] != -1)
            return min[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        int result = Integer.MAX_VALUE;
        if (i < grid.length - 1)
            result = Math.min(result, getMin(grid, min, i + 1, j));
        if (j < grid[0].length - 1)
            result = Math.min(result, getMin(grid, min, i, j + 1));
        min[i][j] = grid[i][j] + result;
        return min[i][j];
    }
}
