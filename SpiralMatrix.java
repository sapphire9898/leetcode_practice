public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int upstart = 0, downend = m - 1, leftstart = 0, rightend = n - 1;
        
        while (upstart <= downend && leftstart <= rightend) {
            for (int i = leftstart; i <= rightend; i++) {
                res.add(matrix[upstart][i]);
            }
            upstart++;
            for (int i = upstart; i <= downend; i++) {
                res.add(matrix[i][rightend]);
            }
            rightend--;
            if (upstart <= downend) {
                for (int i = rightend; i >= leftstart; i--) {
                    res.add(matrix[downend][i]);
                }
                downend--;
            }
            if (leftstart <= rightend) {
                for (int i = downend; i >= upstart; i--) {
                    res.add(matrix[i][leftstart]);
                }
                leftstart++;
            }
        }
        return res;
    }
}