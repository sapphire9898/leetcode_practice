public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int ind = 1;
        while (x / ind >= 10) {
            ind *= 10;
        }
        
        while (x != 0) {
            int high = x / ind;
            int low = x % 10;
            if (high != low) return false;
            x %= ind;
            x /= 10;
            ind = ind / 100;
        }
        
        return true;
    }
}