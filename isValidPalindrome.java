public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                char a = (char)(c + 32);
                sb.append(a);
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        
        String str = sb.toString();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
        
    }
}