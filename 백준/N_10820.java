//���� 10820��
/*����
���ڿ� N���� �־�����. �̶�, ���ڿ��� ���ԵǾ� �ִ� �ҹ���, �빮��, ����, ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�� ���ڿ��� ���ĺ� �ҹ���, �빮��, ����, �������θ� �̷���� �ִ�.

�Է�
ù° �ٺ��� N��° �ٱ��� ���ڿ��� �־�����. (1 �� N �� 100) ���ڿ��� ���̴� 100�� ���� �ʴ´�.

���
ù° �ٺ��� N��° �ٱ��� ������ ���ڿ��� ���ؼ� �ҹ���, �빮��, ����, ������ ������ �������� ������ ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String sentence = s.nextLine();
			int[] num = new int[4];
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z')
					num[0]++;
				else if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z')
					num[1]++;
				else if (sentence.charAt(i) >= '0' && sentence.charAt(i) <= '9')
					num[2]++;
				else
					num[3]++;
			}
			for (int i = 0; i < num.length; i++) {
				if (i == num.length - 1)
					System.out.println(num[i]);
				else
					System.out.print(num[i] + " ");
			}
		}
	}

}
