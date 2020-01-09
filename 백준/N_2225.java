//���� 2225��
/*����
0���� N������ ���� K���� ���ؼ� �� ���� N�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

������ ������ �ٲ� ���� �ٸ� ���� ����(1+2�� 2+1�� ���� �ٸ� ���). ���� �� ���� ���� ���� �� �� ���� �ִ�.

�Է�
ù° �ٿ� �� ���� N(1 �� N �� 200), K(1 �� K �� 200)�� �־�����.

���
ù° �ٿ� ���� 1,000,000,000���� ���� �������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_2225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		long[][] d = new long[N + 1][K + 1];
		for (int i = 0; i <= N; i++)
			d[i][1] = 1;
		for(int i=1;i<=K;i++){
			d[0][i] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int k = 2; k <= K; k++) {
				for (int j = 0; j <= i; j++)
					d[i][k] += d[i - j][k - 1];
				d[i][k] %= 1000000000;
			}
		}
		System.out.println(d[N][K]);
	}

}
