public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String curr = String.valueOf(1);
        
        for (int i = 0; i < n - 1; i++) {
            curr = helper(curr);
        }
        
        return curr;
    }
    
    
    
    
    private String helper(String str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char curr = str.charAt(0);
        for (int i = 0; i < str.length(); ) {
        
            while (i < str.length() && str.charAt(i) == curr) {
                i++;
                cnt++;
            }
            
            sb.append(cnt);
            sb.append(curr);
            
            if (i < str.length()) {
                curr = str.charAt(i);
                cnt = 0;
            }
        }
        
        return sb.toString();
        
    }
    
    
    
}