public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // using dynamic programming. 
        
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
        }
        
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i - 1] : 0;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}