//���� 2206��
//BFS���� + ����Ž��
/*����
N��M�� ��ķ� ǥ���Ǵ� ���� �ִ�. �ʿ��� 0�� �̵��� �� �ִ� ���� ��Ÿ����, 1�� �̵��� �� ���� ���� �ִ� ���� ��Ÿ����. ����� (1, 1)���� (N, M)�� ��ġ���� �̵��Ϸ� �ϴµ�, �̶� �ִ� ��η� �̵��Ϸ� �Ѵ�. �ִܰ�δ� �ʿ��� ���� ���� ������ ĭ�� ������ ��θ� ���ϴµ�, �̶� �����ϴ� ĭ�� ������ ĭ�� �����ؼ� ����.

���࿡ �̵��ϴ� ���߿� �� ���� ���� �μ��� �̵��ϴ� ���� �� �� ��ΰ� ª�����ٸ�, ���� �� �� ���� �μ��� �̵��Ͽ��� �ȴ�.

���� �־����� ��, �ִ� ��θ� ���� ���� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N(1 �� N �� 1,000), M(1 �� M �� 1,000)�� �־�����. ���� N���� �ٿ� M���� ���ڷ� ���� �־�����. (1, 1)�� (N, M)�� �׻� 0�̶�� ��������.

���
ù° �ٿ� �ִ� �Ÿ��� ����Ѵ�. �Ұ����� ���� -1�� ����Ѵ�.*/

/*���� ���̵�� -> �ð� �ʰ�
1. ���� ���� �ʰ� �̵����� ���� �ִ� �Ÿ��� ���Ѵ�.
2. ���� �ϳ��� ������, �� �������� �ִ� �Ÿ��� ���Ѵ�.*/
package ����;

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
