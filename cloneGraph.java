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
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        if (node == null) {
            return null;
        }
        
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = helper(node);
        UndirectedGraphNode head = map.get(node);
        
        for (UndirectedGraphNode nei : node.neighbors) {
            head.neighbors.add(map.get(nei));
            queue.offer(nei);
        }
        
        set.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            if(set.contains(curr)) {
                continue;
            }
            else {
                set.add(curr);
                
                for (UndirectedGraphNode newnei_nei : curr.neighbors) {
                    queue.offer(newnei_nei);
                    map.get(curr).neighbors.add(map.get(newnei_nei));
                }
            }
        }
        return head;
    }
    
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> helper(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        map.put(node, new UndirectedGraphNode(node.label));
        set.add(node);
        
        
        for (UndirectedGraphNode nei : node.neighbors) {
            queue.offer(nei);
            map.put(nei, new UndirectedGraphNode(nei.label));
            set.add(nei);
        }
        
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
        
            for (UndirectedGraphNode nei : curr.neighbors) {
                if (set.contains(nei)) {
                    continue;
                }
                map.put(nei, new UndirectedGraphNode(nei.label));
                queue.offer(nei);
                set.add(curr);
            }
        }
        return map;
    }
    
    
    
    
    
    
    
    
    
}