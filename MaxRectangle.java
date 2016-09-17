public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == '1' ? dp[i - 1][j] + 1 : 0;
            }
        }
        
        int maxValue = 0;
        for (int i = 0;i < m; i++) {
            maxValue = Math.max(maxValue, find(dp[i]));
        }
        return maxValue;
    }
    
    
    private int find(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, max = 0;
        while (i < nums.length) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int p = stack.pop();
                int h = nums[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
        }
        
        
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = nums[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }
        return max;
    }
    
    
    
}