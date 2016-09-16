public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return true;
            else if (target < nums[mid]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                }
                else {
                    if (target == nums[right]) {
                        return true;
                    }
                    else right--;
                }
            }
            else {
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                }
                else {
                    if (target == nums[left]) {
                        return true;
                    }
                    else left++;
                }
            }
        }
        
        if (nums[left] == target || nums[right] == target) return true;
        return false;
        
        
        
    }
}