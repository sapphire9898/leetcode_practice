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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        // map store the level from the bottom. 
        
        // use dfs.  
        level(root, map);
        for (Integer i : map.keySet()) {
            res.add(map.get(i));
        }
        return res;
    }
    
    private int level(TreeNode root, TreeMap<Integer, List<Integer>> map) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            if (!map.containsKey(0)) {
                map.put(0, new ArrayList<Integer>());
            }
            map.get(0).add(root.val);
            return 0;
        }
        int level = Math.max(level(root.left, map) , level(root.right, map)) + 1;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<Integer>());
        }
        map.get(level).add(root.val);
        return level;
    }
    
}