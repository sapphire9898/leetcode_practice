public class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[27];
        boolean isLeaf = false;
    }
    
    class Trie {
        public TrieNode root = new TrieNode();
        
        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = (int) (word.charAt(i) - 'a');
                if (curr.next[index] == null) {
                    curr.next[index] = new TrieNode();
                }
                curr = curr.next[index];
            }
            curr.isLeaf = true;
        } 
        
        public boolean startWith(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = (int) (word.charAt(i) - 'a');
                if (curr.next[index] == null) return false;
                else curr = curr.next[index];
            }
            return true;
        }
        
        public boolean search(String word) {
             TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = (int) (word.charAt(i) - 'a');
                if (curr.next[index] == null) return false;
                else curr = curr.next[index];
            }
            return curr.isLeaf;
        }
        
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        // we need to use Trie here, store the whole board using one trie tree. 
        Set<String> set = new HashSet<String>();
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(set, board, visited, "", i, j,  trie);
            }
        }
        
        return new ArrayList<String>(set);
        
        
    }
    
    private void dfs(Set<String> set, char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (visited[i][j]) return;
        
        str = str + board[i][j];
        if (!trie.startWith(str)) return;
        if (trie.search(str)) {
            set.add(str);
        }
        
        
        visited[i][j] = true;
        dfs(set, board, visited, str, i + 1, j, trie);
        dfs(set, board, visited, str, i - 1, j, trie);
        dfs(set, board, visited, str, i, j + 1, trie);
        dfs(set, board, visited, str, i, j - 1, trie);
        visited[i][j] = false;
        
    }
    
    
    
    
    
}