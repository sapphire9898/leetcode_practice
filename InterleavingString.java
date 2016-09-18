public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0) && (s3 == null || s3.length() == 0)) return true;
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        if (s2 == null || s2.length() == 0) return s1.equals(s3);
        
        
        if (!isValid(s1 + s2, s3)) return false;
        
        int m = s1.length(), n = s2.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[i][j] represents whether s3[0, i + j - 1] is the interleaving of s1[0, i - 1] and s2[0, j - 1]; dp[0][0] = true;
        
        dp[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i + j - 1 is from s1 or s2. 
                dp[i][j] = false;
                
                dp[i][j] |= dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1); 
                
                dp[i][j] |= dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                
            }
        }
        return dp[m][n];
        
    }
    
    private boolean isValid(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }

    
}