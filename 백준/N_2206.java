//백준 2206번
//BFS문제 + 완전탐색
/*문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.*/

/*나의 아이디어 -> 시간 초과
1. 벽을 깨지 않고 이동했을 때의 최단 거리를 구한다.
2. 벽을 하나씩 깨보고, 그 때마다의 최단 거리를 구한다.*/
package 백준;

import java.util.*;
import java.io.*;

class Point4 {
	int i;
	int j;
	int flag;

	Point4(int i, int j, int flag) {
		this.i = i;
		this.j = j;
		this.flag = flag;
	}
}

public class N_2206 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][][] c;

	static void bfs(int[][] A) {
		c = new int[A.length][A[0].length][2];
		Queue<Point4> q = new LinkedList<Point4>();

		c[0][0][0] = 1;
		q.offer(new Point4(0, 0, 0));

		while (!q.isEmpty()) {
			Point4 p = q.poll();
			for (int i = 0; i < dx.length; i++) {
				if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
					if (A[p.i + dx[i]][p.j + dy[i]] == 0 && c[p.i + dx[i]][p.j + dy[i]][p.flag] == 0) {
						q.offer(new Point4(p.i + dx[i], p.j + dy[i], p.flag));
						c[p.i + dx[i]][p.j + dy[i]][p.flag] = c[p.i][p.j][p.flag] + 1;
					} else if (A[p.i + dx[i]][p.j + dy[i]] == 1 && p.flag == 0
							&& c[p.i + dx[i]][p.j + dy[i]][p.flag + 1] == 0) {
						q.offer(new Point4(p.i + dx[i], p.j + dy[i], 1));
						c[p.i + dx[i]][p.j + dy[i]][p.flag + 1] = c[p.i][p.j][p.flag] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					A[i][j] = str.charAt(j) - 48;

				}
			}
			bfs(A);
			if (c[N - 1][M - 1][0] == 0 && c[N - 1][M - 1][1] == 0) {
				System.out.println(-1);
			} else if (c[N - 1][M - 1][0] == 0) {
				System.out.println(c[N - 1][M - 1][1]);

			} else if (c[N - 1][M - 1][1] == 0) {
				System.out.println(c[N - 1][M - 1][0]);
			} else {
				System.out.println(Math.min(c[N - 1][M - 1][0], c[N - 1][M - 1][1]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
