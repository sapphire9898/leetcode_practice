public class Solution {
    
    public int totalNQueens(int n) {
        int[] nums = new int[n];
        int[] ans = new int[1];
        
        generateList(nums, n, 0, ans);
        return ans[0];
    }
    
    private void generateList(int[] nums, int n, int index, int[] ans) {
        if (n == index) {
            ans[0]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(nums, index, i)) {
                nums[index] = i;
                generateList(nums, n, index + 1, ans);
                nums[index] = 0;
            }
        }
    }
    
    private boolean isValid(int[] nums, int rownumber, int colnumber) {
        for (int i = 0; i < rownumber; i++) {
            if (nums[i] == colnumber) return false;
            if (Math.abs(i - rownumber) == Math.abs(nums[i] - colnumber)) return false;
        }
        return true;
    }
}