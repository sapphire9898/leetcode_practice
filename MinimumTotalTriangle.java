public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        for (int j = n - 2; j >= 0; j--) {
            // update from the second line from the bottom to the first line. 
            for (int i = 0; i <= j; i++) { 
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(j).get(i);
                // use 0,1 to update 0, use 1,2 to update 1, use 2,3 to update 2. 
            }
        }
        
        return dp[0];
    }
}