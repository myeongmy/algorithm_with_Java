//���� 1373��
/*����
2������ �־����� ��, 8������ ��ȯ�ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� 2������ �־�����. �־����� ���� ���̴� 1,000,000�� ���� �ʴ´�.

���
ù° �ٿ� �־��� ���� 8������ ��ȯ�Ͽ� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String num = s.nextLine();
		StringBuilder sb = new StringBuilder();
		if (num.length() % 3 == 1) {
			sb.append(num.charAt(0));
		} else if (num.length() % 3 == 2) {
			sb.append(Integer.toString(2 * (num.charAt(0) - 48) + (num.charAt(1) - 48)));
		}
		for (int i = num.length() % 3; i + 3 <= num.length(); i += 3) {
			int a = (num.charAt(i) - 48) * 4 + (num.charAt(i + 1) - 48) * 2 + (num.charAt(i + 2) - 48);
			sb.append(Integer.toString(a));
		}
		System.out.println(sb);
	}

}
