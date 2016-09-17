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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n <= 0) return res;
        
        return helper(1, n);  
          
    }
    
    // create the tree with root and from start to end. 
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        };
        
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);
            
            // start to i - 1 is left tree, 
            // i + 1 to end is the right tree; 
            
            for (TreeNode left : helper(start, i - 1)) {
                for (TreeNode right : helper(i + 1, end)) {
                    TreeNode root = new TreeNode(i); // here we must recreate a new TreeNode. 
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
            
        }
        return res;
        
        
    }
}