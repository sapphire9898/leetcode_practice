public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        
        int[] minv = new int[n];
        int[] maxv = new int[n];
        
        minv[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            minv[i] = Math.min(minv[i - 1], prices[i - 1]);
        }
        
        maxv[n - 1] = prices[prices.length - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxv[i] = Math.max(maxv[i + 1], prices[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxv[i] - minv[i]);
        }
        return res;
    }
}