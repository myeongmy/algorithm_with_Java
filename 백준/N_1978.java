//���� 1978��
/*����
�־��� �� N�� �߿��� �Ҽ��� �� ������ ã�Ƽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù �ٿ� ���� ���� N�� �־�����. N�� 100�����̴�. �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.

���
�־��� ���� �� �Ҽ��� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1978 {
	static boolean is_prime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int primeNum = 0;
		for (int i = 0; i < N; i++) {
			boolean result = is_prime(s.nextInt());
			if (result == true)
				primeNum++;
		}
		System.out.println(primeNum);

	}

}
