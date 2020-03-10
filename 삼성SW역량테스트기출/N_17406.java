//���� 17406�� (�迭 ������ 4)
//���Ʈ ���� + �ùķ��̼� ����
/*����
ũ�Ⱑ N��M ũ���� �迭 A�� ������, �迭 A�� ���� �� �࿡ �ִ� ��� ���� �� �� �ּڰ��� �ǹ��Ѵ�. �迭 A�� �Ʒ��� ���� ��� 1���� ���� 6, 2���� ���� 4, 3���� ���� 15�̴�. ����, �迭 A�� ���� 4�̴�.

1 2 3
2 1 1
4 5 6
�迭�� ȸ�� ������ ������ �� �ִ�. ȸ�� ������ �� ���� (r, c, s)�� �̷���� �ְ�, ���� ���� �� ĭ�� (r-s, c-s), ���� ������ �Ʒ� ĭ�� (r+s, c+s)�� ���簢���� �ð� �������� �� ĭ�� �����ٴ� �ǹ��̴�. �迭�� ĭ (r, c)�� r�� c���� �ǹ��Ѵ�.

���� ���, �迭 A�� ũ�Ⱑ 6��6�̰�, ȸ�� ������ (3, 4, 2)�� ��쿡�� �Ʒ� �׸��� ���� ȸ���ϰ� �ȴ�.

A[1][1]   A[1][2] �� A[1][3] �� A[1][4] �� A[1][5] �� A[1][6]
             ��                                       ��
A[2][1]   A[2][2]   A[2][3] �� A[2][4] �� A[2][5]   A[2][6]
             ��         ��                   ��         ��
A[3][1]   A[3][2]   A[3][3]   A[3][4]   A[3][5]   A[3][6]
             ��         ��                   ��         ��
A[4][1]   A[4][2]   A[4][3] �� A[4][4] �� A[4][5]   A[4][6]
             ��                                       ��
A[5][1]   A[5][2] �� A[5][3] �� A[5][4] �� A[5][5] �� A[5][6]

A[6][1]   A[6][2]   A[6][3]   A[6][4]   A[6][5]   A[6][6]
ȸ�� ������ �� �� �̻��̸�, ������ ������ ������ ���� ���� �迭�� �ٸ���.

������ �迭 A�� ũ�Ⱑ 5��6�̰�, ȸ�� ������ (3, 4, 2), (4, 2, 1)�� ����� �����̴�.

1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
1 8 2 3 2 5
3 2 3 7 2 6
8 4 5 1 1 3
3 3 1 1 4 5
9 2 1 4 3 1
1 8 2 3 2 5
3 2 3 7 2 6
3 8 4 1 1 3
9 3 5 1 4 5
2 1 1 4 3 1
�迭 A	(3, 4, 2) ���� ���� ��	(4, 2, 1) ���� ���� ��
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
1 2 3 2 5 6
3 8 7 2 1 3
3 8 2 1 4 5
9 4 3 1 1 1
3 2 5 1 4 3
1 8 2 3 2 5
3 8 2 7 2 6
3 4 3 1 1 3
9 2 1 1 4 5
3 5 1 4 3 1
�迭 A	(4, 2, 1) ���� ���� ��	(3, 4, 2) ���� ���� ��
�迭 A�� (3, 4, 2), (4, 2, 1) ������ ������ �����ϸ� �迭 A�� ���� 12, (4, 2, 1), (3, 4, 2) ������ ������ �����ϸ� 15 �̴�.

�迭 A�� ��� ������ ȸ�� ������ �־����� ��, �迭 A�� ���� �ּڰ��� ���غ���. ȸ�� ������ ��� �� ���� ����ؾ� �ϸ�, ������ ���Ƿ� ���ص� �ȴ�.

�Է�
ù° �ٿ� �迭 A�� ũ�� N, M, ȸ�� ������ ���� K�� �־�����.

��° �ٺ��� N���� �ٿ� �迭 A�� ����ִ� �� A[i][j]�� �־�����, ���� K���� �ٿ� ȸ�� ������ ���� r, c, s�� �־�����.

���
�迭 A�� ���� �ּڰ��� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Rotate {
	int r;
	int c;
	int s;

	Rotate(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class N_17406 {
	static int[] result = new int[10];
	static int[] c = new int[10];
	static int total_min = Integer.MAX_VALUE;

	static void go(int index, int[][] A, Rotate[] ro, int K) {
		if (index == K) {
			int[][] A1 = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++)
				A1[i] = A[i].clone();
			for (int i = 0; i < K; i++) {
				int r = ro[result[i]].r;
				int c = ro[result[i]].c;
				int s = ro[result[i]].s;

				int length = 3; // ���簢�� �� ���� ����
				for (int j = 1; j <= s; j++) {
					int a = A1[r - 1 - j][c - 1 - j];
					int b = A1[r - 1 - j][c - 1 - j + (length - 1)];
					int c2 = A1[r - 1 - j + (length - 1)][c - 1 - j];
					int d = A1[r - 1 - j + (length - 1)][c - 1 - j + (length - 1)];

					// b ����
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j][c - 1 - j + (length - 1) - k] = A1[r - 1 - j][c - 1 - j + (length - 1) - k - 1];
					}
					// d ����
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + (length - 1) - k][c - 1 - j
								+ (length - 1)] = A1[r - 1 - j + (length - 1) - k - 1][c - 1 - j + (length - 1)];
					}
					// c ����
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + (length - 1)][c - 1 - j + k] = A1[r - 1 - j + (length - 1)][c - 1 - j + k + 1];
					}
					// a ����
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + k][c - 1 - j] = A1[r - 1 - j + k + 1][c - 1 - j];
					}
					A1[r - 1 - j + 1][c - 1 - j + (length - 1)] = b;
					A1[r - 1 - j + (length - 1)][c - 1 - j + (length - 1) - 1] = d;
					A1[r - 1 - j + (length - 1) - 1][c - 1 - j] = c2;
					length += 2;
				}

			}
			// �迭�� �ּ� �� ���ϱ�
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < A1.length; i++) {
				int sum = 0;
				for (int j = 0; j < A1[0].length; j++) {
					sum += A1[i][j];
				}
				if (min > sum)
					min = sum;
			}
			if (total_min > min)
				total_min = min;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			result[index] = i;
			go(index + 1, A, ro, K);
			c[i] = 0;
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int K = s.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
			}
		}
		Rotate[] ro = new Rotate[K]; // ȸ�� ���� ���� ���� �迭
		for (int i = 0; i < K; i++) {
			int r = s.nextInt();
			int c = s.nextInt();
			int st = s.nextInt();

			ro[i] = new Rotate(r, c, st);
		}
		go(0, A, ro, K);
		System.out.println(total_min);
	}

}
