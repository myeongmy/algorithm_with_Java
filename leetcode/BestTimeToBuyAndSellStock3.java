package leetcode;

class Solution {
    /* 브루트포스 방법 => 시간초과
    static class Transaction{
        int profit;
        int start;
        int end;
        
        Transaction(int profit, int start, int end){
            this.profit = profit;
            this.start = start;
            this.end = end;
        }
    }
    
    static List<Transaction> list;
    static int max;
    static List<Transaction> result;
    
    static void go(int idx, int selected){
        if(selected == 2){
            if((result.get(0).start <= result.get(1).start && result.get(0).end >= result.get(1).end) || (result.get(0).start >= result.get(1).start && result.get(0).end <= result.get(1).end) || (result.get(0).start < result.get(1).start && result.get(1).start < result.get(0).end) || (result.get(0).start > result.get(1).start && result.get(0).start < result.get(1).end))     //겹치는 경우
                return;
            
            if(max < result.get(0).profit + result.get(1).profit)
                max = result.get(0).profit + result.get(1).profit;
            
            return;
        }
        if(idx >= list.size()) return;
        
        result.add(list.get(idx));
        go(idx+1, selected+1);
        result.remove(result.size()-1);
        
        go(idx+1, selected);
    }
    public int maxProfit(int[] prices) {
        list = new ArrayList<>();
        max = Integer.MIN_VALUE;
        result = new ArrayList<>();
        
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] - prices[i] > 0){
                    list.add(new Transaction(prices[j] - prices[i], i, j));
                }
            }
        }
        
        if(list.size() == 0) return 0;
        //한 개 선택
        Collections.sort(list, new Comparator<Transaction>(){
            public int compare(Transaction a, Transaction b){
                if(a.profit > b.profit)
                    return -1;
                else if(a.profit < b.profit)
                    return 1;
                else
                    return 0;
            }
        });
        max = list.get(0).profit;
        System.out.println(list.size());
        //두 개 선택
        go(0, 0);
        
        return max;
    }
    */
    
     public int maxProfit(int[] prices) {
         if(prices.length == 0) return 0;
        int [] left = new int[prices.length];    //left[i] : i번째까지의 최대 수익
        int [] right = new int[prices.length];   //right[i] : i번째부터의 최대 수익
        
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(min > prices[i])
                min = prices[i];
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
         
        int max = prices[prices.length-1]; 
        for(int i=prices.length-2;i>=0;i--){
            if(max < prices[i])
                max = prices[i];
            right[i] = Math.max(right[i+1], max - prices[i]);
        }
        
        int result = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            if(result < left[i] + right[i])
                result = left[i] + right[i];
        }
         
         return result;
    }
}
