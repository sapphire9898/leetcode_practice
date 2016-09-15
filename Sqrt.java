public class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0 || x == 1) return x;
        
        long start = 1, end = (int) x;
        long mid = 1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)(mid);
            }
            else if (mid * mid > x) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return (int)(start);
    }
}