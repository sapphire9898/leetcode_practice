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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;
        if (root == null || root.val == p.val || root.val == q.val) return root;
        
        
        if ((p.val < root.val) ^ (q.val < root.val)) {
            return root;
        }
        
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        else return lowestCommonAncestor(root.right, p, q);
        
        
        
    }
}