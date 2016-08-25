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