public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        // Design an algorithm to find the maximum profit. You may complete at most two transactions. 
        int n = prices.length;
        
        int[] dp1 = new int[n + 1];
        //dp1[i] represents the max profit before the ith, not include ith. 0, i - 1, at most one transaction. 
        // dp1[0] = 0; dp1[1] = 0;
        
        //  for i >= 2, dp1[i] = Math.max(prices[i - 1] - min(values from 0 to i - 2), dp1[i - 1]);
        
        
        int[] dp2 = new int[n + 1];
        //dp2[i] represents the  maxprofit after the ith, include ith, i , n - 1. at most one transaction. 
        //dp2[n] = 0, dp2[n - 1] = 0;
        
        //for i <= n - 2, dp2[i] = Math.max(max(values from i + 1 to n - 1) - prices[i], dp2[i + 1]);
        
        
        // for exapmle, [1,2]
        //  | [1,2]  dp1[0] + dp2[0] = 1;
       
        // 1 | 2   dp1[1] + dp2[1] = 0;
        
        // [1,2] |  dp1[2] + dp2[2] = 1;
        
        
        int[] minv = new int[n + 1]; // minv[i] means the min value from 0, i - 1; minv[0] = 0;
        minv[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minv[i] = Math.min(minv[i - 1], prices[i - 1]);
        }
        
        
        int[] maxv = new int[n + 1];// maxv[i] means the max value from i to n - 1; max[n] = 0; 
        maxv[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxv[i] = Math.max(maxv[i + 1], prices[i]);
        }
        
        // generate dp1;
        dp1[0] = 0;
        dp1[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp1[i] = Math.max(prices[i - 1] - minv[i - 1], dp1[i - 1]); 
        }
        
        dp2[n] = 0;
        dp2[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(maxv[i + 1] - prices[i], dp2[i + 1]);
        }
        
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i]);
        }
        return ans;
    }
}