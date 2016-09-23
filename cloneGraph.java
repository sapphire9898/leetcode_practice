/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copy = new HashMap<>();
        
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        copy.put(node, new UndirectedGraphNode(node.label));
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for (UndirectedGraphNode nei : curr.neighbors) {
                if (!visited.contains(nei))  {
                    queue.offer(nei);
                    copy.put(nei, new UndirectedGraphNode(nei.label));
                }
                visited.add(nei);
            }
        }
        
        for (UndirectedGraphNode n : visited) {
            for (UndirectedGraphNode nei : n.neighbors) {
                copy.get(n).neighbors.add(copy.get(nei));
            }
        }
        
        
        return copy.get(node);
    }
}