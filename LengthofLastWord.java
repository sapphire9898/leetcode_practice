public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int i = s.length() - 1;
        
        while (i >= 0 && s.charAt(i) == ' ') i--; 
        
        
        int ans = 0;
        while (i >= 0) {
            
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                ans++;
            }
            else break;
            i--;
        }
        return ans;
        
    }
}