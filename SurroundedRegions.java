public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') merge(board, i, 0);
            if (board[i][n - 1] == 'O') merge(board, i, n - 1);
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') merge(board, 0, j);
            if (board[m - 1][j] == 'O') merge(board, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void merge(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        
        if (board[i][j] == 'O') board[i][j] = '*';
        
        if (i + 1 < board.length - 1 && board[i + 1][j] == 'O')merge(board, i + 1, j);
        if (i - 1 >= 1 && board[i - 1][j] == 'O')merge(board, i - 1, j);
        if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O')merge(board, i, j + 1);
        if (j - 1 >= 1 && board[i][j - 1] == 'O')merge(board, i, j - 1);
        
    }
    
}