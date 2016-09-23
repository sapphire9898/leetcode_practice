public class Solution {
     public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        wordList.add(beginWord);
        wordList.add(endWord);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        bfs(distance, graph, beginWord, endWord, wordList);
        
        dfs(distance, graph,res, ans,  beginWord, endWord);
        return res;
    }

    private void bfs(Map<String, Integer> distance, Map<String, List<String>> graph, String beginWord, String endWord, Set<String> wordList) {
        // construct the graph and the distance map via bfs.

        Queue<String> queue = new LinkedList<String>();
        // put the first word in the graph.
        queue.offer(beginWord);

        distance.put(beginWord, 0);

        for (String s : wordList) {
            graph.put(s, new ArrayList<String>());
        }


        while (!queue.isEmpty()) {
            String currWord = queue.poll();

            List<String> newList = expand(currWord, wordList);

            for (String next : newList) {
                graph.get(next).add(currWord);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(currWord) + 1);
                    queue.offer(next);
                }
            }
        }

    }

    private void dfs(Map<String, Integer> distance, Map<String, List<String>> map, List<List<String>> res, List<String> temp, String start, String endWord) {
        temp.add(endWord);
        if (start.equals(endWord)) {
            Collections.reverse(temp);
            res.add(new ArrayList<String>(temp));
            Collections.reverse(temp);
        }
        else {

            for (String nei : map.get(endWord)) {
                if (distance.containsKey(nei) && distance.get(nei) + 1 == distance.get(endWord)) {
                    dfs(distance, map, res, temp, start, nei);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }


    private List<String> expand(String word, Set<String> wordList) {
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < word.length();i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String curr = new String(chars);
                if (wordList.contains(curr)) {
                    res.add(curr);
                }
            }
        }
        return res;
    }
 
}