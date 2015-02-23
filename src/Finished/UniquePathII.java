package Finished;

public class UniquePathII {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = obstacleGrid.length - 1; i >= 0; --i) {
            for (int j = obstacleGrid[0].length - 1; j >= 0; --j) {
                if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1)
                    dp[j] = 1;
                else {
                    if (obstacleGrid[i][j] == 1)
                        dp[j] = 0;
                    else if (j < obstacleGrid[0].length - 1)
                        dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
