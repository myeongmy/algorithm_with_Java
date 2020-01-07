//���� 2745��
/*����
B���� �� N�� �־�����. �� ���� 10�������� �ٲ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

10������ �Ѿ�� ������ ���ڷ� ǥ���� �� ���� �ڸ��� �ִ�. �̷� ��쿡�� ������ ���� ���ĺ� �빮�ڸ� ����Ѵ�.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

�Է�
ù° �ٿ� N�� B�� �־�����. (2 �� B �� 36)

B���� �� N�� 10�������� �ٲٸ�, �׻� 10�ﺸ�� �۰ų� ����.

���
ù° �ٿ� B���� �� N�� 10�������� ����Ѵ�.*/

package codingtest_study.����;

import java.util.HashMap;
import java.util.Scanner;

public class N_2745 {
	static HashMap<Character, Integer> hm = new HashMap<Character, Integer>() {
		{
			put('A', 10);
			put('B', 11);
			put('C', 12);
			put('D', 13);
			put('E', 14);
			put('F', 15);
			put('G', 16);
			put('H', 17);
			put('I', 18);
			put('J', 19);
			put('K', 20);
			put('L', 21);
			put('M', 22);
			put('N', 23);
			put('O', 24);
			put('P', 25);
			put('Q', 26);
			put('R', 27);
			put('S', 28);
			put('T', 29);
			put('U', 30);
			put('V', 31);
			put('W', 32);
			put('X', 33);
			put('Y', 34);
			put('Z', 35);
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String num = s.next();
		int B = s.nextInt();
		int flag = 0;
		long result = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
				result += (num.charAt(i) - 48) * (long) Math.pow(B, flag);
			else
				result += hm.get(num.charAt(i)) * (long) Math.pow(B, flag);
			flag++;
		}
		System.out.println(result);
	}

}
