public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        
        int count = t.length();
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int start = 0, end = 0, min = Integer.MAX_VALUE, head = 0;
        
        
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (min > end - start) {
                    min = end - start;
                    head = start;
                 }
                if (map[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
        
    }
}