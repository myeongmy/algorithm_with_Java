package leetcode;

//브루트 포스 -> 시간초과

/*
class Solution {
	static int totalCost = 0;
	static int min = Integer.MAX_VALUE;

	static void go(int idx, int[] days, int[] costs) {
		if (idx >= days.length) {
			if (min > totalCost)
				min = totalCost;

			return;
		}
		// 1-day 패스권 선택
		totalCost += costs[0];
		go(idx + 1, days, costs);
		totalCost -= costs[0];

		// 7-day 패스권 선택
		totalCost += costs[1];
		int newIdx = idx;
		while (newIdx < days.length && days[idx] + 7 > days[newIdx])
			newIdx++;
		go(newIdx, days, costs);
		totalCost -= costs[1];

		// 30-day 패스권 선택
		totalCost += costs[2];
		int newIdx2 = idx;
		while (newIdx2 < days.length && days[idx] + 30 > days[newIdx2])
			newIdx2++;
		go(newIdx2, days, costs);
		totalCost -= costs[2];
	}

	public int mincostTickets(int[] days, int[] costs) {
		min = Integer.MAX_VALUE;
		go(0, days, costs);

		return min;
	}
}
*/

//Dynamic programming

class Solution {
  public int mincostTickets(int[] days, int[] costs) {
      int [] d = new int[days[days.length-1]+1];    //d[day] : day일까지 여행하는데 드는 최소한의 비용
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int i=0;i<days.length;i++)
          list.add(days[i]);
  
      
      for(int i=1;i<d.length;i++){
          if(list.indexOf(i) == -1){
              d[i] = d[i-1];
              continue;
          }
          
          int oneDay = d[i-1] + costs[0];
          int sevenDay = d[Math.max(i-7, 0)] + costs[1];
          int thirtyDay = d[Math.max(i-30, 0)] + costs[2];
          if(i==8)
              System.out.println(oneDay +" "+sevenDay+" "+thirtyDay);
          d[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
          
      }
      
      return d[d.length-1];
  }
}
