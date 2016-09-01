public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum < target) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    return target;
                }
            }
        }
        
        return ans;
    }
}