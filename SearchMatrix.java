public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m * n - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) return true;
        
        return false;
    }
}