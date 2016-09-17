public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        
        int[] dp = new int[n + 1];// dp[i] represent the number of ways of the s[0, ..., n - 1] 
        
        dp[0] = 1;
        dp[1] = s.charAt(0) > '0' && s.charAt(0) <= '9' ? 1 : 0;
        
        for (int i = 2; i < n + 1; i++) {
            dp[i] = 0;
            if (s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 1];
            }
            int lasttwo = Integer.valueOf(s.substring(i - 2, i));
            if (lasttwo >= 10 && lasttwo <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
        
    }
}