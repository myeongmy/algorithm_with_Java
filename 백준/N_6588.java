//���� 6588��
/*����
1742��, ������ �Ƹ��߾� ���а� ũ����Ƽ�� ������� �����ϸ�Ʈ ���Ϸ����� ������ ���� ������ �����ϴ� ������ ���´�.

4���� ū ��� ¦���� �� Ȧ�� �Ҽ��� ������ ��Ÿ�� �� �ִ�.
���� ��� 8�� 3 + 5�� ��Ÿ�� �� �ְ�, 3�� 5�� ��� Ȧ���� �Ҽ��̴�. ��, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 �̴�.

�� ������ ������ �ذ���� ���� �����̴�.

�鸸 ������ ��� ¦���� ���ؼ�, �� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� �ϳ� �Ǵ� �� �̻��� �׽�Ʈ ���̽��� �̷���� �ִ�. �׽�Ʈ ���̽��� ������ 100,000���� ���� �ʴ´�.

�� �׽�Ʈ ���̽��� ¦�� ���� n �ϳ��� �̷���� �ִ�. (6 �� n �� 1000000)

�Է��� ������ �ٿ��� 0�� �ϳ� �־�����.

���
�� �׽�Ʈ ���̽��� ���ؼ�, n = a + b ���·� ����Ѵ�. �̶�, a�� b�� Ȧ�� �Ҽ��̴�. ���ڿ� �����ڴ� ���� �ϳ��� ���еǾ��� �ִ�. ����, n�� ���� �� �ִ� ����� ���� �������, b-a�� ���� ū ���� ����Ѵ�. ��, �� Ȧ�� �Ҽ��� ������ n�� ��Ÿ�� �� ���� ��쿡�� "Goldbach's conjecture is wrong."�� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_6588 {
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
		boolean[] check = new boolean[1000001];
		check[0] = true;
		check[1] = true;
		// �����佺�׳׽��� ü �̿�
		for (int i = 2; i * i <= 1000000; i++) {
			if (check[i] == false) {
				for (int j = 2; i * j <= 1000000; j++)
					check[i * j] = true;
			}
		}
		
		int n;
		int a;
		int b;
		while ((n = s.nextInt()) != 0) {

			for (int i = 2; i <= n; i++) {
				if (check[i] == false) {
					a = i;
					b = n - a;
					if (is_prime(b)) {
						System.out.println(n + " = " + a + " + " + b);
						break;
					}
				}
				if (i == n)
					System.out.println("Goldbach's conjecture is wrong.");
			}
		}

	}

}
