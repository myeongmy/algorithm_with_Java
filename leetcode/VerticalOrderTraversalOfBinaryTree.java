package leetcode;

import java.util.*;

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
    static class Node{
        int x;
        int y;
        int val;
        
        Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static void dfs(TreeNode t, int x, int y, HashMap<Integer, LinkedList<Node>> hm){
        if(hm.get(x) == null)
            hm.put(x, new LinkedList<Node>());
        hm.get(x).add(new Node(x, y, t.val));
        
        if(t.left != null)
            dfs(t.left, x-1, y-1, hm);
        if(t.right != null)
            dfs(t.right, x+1, y-1, hm);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, LinkedList<Node>> hm = new HashMap<Integer, LinkedList<Node>>();
    
        dfs(root, 0, 0, hm);
        
        //hashmap의 keyset을 key값 대로 정렬
        List<Integer> keyList = new ArrayList<>(hm.keySet());
        Collections.sort(keyList);
        
        for(Integer a : keyList){
            Collections.sort(hm.get(a), new Comparator<Node>(){
                public int compare(Node a, Node b){
                    if(a.y > b.y)
                        return -1;
                    else if(a.y < b.y)
                        return 1;
                    else{
                        if(a.val < b.val)
                            return -1;
                        else if(a.val > b.val)
                            return 1;
                        else
                            return 0;
                    }
                }
            });
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(Node n : hm.get(a))
                list.add(n.val);
            
            result.add(list);
        }
        return result;
    }
}
