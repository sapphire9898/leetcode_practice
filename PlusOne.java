public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }
        
        int cnt = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            cnt = sum / 10;
            if (cnt == 0) return digits;
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = cnt;
        
        for (int i = 1; i < digits.length + 1; i++) {
            res[i] = digits[i - 1];
        }
        return res;
        
    }
}