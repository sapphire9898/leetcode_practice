public class Solution {
    public String shortestPalindrome(String s) {
        
        if (s == null || s.length() == 0) return "";
        
        
        int n = s.length();
        //create the reverse string of s.
        String reve = new StringBuilder(s).reverse().toString();
        
        
        int[] dp_reve = precompute(s + "#" + reve);
        //if (n - dp_reve[2 * n - 1] < 1) return s;
        return reve.substring(0, n - dp_reve[2 * n - 1] - 1) + s;
        
    }
    
    // the result is s_rev - Lsuffix(s_rev) + s; 
    
    // find the KMP prefix array, which also suffix. 
    
    private int[] precompute(String s) {
        int n = s.length();
        int[] dp = new int[n];
        
        
        dp[0] = 0;
        int i = 1, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                dp[i] = j;
                i++;
            }
            else {
                if (j != 0) {
                    j = dp[j - 1];// back to the point. 
                }
                else {
                    dp[i] = j; // there is no matches, move to next one.
                    i++;
                }
            }
        }
        return dp;
    }   
    
}

public class Solution {
    public String shortestPalindrome(String s) {
        String reverse_s = new StringBuilder(s).reverse().toString();
        String com = s + "*" + reverse_s;
        
        int[] p = new int[com.length()];
        
        //
        for (int i = 1; i < com.length(); i++) {
            int j = p[i - 1];
            
            while (j > 0 && com.charAt(i) != com.charAt(j)) {
                j = p[j - 1];
            }
            
            if (com.charAt(i) == com.charAt(j)) {
                p[i] = j + 1;
            }
        }
        
        
        return reverse_s.substring(0, s.length() - p[com.length() - 1]) + s;
        
    }
}