public class Solution {
    // use BFS
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String word : reached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] wordArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        String wordnew = new String(wordArray);
                        if (wordList.contains(wordnew)) {
                            toAdd.add(wordnew);
                            wordList.remove(wordnew);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
        
    }
    
   
    
    
}