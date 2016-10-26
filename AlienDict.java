
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]

public class Solution {
    public String alienOrder(String[] words) {
        // build the graph, and then find the topological order for the graph. 
        Map<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> outdegree = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                outdegree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            int j = 0;
            for (j = 0; j < len; j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    //  the curr -- > next;
                    if (!graph.containsKey(next.charAt(j))) {
                        graph.put(next.charAt(j), new HashSet<Character>());
                    }
                    if (graph.get(next.charAt(j)).add(curr.charAt(j))) {
                        // get rid of the duplicate edge.
                        outdegree.put(curr.charAt(j), outdegree.get(curr.charAt(j)) + 1);
                    }
                    break;
                }
            }
            if (j == len && curr.length() > len) {
                // get rid of ["zw","z"]
                return "";
            }    
            
        }
        int size = outdegree.size();
        StringBuilder result = new StringBuilder();
        
        Queue<Character> queue = new LinkedList<Character>();
        for (Character c : outdegree.keySet()) {
            if (outdegree.get(c) == 0) {
                queue.offer(c);
                result.insert(0, c);
            }
        }
        
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (!graph.containsKey(c)) continue;
            for (Character nei : graph.get(c)) {
                int curr = outdegree.get(nei);
                outdegree.put(nei, curr - 1);
                if (curr == 1) {
                    queue.offer(nei);
                    result.insert(0, nei);
                }
            }
        }
        
        if (result.length() != size) return "";
        else return result.toString();
    }
}