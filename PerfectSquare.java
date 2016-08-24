public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        
        long left = 1, right = num / 2;
        long mid = 0, nums = num;
        while (left <= right) {
            mid = (right + left) / 2;
            
            if (mid * mid == nums) {
                return true;
            }
            else if (mid * mid < nums) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}