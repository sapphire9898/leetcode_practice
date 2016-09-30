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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (lefth(root) == righth(root)) {
            return (1 << (lefth(root))) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        
    }
    
    private int lefth (TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
    
    private int righth(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
    
}