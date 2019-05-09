package codingtest_study;

import java.util.Scanner;

public class OrganicVeget {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void dfs(int i, int j, int[][] visited) {

		visited[i][j] = 1;

		for (int k = 0; k < 4; k++) {
			int nextX = i + dx[k];
			int nextY = j + dx[k];

			if (nextX < 0 || nextY < 0 || nextX >= visited.length || nextY >= visited[1].length) {
				continue;
			}
			if (visited[nextX][nextY] == 1) {
				continue;
			}
			dfs(nextX, nextY, visited);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int M = s.nextInt(); // 가로
			int N = s.nextInt(); // 세로
			int K = s.nextInt(); // 배추의 수
			int[][] farm = new int[N][M];
			for (int j = 0; j < K; j++) {
				int a = s.nextInt();
				int b = s.nextInt();
				farm[b][a] = 1;
			}
			int[][] visited = new int[N][M];
			int result = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (farm[j][k] == 1 && visited[j][k] == 0)
						result += 1;
					dfs(j, k, visited);

				}
			}
			System.out.println(result);

		}

	}

}
