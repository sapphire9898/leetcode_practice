public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int[] can_dp = new int[ratings.length];
        can_dp[0] = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                can_dp[i + 1] = can_dp[i] + 1;
            }
            else can_dp[i + 1] = 1;
        }
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i] < ratings[i - 1]) {
                can_dp[i - 1] = Math.max(can_dp[i] + 1, can_dp[i - 1]);
            }
        }
        int sum = 0;
        for (int num : can_dp) {
            sum += num;
        }
        return sum;
        
    }
}


public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        
        int[] dp1 = new int[ratings.length];
        int[] dp2 = new int[ratings.length];
        
        dp1[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
            else dp1[i] = 1;
        }
        
        dp2[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
            else dp2[i] = 1;
        }
        
        
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(dp1[i], dp2[i]);
        }
        return sum;
    }
}