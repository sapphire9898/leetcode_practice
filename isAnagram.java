public class Solution {
    public boolean isAnagram(String s, String t) {
       if (s == null && t == null) return true;
        else if (s.length() != t.length()) return false;

        int n = s.length();
        int[] num1 = new int[256];

        for (int i = 0; i < n; i++) {
            num1[s.charAt(i)]++;
            num1[t.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (num1[i] != 0) return false;
        }
        return true;
    }
}