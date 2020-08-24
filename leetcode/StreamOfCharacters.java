package leetcode;

//Trie 알고리즘 이용
//query문 문자가 stream형태로 주어지기 때문에 reverse order로 저장

class StreamChecker {
  static class TrieNode{
      char val;
      TrieNode [] next = new TrieNode[26];
      boolean end = false;
      
      TrieNode(char val){
          this.val = val;
      }
  }
  
  TrieNode root = new TrieNode(' ');
  StringBuilder sb = new StringBuilder();
  
  public StreamChecker(String[] words) {
      for(int i=0;i<words.length;i++){
          TrieNode node = root;
          
          for(int j=words[i].length() - 1;j>=0;j--){
              if(node.next[words[i].charAt(j) - 97] == null)
                  node.next[words[i].charAt(j) - 97] = new TrieNode(words[i].charAt(j));
              node = node.next[words[i].charAt(j) - 97];
          }
          node.end = true;
      }
  }
  
  public boolean query(char letter) {
      sb.append(letter);
      TrieNode node = root;
      
      for(int i=sb.length() - 1;i>=0;i--){
          if(node.next[sb.charAt(i) - 97] == null)
              return false;
          else{
              if(node.next[sb.charAt(i) - 97].end == true)
                  return true;
              else
                  node = node.next[sb.charAt(i) - 97];
          }
      }
      
      return false;
  }
}

/**
* Your StreamChecker object will be instantiated and called as such:
* StreamChecker obj = new StreamChecker(words);
* boolean param_1 = obj.query(letter);
*/
