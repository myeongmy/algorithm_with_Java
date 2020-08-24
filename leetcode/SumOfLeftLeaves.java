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
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        go(root, 0);
        return sum;
    }
    
    public void go(TreeNode root, int flag){
        if(root == null)
            return;
        if(root.left == null && root.right == null && flag == 1)
            sum += root.val;
        
        go(root.left, 1);
        go(root.right, 0);
    }
}
