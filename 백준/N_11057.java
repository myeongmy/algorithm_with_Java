//���� 11057��
/*����
������ ���� ���� �ڸ��� ���������� �̷�� ���� ���Ѵ�. �̶�, ������ ���� ���Ƶ� ������������ ģ��.

���� ���, 2234�� 3678, 11119�� ������ ��������, 2232, 3676, 91111�� ������ ���� �ƴϴ�.

���� ���� N�� �־����� ��, ������ ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� 0���� ������ �� �ִ�.

�Է�
ù° �ٿ� N (1 �� N �� 1,000)�� �־�����.

���
ù° �ٿ� ���̰� N�� ������ ���� ������ 10,007�� ���� �������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long[][] d = new long[N + 1][10];
		for (int i = 0; i < d[0].length; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < d[0].length; j++) {
				for(int k=j;k>=0;k--){
					d[i][j] += d[i-1][k];
				}
				d[i][j] %= 10007;
			}
		}
		long sum = 0;
		for (int i = 0; i < d[0].length; i++)
			sum += d[N][i];
		System.out.println(sum%10007);
	}

}
