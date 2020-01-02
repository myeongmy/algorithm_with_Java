//���� 1918��
/*����
������ �Ϲ������� 3���� ǥ������� ǥ���� �� �ִ�. �����ڰ� �ǿ����� ��� ��ġ�ϴ� ���� ǥ���(�Ϲ������� �츮�� ���� ����̴�), �����ڰ� �ǿ����� �տ� ��ġ�ϴ� ���� ǥ���(prefix notation), �����ڰ� �ǿ����� �ڿ� ��ġ�ϴ� ���� ǥ���(postfix notation)�� �װ��̴�. ���� ��� ���� ǥ������� ǥ���� a+b�� ���� ǥ������δ� +ab�̰�, ���� ǥ������δ� ab+�� �ȴ�.

�� �������� �츮�� �ٷ� ǥ����� ���� ǥ����̴�. ���� ǥ����� ������ ���� ���� ���� �����ڰ� �ǿ����� �ڿ� ��ġ�ϴ� ����̴�. �� ����� ������ ������ ����. �츮�� ���� ���� ���� ǥ��� ���� ��쿡�� ������ ������ �켱������ ���̰� �־� ���ʺ��� ���ʷ� ����� �� ������ ���� ǥ����� ����ϸ� ������ ������ �����Ͽ� ������ ������ �� �ִ�. ���� ���� ������� ��ȣ � �ʿ� ���� �ȴ�. ���� ��� a+b*c�� ���� ǥ������� �ٲٸ� abc*+�� �ȴ�.

���� ǥ����� ���� ǥ������� �ٲٴ� ����� ������ �����ϸ� �̷���. �켱 �־��� ���� ǥ����� �������� �켱������ ���� ��ȣ�� �����ش�. �׷� ������ ��ȣ ���� �����ڸ� ��ȣ�� ���������� �Ű��ָ� �ȴ�.

���� ��� a+b*c�� (a+(b*c))�� �İ� ���� �ȴ�. �� ������ �ȿ� �ִ� ��ȣ�� ������ *�� ��ȣ ������ ������ �Ǹ� (a+bc*)�� �ȴ�. ���������� �� +�� ��ȣ�� ���������� ��ġ�� abc*+�� �ǰ� �ȴ�.

�ٸ� ���� ��� �׸����� ǥ���ϸ� A+B*C-D/E�� �����ϰ� ��ȣ�� ���� �����ڸ� �̵���ų ��Ҹ� ǥ���ϸ� ������ ���� �ȴ�.



�̷��� ����� �˰� ���� ǥ����� �־����� �� ���� ǥ������� ��ġ�� ���α׷��� �ۼ��Ͻÿ�

�Է�
ù° �ٿ� ���� ǥ����� �־�����. �� �� ������ �ǿ����ڴ� A~Z�� ���ڷ� �̷������ ���Ŀ��� �� ������ �����Ѵ�. �׸��� -A+B�� ���� -�� ���� �տ� ���ų� AB�� ���� *�� �����Ǵ� ���� ������ �־����� �ʴ´�. ǥ����� ���ĺ� �빮�ڿ� +, -, *, /, (, )�θ� �̷���� ������, ���̴� 100�� ���� �ʴ´�. 

���
ù° �ٿ� ���� ǥ������� �ٲ� ���� ����Ͻÿ�*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class N_1918 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('+', 0);
		hm.put('-', 0);
		hm.put('*', 1);
		hm.put('/', 1);
		hm.put('(', -1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sentence = br.readLine();
			Stack<Character> st = new Stack<Character>();
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < sentence.length(); i++) {
				if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') {
					result.append(sentence.charAt(i));
				} else {
					if (st.empty() || sentence.charAt(i) == '(') {
						st.push(sentence.charAt(i));
						continue;
					}
					if (sentence.charAt(i) == ')') {
						while (st.peek() != '(') {
							result.append(st.pop());
						}
						st.pop();
						continue;
					}
					while (hm.get(st.peek()) >= hm.get(sentence.charAt(i))) {
						result.append(st.pop());
						if (st.empty())
							break;
					}
					st.push(sentence.charAt(i));
				}
			}
			while(!st.empty())
				result.append(st.pop());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
