public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        if (k == 0) return;
        
        // nums.length - k to nums.length - 1;
        // 0 to nums.length - k - 1;
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
        
    }
    
    
    private void reverse(int[] nums, int i, int j) {
        int left = i, right = j;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        
        
    }
    
}