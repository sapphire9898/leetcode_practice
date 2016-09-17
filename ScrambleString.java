public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        if (!isvalid(s1, s2)) return false;
        
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String str11 = s1.substring(0, i);
            String str12 = s1.substring(i, n);
            String str21 = s2.substring(0, i);
            String str22 = s2.substring(i, n);
            String str23 = s2.substring(0, n - i);
            String str24 = s2.substring(n - i, n);
            
            if (isScramble(str11, str21) && isScramble(str12, str22)) return true;
            if (isScramble(str11, str24) && isScramble(str12, str23)) return true;
        }
        return false;
        
        
    }
    private boolean isvalid(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < s1.length(); i++) {
            if (str1[i] != str2[i]) return false;
        }
        return true;
    }
}