//���� 2178��
/*����
N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �� ĭ���� �ٸ� ĭ���� �̵��� ��, ���� ������ ĭ���θ� �̵��� �� �ִ�.

���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.

�Է�
ù° �ٿ� �� ���� N, M(2 �� N, M �� 100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������ �پ �Է����� �־�����.

���
ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. �׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.*/

package ����;

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
