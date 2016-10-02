public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];

        // in the first round, res[i] = 1 * ... * nums[i - 1];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // in the second round, res[i] *= nums[i + 1] * ... * nums[length - 1];
        int productFromEnd = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= productFromEnd;
            productFromEnd *= nums[i];
        }
        return res;
    }
}