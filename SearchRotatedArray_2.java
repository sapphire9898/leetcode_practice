public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        // if the target < mid, and mid is 7. 
        // left > right; compare mid and the right ? 
        // left < right; go to left. right = mid - 1;
        
        
        // if the target > mid, and mid is 7; 
        // left > right; compare mid and the left ? find out whether we could choose the right side. 
        // left < right; go to right;left = mid + 1;
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                if (nums[mid] < nums[right]) {
                    // go to left;
                    right = mid - 1;
                }
                else {
                    if (nums[right] == target) return right;
                    right--;
                }
            }
            else if (target > nums[mid]){
                if (nums[mid] > nums[left]) {
                    // go to right
                    left = mid + 1;
                }
                else {
                    if (nums[left] == target) return left;
                    left++;
                }
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}