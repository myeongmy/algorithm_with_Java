//���� 10809��
/*����
���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. ������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ܾ� S�� �־�����. �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ��ڷθ� �̷���� �ִ�.

���
������ ���ĺ��� ���ؼ�, a�� ó�� �����ϴ� ��ġ, b�� ó�� �����ϴ� ��ġ, ... z�� ó�� �����ϴ� ��ġ�� �������� �����ؼ� ����Ѵ�.

����, � ���ĺ��� �ܾ ���ԵǾ� ���� �ʴٸ� -1�� ����Ѵ�. �ܾ��� ù ��° ���ڴ� 0��° ��ġ�̰�, �� ��° ���ڴ� 1��° ��ġ�̴�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String S = s.nextLine();
		int[] freq = new int[26];
		for (int i = 0; i < freq.length; i++)
			freq[i] = -1;
		for (int i = 0; i < S.length(); i++) {
			if (freq[S.charAt(i) - 97] == -1)
				freq[S.charAt(i) - 97] = i;
			else
				continue;
		}
		for (int i = 0; i < freq.length; i++) {
			if (i == freq.length - 1)
				System.out.println(freq[i]);
			else
				System.out.print(freq[i] + " ");
		}
	}

}
