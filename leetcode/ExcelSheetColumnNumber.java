package leetcode;

class Solution {
    
    //26진수 구하기
    public int titleToNumber(String s) {
        int result = 0;
        
        int pow = 1;
        for(int i=s.length()-1;i>=0;i--){
            result += pow *(s.charAt(i) - 64);
            pow = pow*26;
        }
        
        return result;
    }
}
