public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        
        int left = searchLeft(nums, target);// 34555555, return the first position of 5, 2
        int right = searchRight(nums, target); // 34555555, return the last position of 5, 7
        
        return new int[]{left, right};
    }
    
    
    
    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // left < target, right >= target;
            if (nums[mid] >= target) {
                right = mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        
        if (nums[left] == target) {
            return left;
        }
        else if (nums[right] == target) {
            return right;
        }
        
        return -1;
    }
    
    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2 + 1; 
            // left <= target, right > target;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] <= target) {
                left = mid;
            }
        }
        
        if (nums[right] == target) {
            return right;
        }
        else if (nums[left] == target) {
            return left;
        }
        
        return -1;
    }
}