/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<TreeNode, Integer> distance = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        res.add(root.val);
        map.put(0, res);
        distance.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr.left != null) {
                int currLeftLevel = distance.get(curr) - 1;
                distance.put(curr.left, currLeftLevel);
                queue.offer(curr.left);
                if (!map.containsKey(currLeftLevel)) {
                    map.put(currLeftLevel, new ArrayList<Integer>());
                }
                map.get(currLeftLevel).add(curr.left.val);
            }
            
            if (curr.right != null) {
                int currRightLevel = distance.get(curr) + 1;
                distance.put(curr.right, currRightLevel);
                queue.offer(curr.right);
                if (!map.containsKey(currRightLevel)) {
                    map.put(currRightLevel, new ArrayList<Integer>());
                }
                map.get(currRightLevel).add(curr.right.val);
            }
        }
        
        for (Integer i : map.keySet()) {
            ans.add(map.get(i));
        }
        return ans;
    }
    
}