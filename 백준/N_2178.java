//백준 2178번
/*문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.*/

package 백준;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_2178 {
	static int[][] c = new int[100][100];
	static Queue<Point> q = new LinkedList<Point>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void bfs(int i, int j, int[][] A) {
		int cnt = 1;
		c[i][j] = cnt;
		q.offer(new Point(i, j));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int v = 0; v < dx.length; v++) {
				if (p.i + dx[v] >= 0 && p.i + dx[v] < A.length && p.j + dy[v] >= 0 && p.j + dy[v] < A[0].length) {

					if (A[p.i + dx[v]][p.j + dy[v]] == 1 && c[p.i + dx[v]][p.j + dy[v]] == 0) {
						q.offer(new Point(p.i + dx[v], p.j + dy[v]));
						c[p.i + dx[v]][p.j + dy[v]] = c[p.i][p.j] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - 48;
			}
		}
		bfs(0, 0, A);
		System.out.println(c[N - 1][M - 1]);
	}
}
