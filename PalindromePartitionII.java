public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        int[] count = new int[s.length() + 1];
        //count[i] represent the minCut for s(0,.., i - 1);
        boolean[][] dp = helper(s);
        
        count[0] = -1;
        count[1] = 0;
        
        for (int i = 2; i <= s.length(); i++) {
            count[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j][i - 1]) {
                    count[i] = Math.min(count[i], count[j] + 1);
                }
            }
        }
        
        return count[s.length()];
        
    }
    
    
    private boolean[][] helper(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
                dp[left][right] = true;
                left--;
                right++;
            }
            
            if (i + 1 <= n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right <= n - 1 && s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = true;
                    left--;
                    right++;
                }
            }
        }
        return dp;
    }
    
}