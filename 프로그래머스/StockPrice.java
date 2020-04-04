//������ �̿��� �ֽİ��� ����(��ū���� ���)

package ���α׷��ӽ�;

import java.util.*;

class Stock {
	int time;
	int price;

	Stock(int time, int price) {
		this.time = time;
		this.price = price;
	}
}

class Solution13 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<Stock> st = new Stack<Stock>();

		int i;
		for (i = 0; i < prices.length; i++) {
			if (i == 0)
				st.push(new Stock(i, prices[i]));

			if (prices[i] < st.peek().price) { // �ֽ��� ������ ���
				int time = st.pop().time;
				answer[time] = i - time;

				while (st.size() > 0 && st.peek().price > prices[i]) {
					int t = st.pop().time;
					answer[t] = i - t;
				}
				st.push(new Stock(i, prices[i]));
			} else {
				st.push(new Stock(i, prices[i]));
			}

		}
		int current = i - 1;
		while (!st.empty()) {
			int ti = st.pop().time;
			answer[ti] = current - ti;
		}
		return answer;
	}
}

public class StockPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 2, 3 };
		int[] answer = new Solution13().solution(prices);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");

	}

}
