public class Solution {
   public void gameOfLife(int[][] board) {
        // coding the change. 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = helper(board, i, j);
                // if live
                // < 2 , do nothing; 01
                // == 2 || 3, add 2; 11
                // > 3, do nothing; 01
                
                // if dead
                // if == 3, add 2, 10;
                // else do nothing. 
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    board[i][j] += 2;
                }
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] += 2;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private int helper(int[][] board, int i, int j) {
        int count = 0;
        count = check(board, i - 1, j) + check(board, i + 1, j) + check(board, i - 1, j - 1) + check(board, i + 1, j + 1) + check(board, i, j + 1) + check(board, i, j - 1) + check(board, i - 1, j + 1) + check(board, i + 1, j - 1);
        return count;
    }
    private int check(int[][] board, int i, int j) {
        // return the number , the XX digit, first to store the new state, next to store the old state. 
        // so we need to find the board[i][j] & 1 == 1;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return 0;
        if ((board[i][j] & 1) == 1) return 1;
        return 0;
    }
}