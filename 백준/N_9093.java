//���� 9093��
/*
 ����
������ �־����� ��, �ܾ ��� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �ܾ��� ������ �ٲ� �� ����. �ܾ�� ���� ���ĺ����θ� �̷���� �ִ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, ������ �ϳ� �־�����. �ܾ��� ���̴� �ִ� 20, ������ ���̴� �ִ� 1000�̴�. �ܾ�� �ܾ� ���̿��� ������ �ϳ� �ִ�.

���
�� �׽�Ʈ ���̽��� ���ؼ�, �Է����� �־��� ������ �ܾ ��� ������ ����Ѵ�.
*/

package codingtest_study.����;

import java.util.Scanner;
import java.util.Stack;

public class N_9093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		int T = s.nextInt();
		s.nextLine();
		for (int i = 0; i < T; i++) {
			String sentence = s.nextLine();
			for (int j = 0; j < sentence.length(); j++) {
				if (sentence.charAt(j) == ' ') {
					while (!st.empty())
						System.out.print(st.pop());
					System.out.print(sentence.charAt(j));
				} else {
					st.push(sentence.charAt(j));
				}
			}

			// nextLine()�� enter�� �о������ �ʱ� ������ �������� push�� �� pop���ֱ�
			while (!st.empty())
				System.out.print(st.pop());
			System.out.println();
		}
	}

}
