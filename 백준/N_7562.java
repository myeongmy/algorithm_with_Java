//백준 7562번
/*문제
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 몇 번만에 이동할 수 있는지 출력한다.*/

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

public class N_7562 {
	static int[] dx = { -1, -2, -2, -1, 1, 2, 1, 2 };
	static int[] dy = { -2, -1, 1, 2, -2, -1, 2, 1 };

	static void bfs(int i, int j, int[][] A, int[][] c) {
		Queue<Point> q = new LinkedList<Point>();
		c[i][j] = 1;
		q.offer(new Point(i, j));

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int v = 0; v < dx.length; v++) {
				if (p.i + dx[v] >= 0 && p.i + dx[v] < A.length && p.j + dy[v] >= 0 && p.j + dy[v] < A.length) {
					if (c[p.i + dx[v]][p.j + dy[v]] == 0) {
						q.offer(new Point(p.i + dx[v], p.j + dy[v]));
						c[p.i + dx[v]][p.j + dy[v]] = c[p.i][p.j] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int l = s.nextInt();
			int[][] A = new int[l][l];
			int[][] c = new int[l][l];
			int currentX = s.nextInt();
			int currentY = s.nextInt();
			int nextX = s.nextInt();
			int nextY = s.nextInt();
			bfs(currentX, currentY, A, c);
			System.out.println(c[nextX][nextY] - 1);
		}
	}

}
