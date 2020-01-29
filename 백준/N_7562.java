//���� 7562��
/*����
ü���� ���� �� ����Ʈ�� ������ �ִ�. ����Ʈ�� �� ���� �̵��� �� �ִ� ĭ�� �Ʒ� �׸��� �����ִ�. ����Ʈ�� �̵��Ϸ��� �ϴ� ĭ�� �־�����. ����Ʈ�� �� �� �����̸� �� ĭ���� �̵��� �� ������?



�Է�
�Է��� ù° �ٿ��� �׽�Ʈ ���̽��� ������ �־�����.

�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. ù° �ٿ��� ü������ �� ���� ���� l(4 �� l �� 300)�� �־�����. ü������ ũ��� l �� l�̴�. ü������ �� ĭ�� �� ���� �� {0, ..., l-1} �� {0, ..., l-1}�� ��Ÿ�� �� �ִ�. ��° �ٰ� ��° �ٿ��� ����Ʈ�� ���� �ִ� ĭ, ����Ʈ�� �̵��Ϸ��� �ϴ� ĭ�� �־�����.

���
�� �׽�Ʈ ���̽����� ����Ʈ�� �� ������ �̵��� �� �ִ��� ����Ѵ�.*/

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
