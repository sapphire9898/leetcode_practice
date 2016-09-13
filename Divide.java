public class Solution {
    public int divide(int dividend, int divisor) {
        // dividend / divisor;
        if (divisor == 0) return Integer.MAX_VALUE;
        
        if (divisor==-1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        
        
        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNegative = true;
        }
        
        long dend =  Math.abs((long)dividend);
        long dsor = Math.abs((long)divisor);
        
        
        int ans = 0;
        while (dend >= dsor) {
            int num = 0;
            while (dend >= (dsor << num)) {
                num++;
            }
            ans += (1 << (num - 1));
            dend -= (dsor << (num - 1));
        }
        
        return isNegative ? -ans : ans;
        
        
    }
}