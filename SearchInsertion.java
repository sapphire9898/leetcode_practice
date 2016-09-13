public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
                
            }
            else {
                right = mid - 1;
            }
        }
        
        
        if (target <= nums[left]) {
            return left;
        }
        else if (target > nums[right]) {
            return right + 1;
        }
        else {
            return right;
        }
    }
}