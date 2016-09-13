public class Solution {
    public boolean isMatch(String s, String p) {
        
        
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        
        int m = s.length(), n = p.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        //the dp[i][j] represents whether s[0 : i - 1] and p[0 : j - 1] is matched. 
        
        
        // if p[j - 1] != . && p[j - 1] != *, then dp[i][j] = dp[i - 1][j - 1] && s[i - 1] == p[j - 1];
        // if p[j - 1] = '.', then dp[i][j] = dp[i - 1][j - 1];
        
        //if p[j - 1] = '*', 
        // 1. match zero element. then dp[i][j] = dp[i][j - 2];
        // 2. match one element, then dp[i][j] = dp[i][j - 1];
        // 3. match two or more elements, dp[i][j] = dp[i - 1][j] && (p[j - 2] == '.' || s[i - 1] == p[j - 2])
        
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    }
                }
                else if (j > 1) {
                    
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1]; // match for zero or one element. 
                    
                        if (i > 0) dp[i][j] |= dp[i - 1][j] && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2));
                    
                }
                
            }
        }
        return dp[m][n];
        
    }
}