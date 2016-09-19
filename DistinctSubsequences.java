public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return 0;
        
        int m = s.length();
        int n = t.length();
        
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 1; j <= n; j++) {
            for (int i = j; i <= m; i++) {
                
                int tend = j - 1;
                int send = i - 1; 
                // send is the last alphabet in s for t to match. the start is 0. the length is send + 1. 
                
                if (s.charAt(send) == t.charAt(tend)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }
        
        return dp[m][n];
        
    }
}