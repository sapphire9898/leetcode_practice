public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return false;
        if (s == null) return false;
        boolean[] dp = new boolean[s.length()];
        // dp[i] represents wordDict can represent s[0, i];

        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length() - 1];
        
        
    }
    
}