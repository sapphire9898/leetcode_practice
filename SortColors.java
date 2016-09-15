public class Solution {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        
        for (int i : nums) {
            if (i == 0) {
                nums[b++] = 2;
                nums[w++] = 1;
                nums[r++] = 0;
                
            }
            else if (i == 1) {
                nums[b++] = 2;
                nums[w++] = 1;
            }
            else if (i == 2) {
                nums[b++] = 2;
            }
        }
    }
}