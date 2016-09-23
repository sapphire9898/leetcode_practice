public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        
        int res = 0;
        
        for (int i = 0; i <= 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            res |= ((sum % 3) << i);
        }
        return res;
    }
}