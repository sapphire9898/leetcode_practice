public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.equals("")) return "";
        int maxV = 0;
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
           while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
               left--;
               right++;
           } 
           if (maxV < right - left - 1) {
               start = left + 1;
               end = right - 1;
               maxV = right - left - 1;
           }
           
           left = i;
           right = i + 1;
           while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
               left--;
               right++;
           }
           if (maxV < right - left - 1) {
               start = left + 1;
               end = right - 1;
               maxV = right - left - 1;
           }
           
        }
        return s.substring(start, end + 1);
    }
}


//Attention : Do not try to copy the string during the process, it will TLE;
//ATTENTION:  pay attention to the indexes