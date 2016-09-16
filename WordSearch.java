public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0)) return true;
            }
        }
        
        return false;
        
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int len) {
        if (len == word.length()) return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*' || word.charAt(len) != board[i][j]) return false;
        
        int m = board.length, n = board[0].length;
        char c = board[i][j];
        board[i][j] = '*';
        boolean mark = helper(board, word, i - 1, j, len + 1) || helper(board, word, i + 1, j, len + 1) || helper(board, word, i, j - 1, len + 1) || helper(board, word, i, j + 1, len + 1);
        
        board[i][j] = c;
        
        
        return mark;
        

        
    }
    
    
}