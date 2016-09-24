public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] mindp = new int[nums.length]; // mindp[i] represents the min product from nums[0, i];
        int[] maxdp = new int[nums.length];
        
        int maxValue = nums[0];
        mindp[0] = nums[0];
        maxdp[0] = nums[0];
        
        
        
        for (int i = 1; i < nums.length; i++) {
            mindp[i] = Math.min(Math.min(mindp[i - 1] * nums[i] , maxdp[i - 1] * nums[i]), nums[i]);
            maxdp[i] = Math.max(Math.max(mindp[i - 1] * nums[i], maxdp[i - 1] * nums[i]), nums[i]);
            
            maxValue = Math.max(maxdp[i], maxValue);
        }
        return maxValue;   
    }
}