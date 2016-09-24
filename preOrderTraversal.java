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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root ==  null) return res;
        
        helper(res, root);
        return res;
        
    }
    
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
        
    }
}



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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root ==  null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        res.add(root.val);
        stack.push(root);
        while (curr != null && curr.left != null) {
            res.add(curr.left.val);
            stack.push(curr.left);
            curr = curr.left;
        }
        
        // the nodes in stack has been visited and traverse the left nodes. 
        // traverse the left and then push into the stack. read the val. 
        
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
                res.add(curr.right.val);
                curr = curr.right;
                while (curr != null && curr.left != null) {
                    res.add(curr.left.val);
                    stack.push(curr.left);
                    curr = curr.left;
                }
                
            }
            
        }
        return res;
        
    }
    
   
}