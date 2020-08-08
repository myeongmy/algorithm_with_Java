package leetcode;

class Trie {
    static class TreeNode{
        boolean isEnd = false;    //끝 점인지 여부
        char value;               //알파벳
        TreeNode[] next = new TreeNode[26];   //다음 노드
        
        TreeNode(char value){
            this.value = value;
        }
    }
    
    TreeNode root = new TreeNode(' ');     //루트 노드
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode t = root;
        
        for(int i=0;i<word.length();i++){
            if(t.next[word.charAt(i) - 97] == null){
                t.next[word.charAt(i) - 97] = new TreeNode(word.charAt(i));
            }
            t = t.next[word.charAt(i) - 97];
        }
        t.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode t = root;
        
        for(int i=0;i<word.length();i++){
            if(t.next[word.charAt(i) - 97] == null)
                return false;
            
            t = t.next[word.charAt(i) - 97];
        }
        if(t.isEnd == true)
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode t = root;
        
        for(int i=0;i<prefix.length();i++){
            if(t.next[prefix.charAt(i) - 97] == null)
                return false;
            
            t = t.next[prefix.charAt(i) - 97];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
