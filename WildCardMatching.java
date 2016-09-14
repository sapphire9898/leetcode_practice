public class Solution {
    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) return true;
        if ((p == null || p.length() == 0)) return false;
        
        
        
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= 1 && p.charAt(j - 1) != '*') {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
                    
                }
                else if (p.charAt(j - 1) == '*'){
                    // if (j >= 1 && i == 0) dp[i][j] = dp[i][j - 1];
                    if (i >= 0 && j >= 1) dp[i][j] = dp[i][j - 1];// "*"represents the empty element. 
                    if (i >= 1 && j >= 1) dp[i][j] |= dp[i - 1][j - 1];// "*" represents the single elmement. 
                    
                    int curr = i - 1;
                    while (curr >= 1 ) {
                        dp[i][j] |= dp[curr - 1][j - 1];
                        curr--;
                    }
                }
            }
        }
        return dp[m][n];
        
    }
}