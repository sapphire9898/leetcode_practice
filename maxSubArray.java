public class Solution {
    public int maxSubArray(int[] nums) {
        // two pointers. 
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        int max = nums[0], curr = nums[0];
        
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (curr < 0) curr = 0; // curr store the number has the value. 
            curr += nums[i];
            
            dp[i] = Math.max(dp[i - 1], curr);
            max = Math.max(dp[i], max);
        }
        
        return max;
    }
}