//백준 2206번 벽 부수고 이동하기
//bfs

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_2206_v2 {
	static class Point {
		int i;
		int j;
		int broken; // 벽을 한 번 부쉈는지 여부(0: 안부숨, 1: 부숨)
		int cnt;

		Point(int i, int j, int broken, int cnt) {
			this.i = i;
			this.j = j;
			this.broken = broken;
			this.cnt = cnt;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}

		// bfs
		Queue<Point> q = new LinkedList<Point>();
		int[][][] c = new int[N][M][2];
		q.offer(new Point(0, 0, 0, 1));
		c[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			// 벽을 부수고 이동하는 경우
			if (p.broken == 0) {
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < N && p.j + dy[i] >= 0 && p.j + dy[i] < M) {
						if (A[p.i + dx[i]][p.j + dy[i]] == 1 && c[p.i + dx[i]][p.j + dy[i]][1] == 0) {
							q.offer(new Point(p.i + dx[i], p.j + dy[i], 1, p.cnt + 1));
							c[p.i + dx[i]][p.j + dy[i]][1] = p.cnt + 1;
						}
					}
				}
			}

			// 벽을 안 부수고 이동하는 경우
			for (int i = 0; i < dx.length; i++) {
				if (p.i + dx[i] >= 0 && p.i + dx[i] < N && p.j + dy[i] >= 0 && p.j + dy[i] < M) {
					if (A[p.i + dx[i]][p.j + dy[i]] == 0 && c[p.i + dx[i]][p.j + dy[i]][p.broken] == 0) {
						q.offer(new Point(p.i + dx[i], p.j + dy[i], p.broken, p.cnt + 1));
						c[p.i + dx[i]][p.j + dy[i]][p.broken] = p.cnt + 1;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			if (c[N - 1][M - 1][i] != 0 && min > c[N - 1][M - 1][i]) {
				min = c[N - 1][M - 1][i];
			}
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
