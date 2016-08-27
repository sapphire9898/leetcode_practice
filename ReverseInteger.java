public class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }
        long value = isNegative ? -x : x;
        long sum = 0;
        while (value > 0) {
            sum = sum * 10 + value % 10;
            value /= 10;
        }
        if (isNegative && sum >= (long)(Integer.MAX_VALUE) + 1) {
            return 0;
        }
        if (sum >= Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? -(int) sum : (int)sum;
    }
}