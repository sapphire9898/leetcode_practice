public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = reverse(n, i, 32 - i - 1);
        }
        return n;
    }
    
    private int reverse(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if ((a ^ b) == 1) {
              n ^= (1 << j) | (1 << i);
        } 
        return n;
    }
}