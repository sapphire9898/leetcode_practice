public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp1 = new int[nums.length]; // rob from 0 to n - 2; dp1[i] represent i - 1; dp1[0] = 0;
        
        int[] dp2 = new int[nums.length]; // rob from 1 to n - 1; dp2[i] represent i; dp2[0] = 0;
        
        dp1[0] = 0;
        dp1[1] = nums[0];
        dp2[0] = 0;
        dp2[1] = nums[1];
        
        
        
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);  // represent i - 1;
            
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);// represent i;
        }
        
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
        
    }
    
    
}