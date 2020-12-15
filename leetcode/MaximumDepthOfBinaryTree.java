package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int max_depth = 0;
    
    static void dfs(TreeNode root, int depth){
        if(root != null && max_depth < depth)
            max_depth = depth;
        
        if(root == null)
            return;
        
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        int a = max_depth;
        max_depth = 0;
        
        return a;
    }
}
