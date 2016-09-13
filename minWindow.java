public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        int len = t.length();
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        // map store the needed number of the characters. 
        int begin = 0, end = 0, ans = Integer.MAX_VALUE, head = 0, count = len;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - begin < ans) {
                    ans = end - begin;
                    head = begin;
                }
                // check if begin add , the count will differ or not. 
                if (map[s.charAt(begin++)]++ == 0) count++;
            }
        }
        
        return ans == Integer.MAX_VALUE ? "" : s.substring(head, head + ans);
        
        
        
    }
}