//���� 1261��
/*����
�˰��� ����� ��� �̷ο� ������. �̷δ� N*M ũ���̸�, �� 1*1ũ���� ������ �̷���� �ִ�. �̷δ� �� �� �Ǵ� ������ �̷���� �ְ�, �� ���� �����Ӱ� �ٴ� �� ������, ���� �μ��� ������ �̵��� �� ����.

�˰��� ����� ������������, �׻� ��� ���� �濡 �־�� �Ѵ�. ��, ���� ���� �ٸ� �濡 ���� ���� ����. � �濡�� �̵��� �� �ִ� ���� �����¿�� ������ �� ���̴�. ��, ���� ����� (x, y)�� ���� ��, �̵��� �� �ִ� ���� (x+1, y), (x, y+1), (x-1, y), (x, y-1) �̴�. ��, �̷��� ������ �̵� �� ���� ����.

���� ��ҿ��� �̵��� �� ������, �˰����� ���� AOJ�� �̿��� ���� �μ��� ���� �� �ִ�. ���� �μ���, �� ��� ������ ������ ���Ѵ�.

���� �� ������ �˰��̿� �ִٸ�, ������� �ñ��� ���� sudo�� �̿��� ���� �� ���� �� ���ֹ��� �� ������, ��Ÿ���Ե� �� ������ Baekjoon Online Judge�� ���ϵǾ� �ֱ� ������, sudo�� ����� �� ����.

���� (1, 1)�� �ִ� �˰��� ����� (N, M)���� �̵��Ϸ��� ���� �ּ� �� �� �μ���� �ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �̷��� ũ�⸦ ��Ÿ���� ���� ũ�� M, ���� ũ�� N (1 �� N, M �� 100)�� �־�����. ���� N���� �ٿ��� �̷��� ���¸� ��Ÿ���� ���� 0�� 1�� �־�����. 0�� �� ���� �ǹ��ϰ�, 1�� ���� �ǹ��Ѵ�.

(1, 1)�� (N, M)�� �׻� �շ��ִ�.

���
ù° �ٿ� �˰��� ����� (N, M)���� �̵��ϱ� ���� ���� �ּ� �� �� �μ���� �ϴ��� ����Ѵ�.*/

package ����;

import java.util.*;

class Algo {
	int i;
	int j;
	int cnt;

	Algo(int i, int j, int cnt) {
		this.i = i;
		this.j = j;
		this.cnt = cnt;
	}
}

public class N_1261 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();

		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++)
				A[i][j] = str.charAt(j) - 48;
		}

		// bfs Ǯ��
		int[][] c = new int[N][M]; 
		ArrayDeque<Algo> q = new ArrayDeque<Algo>();

		c[0][0] = 1;
		q.offerLast(new Algo(0, 0, 0));

		while (!q.isEmpty()) {
			Algo a = q.poll();
			if (a.i == N - 1 && a.j == M - 1) {
				System.out.println(a.cnt);
				System.exit(0);
			}
			for (int i = 0; i < dx.length; i++) {
				if (a.i + dx[i] >= 0 && a.i + dx[i] < A.length && a.j + dy[i] >= 0
						&& a.j + dy[i] < A[0].length) {
					if (A[a.i + dx[i]][a.j + dy[i]] == 0 && c[a.i + dx[i]][a.j + dy[i]] == 0) {
						q.offerFirst(new Algo(a.i + dx[i], a.j + dy[i], a.cnt));
						c[a.i + dx[i]][a.j + dy[i]] = 1;
					}
					if (A[a.i + dx[i]][a.j + dy[i]] == 1 && c[a.i + dx[i]][a.j + dy[i]] == 0) {
						q.offerLast(new Algo(a.i + dx[i], a.j + dy[i], a.cnt + 1));
						c[a.i + dx[i]][a.j + dy[i]] = 1;
					}
				}
			}
		}
		System.out.println(min);
	}

}
