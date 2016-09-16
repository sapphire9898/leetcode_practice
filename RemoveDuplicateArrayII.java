public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) return nums.length;
        
        
        int currIndex = 1, lastvalue = nums[0], time = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastvalue) {
                nums[currIndex++] = nums[i];
                lastvalue = nums[i];
                time = 0;
            }
            else {
                time++;
                if (time <= 1){
                    nums[currIndex++] = nums[i];
                }
            }
        }
        
        return currIndex;
    }
}