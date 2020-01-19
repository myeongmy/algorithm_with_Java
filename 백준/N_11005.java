//���� 11005��
/*����
10���� �� N�� �־�����. �� ���� B�������� �ٲ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

10������ �Ѿ�� ������ ���ڷ� ǥ���� �� ���� �ڸ��� �ִ�. �̷� ��쿡�� ������ ���� ���ĺ� �빮�ڸ� ����Ѵ�.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

�Է�
ù° �ٿ� N�� B�� �־�����. (2 �� B �� 36) N�� 10�ﺸ�� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� 10���� �� N�� B�������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.HashMap;
import java.util.Scanner;

public class N_11005 {
	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>() {
		{
			put(10, 'A');
			put(11, 'B');
			put(12, 'C');
			put(13, 'D');
			put(14, 'E');
			put(15, 'F');
			put(16, 'G');
			put(17, 'H');
			put(18, 'I');
			put(19, 'J');
			put(20, 'K');
			put(21, 'L');
			put(22, 'M');
			put(23, 'N');
			put(24, 'O');
			put(25, 'P');
			put(26, 'Q');
			put(27, 'R');
			put(28, 'S');
			put(29, 'T');
			put(30, 'U');
			put(31, 'V');
			put(32, 'W');
			put(33, 'X');
			put(34, 'Y');
			put(35, 'Z');
		}
	};

	static void func1(long N, int B) {
		if (N == 0)
			return;
		func1(N / B, B);
		if (N % B >= 0 && N % B <= 9)
			System.out.print(N % B);
		else{
			System.out.print(hm.get((int)(N%B)));
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		long N = s.nextLong();
		int B = s.nextInt();
		func1(N, B);
	}

}
