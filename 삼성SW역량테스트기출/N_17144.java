//���� 17144��
//ť�� �̿��� �ùķ��̼� ����
/*����
�̼������� �����ϱ� ���� ������� ����û���⸦ ��ġ�Ϸ��� �Ѵ�. ����û������ ������ �׽�Ʈ�ϱ� ���� ������� ���� ũ�Ⱑ R��C�� ���������� ��Ÿ�°�, 1��1 ũ���� ĭ���� ������. ������� �پ �ڵ� �Ƿ��� �̿��� �� ĭ (r, c)�� �ִ� �̼������� ���� �ǽð����� ����͸��ϴ� �ý����� �����ߴ�. (r, c)�� r�� c���� �ǹ��Ѵ�.



����û����� �׻� ���� ���� ��ġ�Ǿ� �ְ�, ũ��� �� ���� �����Ѵ�. ����û���Ⱑ ��ġ�Ǿ� ���� ���� ĭ���� �̼������� �ְ�, (r, c)�� �ִ� �̼������� ���� Ar,c�̴�.

1�� ���� �Ʒ� ���� ���� ������� �Ͼ��.

�̼������� Ȯ��ȴ�. Ȯ���� �̼������� �ִ� ��� ĭ���� ���ÿ� �Ͼ��.
(r, c)�� �ִ� �̼������� ������ �� �������� Ȯ��ȴ�.
������ ���⿡ ����û���Ⱑ �ְų�, ĭ�� ������ �� �������δ� Ȯ���� �Ͼ�� �ʴ´�.
Ȯ��Ǵ� ���� Ar,c/5�̰� �Ҽ����� ������.
(r, c)�� ���� �̼������� ���� Ar,c - (Ar,c/5)��(Ȯ��� ������ ����) �̴�.
����û���Ⱑ �۵��Ѵ�.
����û���⿡���� �ٶ��� ���´�.
���� ����û������ �ٶ��� �ݽð�������� ��ȯ�ϰ�, �Ʒ��� ����û������ �ٶ��� �ð�������� ��ȯ�Ѵ�.
�ٶ��� �Ҹ� �̼������� �ٶ��� ������ ��� �� ĭ�� �̵��Ѵ�.
����û���⿡�� �δ� �ٶ��� �̼������� ���� �ٶ��̰�, ����û����� �� �̼������� ��� ��ȭ�ȴ�.


���� ������ �־����� ��, T�ʰ� ���� �� ������� �濡 �����ִ� �̼������� ���� ���غ���.

�Է�
ù° �ٿ� R, C, T (6 �� R, C �� 50, 1 �� T �� 1,000) �� �־�����.

��° �ٺ��� R���� �ٿ� Ar,c (-1 �� Ar,c �� 1,000)�� �־�����. ����û���Ⱑ ��ġ�� ���� Ar,c�� -1�̰�, ������ ���� �̼������� ���̴�. -1�� 2�� ���Ʒ��� �پ��� �ְ�, ���� �� ��, �Ʒ� ��� �� ĭ�̻� ������ �ִ�.

���
ù° �ٿ� T�ʰ� ���� �� ����� �濡 �����ִ� �̼������� ���� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Point5 {
	int i;
	int j;
	int amount;

	Point5(int i, int j, int amount) {
		this.i = i;
		this.j = j;
		this.amount = amount;
	}
}

public class N_17144 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Point5[] m;

	static void up_circulate(int[][] A) {
		int x1 = A[m[0].i][m[0].j];
		int x2 = A[m[0].i][A[0].length - 1];
		int x3 = A[0][A[0].length - 1];
		int x4 = A[0][0];

		for (int i = A[0].length - 1; i > 0; i--) {
			if (i == 1) {
				A[m[0].i][1] = 0;
				break;
			}
			A[m[0].i][i] = A[m[0].i][i - 1];
		}
		for (int i = 0; i < m[0].i; i++) {
			if (i == m[0].i - 1) {
				A[i][A[0].length - 1] = x2;
				break;
			}
			A[i][A[0].length - 1] = A[i + 1][A[0].length - 1];
		}
		for (int i = 0; i < A[0].length - 1; i++) {
			if (i == A[0].length - 2) {
				A[0][i] = x3;
				break;
			}
			A[0][i] = A[0][i + 1];
		}
		for (int i = m[0].i; i > 0; i--) {
			if (i == 1) {
				A[i][0] = x4;
				break;
			}
			if (i == m[0].i)
				continue;
			A[i][0] = A[i - 1][0];
		}
	}

	static void down_circulate(int[][] A) {
		int x1 = A[m[1].i][m[1].j];
		int x2 = A[m[1].i][A[0].length - 1];
		int x3 = A[A.length - 1][A[0].length - 1];
		int x4 = A[A.length - 1][0];

		for (int i = A[0].length - 1; i > 0; i--) {
			if (i == 1) {
				A[m[1].i][1] = 0;
				break;
			}
			A[m[1].i][i] = A[m[1].i][i - 1];
		}
		for (int i = A.length - 1; i > m[1].i; i--) {
			if (i == m[1].i + 1) {
				A[i][A[0].length - 1] = x2;
				break;
			}
			A[i][A[0].length - 1] = A[i - 1][A[0].length - 1];
		}
		for (int i = 0; i < A[0].length - 1; i++) {
			if (i == A[0].length - 2) {
				A[A.length - 1][i] = x3;
				break;
			}
			A[A.length - 1][i] = A[A.length - 1][i + 1];
		}
		for (int i = m[1].i; i < A.length - 1; i++) {
			if (i == m[1].i)
				continue;
			if (i == A.length - 2) {
				A[i][0] = x4;
				break;
			}
			A[i][0] = A[i + 1][0];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int R = s.nextInt();
		int C = s.nextInt();
		int T = s.nextInt();
		int[][] A = new int[R][C];
		m = new Point5[2]; // ����û������ ��ġ ����
		Queue<Point5> q = new LinkedList<Point5>();
		int a = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == -1) {
					m[a] = new Point5(i, j, 0);
					a++;
				}
			}
		}
		while (T != 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] != -1 && A[i][j] != 0)
						q.offer(new Point5(i, j, A[i][j]));
				}
			}
			while (!q.isEmpty()) {
				Point5 p = q.poll();
				int count = 0;
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (A[p.i + dx[i]][p.j + dy[i]] != -1) {
							count++;
							A[p.i + dx[i]][p.j + dy[i]] += p.amount / 5;
						}
					}
				}
				A[p.i][p.j] -= (p.amount / 5) * count;
			}
			// ���� ��ȯ
			up_circulate(A);
			// �Ʒ��� ��ȯ
			down_circulate(A);
			T--;
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] != -1)
					sum += A[i][j];
			}
		}
		System.out.println(sum);

	}

}
