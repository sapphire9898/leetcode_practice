public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int step = 0, lastReach = 0, reach = 0;
        
        for (int i = 0; i <= reach && i < nums.length; i++) {
            
            if (i > lastReach) {
                lastReach = reach;
                step++;
            }
            
            reach = Math.max(reach, i + nums[i]);
        }
        
        if (reach < nums.length - 1) return 0;
        return step;
    }
}