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
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(root.left);
        flatten(root.right);
        
        root.right = left;
        root.left = null;
        
        while (root.right != null) {
            root = root.right;
        }
        
        root.right = right;
        
        
    }
}