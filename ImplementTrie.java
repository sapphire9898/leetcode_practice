class TrieNode {
    // Initialize your data structure here.
     TrieNode[] sons;
     boolean isLeaf;
    public TrieNode() {
        sons = new TrieNode[27];
        isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int)(word.charAt(i) - 'a');
            if (curr.sons[index] == null) return false;
            else {
                curr = curr.sons[index];
            }
        }
        return curr.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int)(prefix.charAt(i) - 'a');
            if (curr.sons[index] == null) return false;
            else {
                curr = curr.sons[index];
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");