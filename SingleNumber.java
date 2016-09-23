public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int a = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            a ^= nums[i];
        }
        return a;
    }
}