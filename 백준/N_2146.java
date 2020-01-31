//���� 2146��
/*����
���� ������ �̷���� ���� �ִ�. �� ������ ������� ���� �մ� �ٸ��� ����ڴٴ� �������� �α���̸� �� �缱�� �� �־���. ������ ���� ����ɿ� ��������, �ٸ��� ���´ٴ� ���� �Ʊ��ٴ� ������ �ϰ� �Ǿ���. �׷��� �״�, �������� ������ �� ���� �ٸ� ���� �մ� �ٸ� �ϳ����� ������ �Ͽ���, �� ���� �ٸ��� ���� ª�� �Ͽ� ���� �Ƴ��� �Ͽ���.

�� ����� N��Nũ���� ������ ���� �����Ѵ�. �� ����� ���� ������ �̷���� ������, ���̶� ������������ ������ �پ��ִ� ����� ���Ѵ�. ������ �� ���� ������ �̷���� ������ �����̴�.



���� �׸����� ���� �ִ� �κ��� �����̰�, ���� ���� �κ��� �ٴ��̴�. �� �ٴٿ� ���� ª�� �ٸ��� ���� �� ����� �����ϰ��� �Ѵ�. ���� ª�� �ٸ���, �ٸ��� ���ڿ��� �����ϴ� ĭ�� ���� ���� ���� �ٸ��� ���Ѵ�. ���� �׸����� �� ����� �����ϴ� �ٸ��� �� �� �ִ�.



���� ���� ��� �ܿ��� �ٸ��� ���� ����� ���� ���� ������, ���� ��찡 ���� �ٸ��� ���̰� 3���� ���� ª��(���� ���̰� 3�� �ٸ� �ٸ��� ���� �� �ִ� ����� �� ���� �ִ�).

������ �־��� ��, ���� ª�� �ٸ� �ϳ��� ���� �� ����� �����ϴ� ����� ã���ÿ�.

�Է�
ù �ٿ��� ������ ũ�� N(100������ �ڿ���)�� �־�����. �� ���� N�ٿ��� N���� ���ڰ� ��ĭ�� ���̿� �ΰ� �־�����, 0�� �ٴ�, 1�� ������ ��Ÿ����. �׻� �� �� �̻��� ���� �ִ� �����͸� �Է����� �־�����.

���
ù° �ٿ� ���� ª�� �ٸ��� ���̸� ����Ѵ�.*/

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

public class N_2146 {
	static int[][] c = new int[100][100]; // �湮 ���� �� �� ��ȣ ����(�� ��ȣ 1���� ����)
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void dfs(int i, int j, int[][] A, int islandNum) {
		c[i][j] = islandNum;

		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A.length) {
				if (A[i + dx[v]][j + dy[v]] == 1 && c[i + dx[v]][j + dy[v]] == 0) {
					dfs(i + dx[v], j + dy[v], A, islandNum);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				A[i][j] = s.nextInt();
		}

		// 1. dfs�� ���� ����� ���� ���ϱ�
		int islandNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == 1 && c[i][j] == 0) {
					dfs(i, j, A, islandNum);
					islandNum++;
				}
			}
		}

		// 2. ť�� ���� ���� ����ֱ�
		Queue<Point> q = new LinkedList<Point>();
		int[][] dist = new int[N][N]; // �Ÿ� ������ ���� �迭 ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (c[i][j] != 0) {
					q.add(new Point(i, j));
				} else {
					dist[i][j] = -1;
				}
			}
		}
		int min = 200;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dx.length; i++) {
				if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A.length) {
					if (c[p.i + dx[i]][p.j + dy[i]] == 0) {
						q.offer(new Point(p.i + dx[i], p.j + dy[i]));
						c[p.i + dx[i]][p.j + dy[i]] = c[p.i][p.j];
						dist[p.i + dx[i]][p.j + dy[i]] = dist[p.i][p.j] + 1;
					} else if (c[p.i + dx[i]][p.j + dy[i]] != c[p.i][p.j]) {
						if (min > dist[p.i + dx[i]][p.j + dy[i]] + dist[p.i][p.j])
							min = dist[p.i + dx[i]][p.j + dy[i]] + dist[p.i][p.j];
					}
				}
			}
		}
		System.out.println(min);

	}

}
