//���� 17413��
/*����
���ڿ� S�� �־����� ��, �� ���ڿ����� �ܾ ���������� �Ѵ�.

����, ���ڿ� S�� �Ʒ��Ͱ� ���� ��Ģ�� ��Ų��.

���ĺ� �ҹ���('a'-'z'), ����('0'-'9'), ����(' '), Ư�� ����('<', '>')�θ� �̷���� �ִ�.
���ڿ��� ���۰� ���� ������ �ƴϴ�.
'<'�� '>'�� ���ڿ��� �ִ� ��� �����ư��鼭 �����ϸ�, '<'�� ���� �����Ѵ�. ��, �� ������ ������ ����.
�±״� '<'�� �����ؼ� '>'�� ������ ���̰� 3 �̻��� �κ� ���ڿ��̰�, '<'�� '>' ���̿��� ���ĺ� �ҹ��ڿ� ���鸸 �ִ�. �ܾ�� ���ĺ� �ҹ��ڿ� ���ڷ� �̷���� �κ� ���ڿ��̰�, �����ϴ� �� �ܾ�� ���� �ϳ��� �����Ѵ�. �±״� �ܾ �ƴϸ�, �±׿� �ܾ� ���̿��� ������ ����.

�Է�
ù° �ٿ� ���ڿ� S�� �־�����. S�� ���̴� 100,000 �����̴�.

���
ù° �ٿ� ���ڿ� S�� �ܾ ����� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;
import java.util.Stack;

public class N_17413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String sentence = s.nextLine() + '\n';
		Stack<Character> st = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		int is_tag = 0;

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == '<'){
				is_tag = 1;
				
				//��� �� ������ �ʿ����
				/*if(i != 0 && sentence.charAt(i-1) != '>'){
					while(!st.empty())
						result.append(st.pop());
				}*/
				while(!st.empty())
					result.append(st.pop());
			}
			

			if (is_tag == 0 && (sentence.charAt(i) == ' ' || sentence.charAt(i) == '\n')) {
				while (!st.isEmpty())
					result.append(st.pop());
				result.append(sentence.charAt(i));
				continue;
			}
			if (is_tag == 0) {
				st.push(sentence.charAt(i));
			} else if (is_tag == 1) {
				result.append(sentence.charAt(i));
			}
			if (sentence.charAt(i) == '>')
				is_tag = 0;

		}
		System.out.println(result);
	}

}
