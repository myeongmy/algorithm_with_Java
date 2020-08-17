package leetcode;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] result = new int[num_people];
        
        int num = 1;
        int sum = 0;
        int i= 0;
        while(true){
            if(candies < sum + num) break;
            result[i] += num;
            sum += num;
            num++;
            i = (i + 1) % result.length;
        }
        
        result[i] += (candies - sum);
        
        return result;
    }
}
