public class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        
        
        int[] dp_less = new int[nums.length]; // from 1 to length - 2; for the ith element, the smallest element is from 0 to i - 1, 
        
        int[] dp_large = new int[nums.length];// from length - 2 to 1; for the ith element, the largest element is from length - 1 to i + 1; 
        
        
        dp_less[1] = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            dp_less[i] = Math.min(dp_less[i - 1], nums[i - 1]);
        }
        dp_large[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 1; i--) {
            dp_large[i] = Math.max(dp_large[i + 1], nums[i + 1]);
        }
        
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > dp_less[i] && nums[i] < dp_large[i]) {
                return true;
            }
        }
            return false;
            
        
        
    }
}