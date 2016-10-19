public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return false;
        }
        if ((s == null || s.length() == 0)) {
            return t.length() == 1;
        }
        if ((s == null) || t.length() == 0) {
            return s.length() == 1;
        }
        
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                break;
            }
            i++;
            j++;
        }
        if (helper(s, i, t, j + 1) || helper(s, i + 1, t, j + 1) || helper(s, i + 1, t, j)) return true;
        return false;

    }
    
    private boolean helper(String s, int sleft, String t, int tleft) {
        if (sleft == s.length() && t.length() == tleft) {
            return true;
        }
        while (sleft < s.length() && tleft < t.length()) {
            if (s.charAt(sleft) != t.charAt(tleft)) {
                return false;
            }
            sleft++;
            tleft++;
        }
        return sleft == s.length() && tleft == t.length();
    }
}