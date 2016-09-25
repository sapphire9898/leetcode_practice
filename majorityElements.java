public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int count = 1;
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    prev = nums[i];
                    count = 1;
                }
            }
        }
        
        return prev;
        
    }
    
   
}