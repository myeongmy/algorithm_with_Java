//백준 11725번
/*문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.*/

package 백준;

import java.util.*;

public class N_11725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		int[] parent = new int[N + 1]; // 부모 노드 저장
		// bfs 풀이
		int[] c = new int[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		c[1] = 1;
		q.offer(1);

		while (!q.isEmpty()) {
			int a = q.poll();

			for (int t : adlist[a]) {
				if (c[t] == 0) {
					c[t] = 1;
					q.offer(t);
					parent[t] = a;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

}
