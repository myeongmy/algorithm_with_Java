//백준 11724번
/*문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.*/

package 백준;

import java.util.*;

public class N_11724 {
	static boolean[] c = new boolean[1001];

	static void dfs(int v, ArrayList<Integer>[] adlist) {
		if (c[v])
			return;
		c[v] = true;

		for (int a : adlist[v]) {
			if (c[a] == false)
				dfs(a, adlist);
		}
	}

	static void bfs(int v, ArrayList<Integer>[] adlist) {
		Queue<Integer> q = new LinkedList<Integer>();
		c[v] = true;
		q.offer(v);

		while (!q.isEmpty()) {
			int a = q.poll();
			for (int k : adlist[a]) {
				if (c[k] == false) {
					q.offer(k);
					c[k] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		int connectedCompo = 0;
		for (int i = 1; i <= N; i++) {
			if (c[i] == false) {
				// dfs(i, adlist);
				bfs(i, adlist);
				connectedCompo++;
			}
		}
		System.out.println(connectedCompo);
	}

}
