public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return nums[left] > nums[right] ? left : right;
    }
}