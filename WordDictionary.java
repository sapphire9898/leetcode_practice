public class WordDictionary {

    class TrieNode {
        TrieNode[] sons;
        boolean isLeaf;
        public TrieNode() {
            sons = new TrieNode[27];
            isLeaf = false;
        }
    }
    private TrieNode root = new TrieNode();
    
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null) return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (curr.sons[index] != null) {
                curr = curr.sons[index];
            }
            else {
                curr.sons[index] = new TrieNode();
                curr = curr.sons[index];
            }
        }
        curr.isLeaf = true;
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        
        return helper(word, root, 0);
    }
    
    private boolean helper(String word, TrieNode root, int start) {
        if (root == null) return false;
        
        if (start == word.length()) {
            if (root.isLeaf)return true;
            else return false;
        }
        
        if (word.charAt(start) == '.') {
            //next root is any letter, we need to traverse the root.sons 
            for (int i = 0; i < 27; i++) {
                if (root.sons[i] != null) {
                    if (helper(word, root.sons[i], start + 1)) return true;
                }
            }
        }
        else {
            int index = (int) (word.charAt(start) - 'a');
            if (root.sons[index] == null) return false;
            else {
                return helper(word, root.sons[index], start + 1);
            }
        }
        return false;
        
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");