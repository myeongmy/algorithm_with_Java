//���� 10808��
/*����
���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. �� ���ĺ��� �ܾ �� ���� ���ԵǾ� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ܾ� S�� �־�����. �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.

���
�ܾ ���ԵǾ� �ִ� a�� ����, b�� ����, ��, z�� ������ �������� �����ؼ� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String S = s.nextLine();
		int[] freq = new int[26]; // �󵵼� ����
		for (int i = 0; i < S.length(); i++) {
			freq[S.charAt(i) - 97]++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (i == freq.length - 1)
				System.out.println(freq[i]);
			else
				System.out.print(freq[i] + " ");
		}
	}

}
