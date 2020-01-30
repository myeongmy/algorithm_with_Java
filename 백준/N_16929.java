//���� 16929��
/*����
Two Dots�� Playdots, Inc.���� ���� �����̴�. ������ ���� �ܰ�� ũ�Ⱑ N��M�� ������ ������ ����ȴ�.



������ ĭ�� ���� ĥ���� ���� �ϳ��� �ִ�. �� ������ �ٽ��� ���� ������ �̷���� ����Ŭ�� ã�� ���̴�.

������ ���� �����ǿ��� ���� �� �ִ� ����Ŭ�� �����̴�.

	
�� k�� d1, d2, ..., dk�� �̷���� ����Ŭ�� ���Ǵ� �Ʒ��� ����.

��� k���� ���� ���� �ٸ���. 
k�� 4���� ũ�ų� ����.
��� ���� ���� ����.
��� 1 �� i �� k-1�� ���ؼ�, di�� di+1�� �����ϴ�. ��, dk�� d1�� �����ؾ� �Ѵ�. �� ���� �����ϴٴ� ���� ������ ���� ����ִ� ĭ�� ���� �����Ѵٴ� �ǹ��̴�.
�������� ���°� �־����� ��, ����Ŭ�� �����ϴ��� �ƴ��� ���غ���.

�Է�
ù° �ٿ� �������� ũ�� N, M�� �־�����. ��° �ٺ��� N���� �ٿ� �������� ���°� �־�����. �������� ��� ������ ������ �ְ�, �������� ���´� ���� ���� �ǹ��Ѵ�. ���� ���� ���ĺ� �빮�� �� �����̴�.

���
����Ŭ�� �����ϴ� ��쿡�� "Yes", ���� ��쿡�� "No"�� ����Ѵ�.*/

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

public class N_16929 {
	static int[][] c = new int[50][50]; // �湮 ���� ����
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void dfs(int i, int j, int selected, char[][] A, Point[] result) {
		if (selected >= 4) {
			if (Math.abs(result[selected - 1].i - result[0].i) + Math.abs(result[selected - 1].j - result[0].j) == 1) {
				System.out.println("Yes");
				System.exit(0);
			}
			
		}
		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A[0].length) {
				if (A[i + dx[v]][j + dy[v]] == A[i][j] && c[i + dx[v]][j + dy[v]] == 0) {
					result[selected] = new Point(i + dx[v], j + dy[v]);
					c[i + dx[v]][j + dy[v]] = 1;
					dfs(i + dx[v], j + dy[v], selected + 1, A, result);
					c[i + dx[v]][j + dy[v]] = 0;
				}
			}
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		char[][] A = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Point[] result = new Point[3000];  //��Ÿ�ӿ����� ����
				result[0] = new Point(i, j);
				c[i][j] = 1;
				dfs(i, j, 1, A, result);

			}
		}
		System.out.println("No");
	}

}
