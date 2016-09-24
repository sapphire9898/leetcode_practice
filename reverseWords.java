public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0;) {
            if (s.charAt(i) != ' ') {
                int j = i - 1;
                while (j >= 0 && s.charAt(j) != ' ') {
                    j--;
                }
                sb.append(s.substring(j + 1, i + 1) + " ");
                i = j;
            }
            else i--;
        }
        String res = sb.toString();
        return (res == null || res.length() == 0) ? "" : res.substring(0, res.length() - 1);
    }
}