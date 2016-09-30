public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        
        
        int maxValue = dp[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            
            maxValue = Math.max(maxValue, dp[i][0]);
        }
        
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            maxValue = Math.max(maxValue, dp[0][i]);
        }
       
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxValue = Math.max(dp[i][j], maxValue);
                }
            }
        }
        return maxValue * maxValue;
        
    }
}