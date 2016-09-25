public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        
        
        
        int n = prices.length;
        if (k >= n / 2) return quickSolve(prices);
        
        int[][] dp = new int[k + 1][n];
        
        //dp[i][j] represents the max profit with completing i transactions from prices[0, j]; j is the last sell date.  
        
        //dp[0][0] = 0; dp[0][j] = 0; dp[i][0] = 0;
        
        // 1) when transaction at ith prices, dp[i][j] = Math.max{prices[j] - prices[m] + dp[i - 1][m]}; need to complete the tracsaction before and include the mth day. 
        
        // 2) when not transaction at ith day. dp[i][j] = dp[i][j - 1];
        
        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= k; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tempMax + prices[j]);
                tempMax = Math.max(dp[i - 1][j] - prices[j], tempMax); // for the next use. 
                
                // for (int lm = 0; lm <= j - 1; lm++) {
                //     dp[i][j] = Math.max(prices[j] - prices[lm] + dp[i - 1][lm], dp[i][j]);
                // }
            }
        }
        
        return dp[k][n - 1];
        
        
    }
    
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}