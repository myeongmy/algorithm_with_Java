//���� 1149��
/*����
RGB�Ÿ��� ��� ������� ���� ����, �ʷ�, �Ķ��߿� �ϳ��� ĥ�Ϸ��� �Ѵ�. ����, �׵��� ��� �̿��� ���� ������ ĥ�� �� ���ٴ� ��Ģ�� ���ߴ�. �� i�� �̿��� �� i-1�� �� i+1�̰�, ù ���� ������ ���� �̿��� �ƴϴ�.

�� ���� �������� ĥ�� �� ��� ���, �ʷ����� ĥ�� �� ��� ���, �Ķ����� ��� ����� �־��� ��, ��� ���� ĥ�ϴ� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� �� N�� �־�����. N�� 1,000���� �۰ų� ����. ��° �ٺ��� N���� �ٿ� �� ���� ��������, �ʷ�����, �Ķ����� ĥ�ϴ� ����� �־�����. ����� 1,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ��� ���� ĥ�ϴ� ����� �ּڰ��� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][3];
		int[][] d = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = s.nextInt();
				if (i == 0)
					d[i][j] = A[0][j];
			}
		}
		for (int i = 1; i < N; i++) {
			if (d[i - 1][1] <= d[i - 1][2])
				d[i][0] = d[i - 1][1] + A[i][0];
			else
				d[i][0] = d[i - 1][2] + A[i][0];

			if (d[i - 1][0] <= d[i - 1][2])
				d[i][1] = d[i - 1][0] + A[i][1];
			else
				d[i][1] = d[i - 1][2] + A[i][1];

			if (d[i - 1][0] <= d[i - 1][1])
				d[i][2] = d[i - 1][0] + A[i][2];
			else
				d[i][2] = d[i - 1][1] + A[i][2];
		}

		int min = d[N - 1][0];
		for (int i = 0; i < 3; i++) {
			if (min > d[N - 1][i])
				min = d[N - 1][i];
		}
		System.out.println(min);
	}

}
