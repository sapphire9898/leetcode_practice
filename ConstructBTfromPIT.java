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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) return null;
        int n = preorder.length;
        TreeNode root = helper(preorder, 0, n - 1, inorder, 0, n - 1);
        
        
        return root;
    }
    
    private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        int i = instart;
        for (; i <= inend; i++) {
            if (inorder[i] == preorder[prestart]) {
                break;
            }
        }
        
        
        // inorder_left : instart to i - 1, 
        // inorder_right: i + 1 t0 inend. 
        
        //preorder_left: prestart + 1, prestart + 1 + i - 1 - instart;
        //preorder_right: preend - (inend - i - 1) to preend; 
        
        root.left = helper(preorder, prestart + 1, prestart + 1 + i - 1 - instart, inorder, instart, i - 1);
        root.right = helper(preorder, preend - inend + i + 1, preend, inorder, i + 1, inend);
        
        return root;
        
    }
    
}