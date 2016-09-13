public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        while (left + 1 < height.length && height[left] <= height[left + 1]) left++;
        while (right - 1 >= 0 && height[right] <= height[right - 1]) right--;
        
        if (left >= right) return 0;
        
        int higher_left = height[left];
        int higher_right = height[right];
        int sum = 0;
        while (left < right) {
            if (higher_left <= higher_right) {
                // update the left;
                left++;
                if (height[left] > higher_left) {
                    higher_left = height[left];
                }
                else {
                    sum += higher_left - height[left];
                }
            }
            else {
                right--;
                if (height[right] > higher_right) {
                    higher_right = height[right];
                }
                else {
                    sum += higher_right - height[right];
                }
                
            }
        }
        return sum;
        
    }
}