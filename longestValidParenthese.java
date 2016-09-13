public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length();
        
        int[] dp = new int[len + 1];// 0 to len - 1;
        
        dp[0] = 0;
    
        int value = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                
                // then , dp[i] represents the values ending with i-1 element. and the number is stored in dp[i]. the element before the valid parenthese is indexed i - 1 - dp[i]
                // the valid parentheses for i - 2 - dp[i] is stored in dp[i - 1 - dp[i]];
                // update the dp[i + 1] the value is defined as the max value ending with i element (from 0)
                if (i - 1 - dp[i] >= 0 && s.charAt(i - 1 - dp[i]) == '(') {
                    dp[i + 1] = dp[i - 1 - dp[i]] + dp[i] + 2;
                    value = Math.max(value, dp[i + 1]);
                }
            }
        }
        return value;
    }
}