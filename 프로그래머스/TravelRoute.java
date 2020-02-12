//DFS 문제 (경로 구하기)
package 프로그래머스;

import java.util.*;

class Solution1 {
	static LinkedList<String> list = new LinkedList<String>();
	static LinkedList<String> list1 = new LinkedList<String>();

	static void dfs(String a, int cnt, String[][] tickets, int[] c) {

		if (cnt == tickets.length) {
			if (list1.size() == 0) {
				for (int i = 0; i < list.size(); i++)
					list1.add(list.get(i));
			}
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals(a) && c[i] == 0) {
				c[i] = 1;
				list.add(tickets[i][1]);
				dfs(tickets[i][1], cnt + 1, tickets, c);
				c[i] = 0;
				list.remove(list.size() - 1);
			}
		}

	}

	public String[] solution(String[][] tickets) {
		Arrays.sort(tickets, new Comparator<String[]>() {
			public int compare(String[] x, String[] y) {
				return x[1].compareTo(y[1]);
			}
		});
		int[] c = new int[tickets.length];
		list.add("ICN");
		dfs("ICN", 0, tickets, c);
		String[] answer = new String[tickets.length + 1];
		for (int i = 0; i < list1.size(); i++) {
			answer[i] = list1.get(i);
		}
		return answer;
	}
}

public class TravelRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[] arr = new Solution1().solution(tickets);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
