package codingtest_study;

// Stack, Queue (java.util package)
// Stack s = new Stack();  s.push(); s.pop() -> object 타입이라 어떤 객체 모두 삽입 가능
// Queue q = new LinkedList();  q.offer(); q.poll(); -> object타입

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsBfs {
	static Scanner s = new Scanner(System.in);
	static int N = s.nextInt();
	static int M = s.nextInt();
	static int startV = s.nextInt();
	static int[][] edgeArray = new int[N + 1][N + 1];
	static int[] visited = new int[N + 1];

	static void dfs(int startV) {
		if (visited[startV] == 1)
			return;
		visited[startV] = 1;
		System.out.print(startV + " ");
		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0 && edgeArray[startV][i] == 1) {
				dfs(i);
			}
		}
	}

	static void bfs(int startV) {
		int[] vi = new int[N + 1];
		Queue q = new LinkedList();
		q.offer(startV);
		vi[startV] = 1;
		System.out.print(startV + " ");

		while (!q.isEmpty()) {
			int v = (int) q.poll();

			for (int i = 1; i <= N; i++) {
				if (vi[i] == 0 && edgeArray[v][i] == 1) {
					q.offer(i);
					System.out.print(i + " ");
					vi[i] = 1;
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			edgeArray[a][b] = 1;
			edgeArray[b][a] = 1;
		}
		dfs(startV);
		System.out.println();

		bfs(startV);

	}

}
