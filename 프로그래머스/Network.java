//dfs를 이용한 연결 요소 개수 구하기 문제

package 프로그래머스;

import java.util.*;

class Solution2 {
	static int[] c = new int[205];

	static void dfs(int i, ArrayList<Integer>[] adlist) {
		c[i] = 1;

		for (int a : adlist[i]) {
			if (c[a] == 0)
				dfs(a, adlist);
		}
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1)
					adlist[i].add(j);
			}
		}

		for (int i = 0; i < n; i++) {
			if (c[i] == 0) {
				dfs(i, adlist);
				answer++;
			}
		}
		return answer;
	}
}

public class Network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(new Solution2().solution(3, computers));
	}

}
