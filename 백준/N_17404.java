//���� 17404��
/*����
RGB�Ÿ��� ��� ������� ���� ����, �ʷ�, �Ķ��߿� �ϳ��� ĥ�Ϸ��� �Ѵ�. ����, �׵��� ��� �̿��� ���� ������ ĥ�� �� ���ٴ� ��Ģ�� ���ߴ�. �� i�� �̿��� �� i-1�� �� i+1�̰�, ù ���� ������ ���� �̿��̴�.

�� ���� �������� ĥ�� �� ��� ���, �ʷ����� ĥ�� �� ��� ���, �Ķ����� ��� ����� �־��� ��, ��� ���� ĥ�ϴ� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� �� N�� �־�����. N�� 1,000���� �۰ų� ����. ��° �ٺ��� N���� �ٿ� �� ���� ��������, �ʷ�����, �Ķ����� ĥ�ϴ� ����� �־�����. ����� 1,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ��� ���� ĥ�ϴ� ����� �ּڰ��� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_17404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = s.nextInt();
			}
		}
		int[][] d = new int[N + 1][3];
		int result = 1000 * 1000 + 1;
		for (int i = 0; i < 3; i++) {
			// 1�� �� ���� �Ѱ��� ������ �����Ѵ�.
			// d[1][0] = A[1][i];
			// d[1][1] = A[1][i];
			// d[1][2] = A[1][i];
			for (int z = 0; z < 3; z++) {
				if (z == i)
					d[1][z] = A[1][i];
				else
					d[1][z] = 1000 * 1000 + 1;
			}

			for (int j = 2; j <= N; j++) {
				d[j][0] = (int) Math.min(d[j - 1][1], d[j - 1][2]) + A[j][0];
				d[j][1] = (int) Math.min(d[j - 1][0], d[j - 1][2]) + A[j][1];
				d[j][2] = (int) Math.min(d[j - 1][0], d[j - 1][1]) + A[j][2];

			}
			for (int k = 0; k < 3; k++) {
				if (i == k)
					continue;
				result = Math.min(result, d[N][k]);
			}

		}
		System.out.println(result);
	}

}
