//���� 10844��
/*����
45656�̶� ���� ����.

�� ���� ������ ��� �ڸ����� ���̰� 1�� ����. �̷� ���� ��� ����� �Ѵ�.

�����̴� ���� ���̰� N�� ��� ���� �� �� �ִ��� �ñ�������.

N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)

�Է�
ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ������ 1,000,000,000���� ���� �������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long[][] d = new long[N + 1][10];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j - 1 >= 0 && j + 1 <= 9) {
					d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];
					if (i == 1)
						d[i][j] = 1;
				} else {
					if (j + 1 > 9){
						d[i][j] = d[i - 1][j - 1];
						if(i == 1) d[i][j] = 1;
					}else
						d[i][j] = d[i - 1][j + 1];
				}
				d[i][j] %= 1000000000;
			}

		}
		long result = 0;
		for (int i = 0; i <= 9; i++)
			result += d[N][i];
		System.out.println(result % 1000000000);
	}

}
