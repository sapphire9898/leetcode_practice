public class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums == null || nums.length <= 1) return true;
        int reach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (reach <= i && nums[i] == 0) return false; 
            
            reach = Math.max(reach, i + nums[i]);
            
            if (reach >= nums.length - 1) return true;
            
        }
        return false;// if see all of the elmements, the reach is less than len - 1, then false;
    }
}