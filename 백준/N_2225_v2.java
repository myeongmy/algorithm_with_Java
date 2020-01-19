//���� 2225��
/*����
0���� N������ ���� K���� ���ؼ� �� ���� N�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

������ ������ �ٲ� ���� �ٸ� ���� ����(1+2�� 2+1�� ���� �ٸ� ���). ���� �� ���� ���� ���� �� �� ���� �ִ�.

�Է�
ù° �ٿ� �� ���� N(1 �� N �� 200), K(1 �� K �� 200)�� �־�����.

���
ù° �ٿ� ���� 1,000,000,000���� ���� �������� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_2225_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		long[][] d = new long[N + 1][201];

		for (int i = 1; i <= 200; i++) {
			d[1][i] = i;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= 200; j++) {
				d[i][j] = d[i - 1][j] + d[i][j - 1];
				d[i][j] %= 1000000000;
			}
		}
		System.out.println(d[N][K]);
	}

}
