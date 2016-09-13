public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                }
                else {
                    if (nums[right] != target) right--;
                    else return right;
                }
            }
            else if (target < nums[mid]){
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                }
                else {
                    if (nums[left] != target) left++;
                    else return left;
                }
            }
            else {
                return mid;
            }
        }
        
        if (nums[left] == target) return left;
        else if (nums[right] == target) return right;
        return -1;
        
        
    }
}