public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isvalid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            else board[i][j] = '.';
                        }
                        
                    }
                    return false;
                }
            }
            
        }
        return true;
    }
    private boolean isvalid(char[][] board, int i, int j, char c) {
       

        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        
        return true;
        
        
        
    }
}