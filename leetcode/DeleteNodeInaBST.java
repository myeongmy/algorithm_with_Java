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
    static TreeNode parentNode = null;
    
    static TreeNode searchKey(TreeNode root, TreeNode parent, int key){
        if(root == null || root.val == key){
            parentNode = parent;
            return root;
        }
        if(root.val < key)
            return searchKey(root.right, root, key);
        else if(root.val > key)
            return searchKey(root.left, root, key);
        
        
        return root;
    }
    
    static TreeNode searchMinKey(TreeNode root, TreeNode parent){
        if(root.left == null){
            if(parent != null)
           parent.left = root.right;    //the reason of error: 대체될 노드의 오른쪽 subtree를 연결시켜주어야함
          return root;
        } 
        return searchMinKey(root.left, root);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        //해당 key 값의 위치 검색
        TreeNode deleteNode = searchKey(root, null, key);
        if(deleteNode == null)
            return root;
    
        //1. 자식 노드가 없는 경우
        if(deleteNode.left == null && deleteNode.right == null){
            if(parentNode == null){
                root = null;
                return root;
            }
            if(parentNode.left != null && parentNode.left.val == deleteNode.val)
                parentNode.left = null;
            else if(parentNode.right != null && parentNode.right.val == deleteNode.val)
                parentNode.right = null;
        }
        //2. 자식 노드가 왼쪽 혹은 오른쪽 하나만 존재하는 경우
        else if(!(deleteNode.left != null && deleteNode.right != null) && (deleteNode.left != null || deleteNode.right != null)){
            if(deleteNode.left != null){
                if(parentNode == null){
                    root = deleteNode.left;
                    return root;
                }
                if(parentNode.left != null && parentNode.left.val == deleteNode.val)
                    parentNode.left = deleteNode.left;
                else if(parentNode.right != null && parentNode.right.val == deleteNode.val)
                    parentNode.right = deleteNode.left;
            }else if(deleteNode.right != null){
                if(parentNode == null){
                    root = deleteNode.right;
                    return root;
                }
                 if(parentNode.left != null && parentNode.left.val == deleteNode.val)
                    parentNode.left = deleteNode.right;
                else if(parentNode.right != null && parentNode.right.val == deleteNode.val)
                    parentNode.right = deleteNode.right;
            }
        }
        //3. 왼쪽과 오른쪽 모두 자식이 존재하는 경우
        else if(deleteNode.left != null && deleteNode.right != null){
            TreeNode node = searchMinKey(deleteNode.right, null);
            
            if(parentNode == null){
                root = node;
            }else{
                 if(parentNode.left != null && parentNode.left.val == deleteNode.val){
                    parentNode.left = node;
                }else if(parentNode.right != null && parentNode.right.val == deleteNode.val){
                    parentNode.right = node;
                }
            }
            
            if(node.val != deleteNode.right.val)
                node.right = deleteNode.right;
            node.left = deleteNode.left;
        }
        return root;
    }
}
