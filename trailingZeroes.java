public class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        long seed = 5;
        while (n >= seed * 5) {
            seed *= 5;
        }
        int sum = 0;
        while (seed >= 5) {
            sum += n / seed;
            seed /= 5;
        }
        return sum;
    }
}