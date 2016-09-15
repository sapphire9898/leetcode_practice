public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return -1;
        int bigger = m > n ? m : n;
        
        double a = count(bigger, m + n - 2);
        
        double b = bigger == m ? count(1, n - 1) : count(1, m - 1);
        
        double ans = a / b;
        
        return (int) ans;
    }
    
    private double count(int left, int right) {
        
        double cnt = 1;
        for (int i = left; i <= right; i++) {
            cnt *= i;
        }
        return cnt;
    }
}