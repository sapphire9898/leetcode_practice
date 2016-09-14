public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 1) return new int[0][0];
        
        
        int[][] res = new int[n][n];
        
        int rowbegin = 0, rowend = n - 1, colbegin = 0, colend = n - 1;
        
        int k = 1;
        
        while (rowbegin <= rowend && colbegin <= colend) {
            for (int i = colbegin; i <= colend; i++) {
                res[rowbegin][i] = k++;
            }
            rowbegin++;
            
            for (int i = rowbegin; i <= rowend; i++) {
                res[i][colend] = k++;
            }
            colend--;
            
            for (int i = colend; i >= colbegin; i--) {
                res[rowend][i] = k++;
            }
            rowend--;
            
            for (int i = rowend; i >= rowbegin; i--) {
                res[i][colbegin] = k++;
            }
            colbegin++;
        }
        
        return res;
    }
}