//���� 11653��
/*����
���� N�� �־����� ��, ���μ������ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N (1 �� N �� 10,000,000)�� �־�����.

���
N�� ���μ����� ����� �� �ٿ� �ϳ��� ������������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		if (N > 1) {
			System.out.println(N);
		}
	}

}
