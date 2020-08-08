//일일히 문자열 탐색하는 방법으로 구현하는 것은 시간초과 -> trie 알고리즘 적용

package leetcode;

import java.util.*;

class WordDictionary {
    boolean isEnd;
    WordDictionary [] next;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        next = new WordDictionary[26];
        isEnd = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary wd = this;
        
        for(int i=0;i<word.length();i++){
            if(wd.next[word.charAt(i) - 97] == null)
                wd.next[word.charAt(i) - 97] = new WordDictionary();
            
            wd = wd.next[word.charAt(i) - 97];
        }
        
        wd.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary wd = this;
        
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) == '.'){
                for(WordDictionary ch : wd.next){
                    if(ch != null && ch.search(word.substring(i+1)) == true) return true;      //The reason of error
                }
                return false;
            }
            if(wd.next[word.charAt(i) - 97] == null)
                return false;
            
            wd = wd.next[word.charAt(i) - 97];
        }
        
        if(wd.isEnd == false)
            return false;
        else
            return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */