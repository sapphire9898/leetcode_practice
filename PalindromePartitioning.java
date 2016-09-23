public class Solution {
    public List<List<String>> partition(String s) {
        
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        helper(res, temp, s, 0, generate(s));
    
        return res;
        
    }
    
    
    private void helper(List<List<String>> res, List<String> temp, String s, int start, boolean[][] dp) {
        if (start > s.length()) return;
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        
        
            for (int j = start; j < s.length(); j++) {
                if (dp[start][j]) {
                    temp.add(s.substring(start, j + 1));
                    helper(res, temp, s, j + 1, dp);
                    temp.remove(temp.size() - 1);
                }
            }
            
        
    }
    
    private boolean[][] generate(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
            int left = i - 1, right = i + 1;
            while (left >= 0 && right <= m - 1 && s.charAt(left) == s.charAt(right)) {
                dp[left][right] = true;
                left--;
                right++;
            }
            
            if (i + 1 <= m - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right <= m - 1 && s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = true;
                    left--;
                    right++;
                }
            }
        }
        return dp;
    }
    
}