//���� 2089��
/*����
-2������ ��ȣ ���� 2������ ǥ���� �ȴ�. 2���������� 20, 21, 22, 23�� ǥ�� ������ -2���������� (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8�� ǥ���Ѵ�. 10������ 1���� ǥ�����ڸ� 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 ���̴�.

10������ ���� �Է� �޾Ƽ� -2������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù �ٿ� 10�������� ǥ���� �� N(-2,000,000,000��N��2,000,000,000)�� �־�����.

���
-2���� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;


public class N_2089 {
	static StringBuilder result = new StringBuilder();

	static void func1(long num) {
		if (num == 0)
			return;
		if (num < 0 && (long) Math.abs(num) % 2 == 1) {
			func1(((long) Math.abs(num) + 1) / 2);
			result.append(1);
		} else {
			func1(num / -2);
			result.append(num % -2);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long num = s.nextLong();
		if (num == 0)
			System.out.println(0);
		else {
			func1(num);
			System.out.println(result);
		}

	}

}
