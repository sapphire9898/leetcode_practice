public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        return searchMatrixHelper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);

    }

    private boolean searchMatrixHelper(int[][] matrix, int rowstart, int rowend, int colstart, int colend, int target) {

        if (rowstart > rowend || colstart > colend) return false;
        if (rowstart == rowend) {
            for (int i = colstart; i <= colend; i++) {
                if (matrix[rowstart][i] == target) return true;
            }
            return false;
        }

        if (colstart == colend) {
            for (int i = rowstart; i <= rowend; i++) {
                if (matrix[i][colend] == target) return true;
            }
            return false;
        }
        int midrow = rowstart + ((rowend - rowstart) >> 1);
        int midcol = colstart + (colend - colstart) / 2;

        if (matrix[midrow][midcol] == target) {
            return true;
        }
        else if (matrix[midrow][midcol] < target) {
            return searchMatrixHelper(matrix, midrow + 1, rowend, colstart, colend, target) ||
                    searchMatrixHelper(matrix, rowstart, midrow , midcol + 1, colend, target);
        }
        else {
            return searchMatrixHelper(matrix, rowstart, midrow - 1, colstart, colend, target) ||
                    searchMatrixHelper(matrix, rowstart, rowend, colstart, midcol - 1, target);
        }


    }
}