public class Solution {
    public int titleToNumber(String s) {
        
        if (s == null || s.length() == 0) return 0;
        int  sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int Adis = (int)(s.charAt(i) - 'A' + 1);
            sum = sum * 26 + Adis;
        }
        return sum;
    }
}