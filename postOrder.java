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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        
        helper(res, root.left);
        helper(res, root.right);
        
        res.add(root.val);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        stack1.push(root);
        
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }
        
        while (!stack2.isEmpty()) {
            TreeNode result = stack2.pop();
            res.add(result.val);
        }
        
        return res;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
       
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                
                if (temp == null) {
                    // the right nodes has been traversed, now can pop the node and output. 
                    temp = stack.pop();
                    res.add(temp.val);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        // the temp may be the right node, and then we need to pop another one. 
                        temp = stack.pop();
                        res.add(temp.val);
                    }
                }
                else {
                    // the right nodes need to be traversed. 
                    curr = temp;
                }
                
            }
        }  
        return res;
    }
    
    
}