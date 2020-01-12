//���� 2133��
/*����
3��N ũ���� ���� 2��1, 1��2 ũ���� Ÿ�Ϸ� ä��� ����� ���� ���غ���.

�Է�
ù° �ٿ� N(1 �� N �� 30)�� �־�����.

���
ù° �ٿ� ����� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long[] d = new long[N + 1];
		d[0] = 1;
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= i; j = j + 2) {
				if (j == 2)
					d[i] += 3 * d[i - 2];
				else
					d[i] += 2 * d[i - j];
			}
		}
		System.out.println(d[N]);

	}

}
