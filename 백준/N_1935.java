//���� 1935��
/*����
���� ǥ��İ� �� �ǿ����ڿ� �����ϴ� ������ �־��� ���� ��, �� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ǿ������� ����(1 �� N �� 26) �� �־�����. �׸��� ��° �ٿ��� ���� ǥ����� �־�����. (���⼭ �ǿ����ڴ� A~Z�� ���빮���̸�, A���� ������� N���� ���빮�ڸ��� ���Ǹ�, ���̴� 100�� ���� �ʴ´�) �׸��� ��° �ٺ��� N+2��° �ٱ����� �� �ǿ����ڿ� �����ϴ� ���� �־�����. (3��° �ٿ��� A�� �ش��ϴ� ��, 4��° �ٿ��� B�� �ش��ϴ°� , 5��° �ٿ��� C ...�� �־�����, �׸��� �ǿ����ڿ� ���� �ϴ� ���� �����̴�)

���
��� ����� �Ҽ��� ��° �ڸ����� ����Ѵ�.*/

package codingtest_study.����;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class N_1935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		Stack<Double> st = new Stack<Double>();
		int N = s.nextInt();
		String sentence = s.next();

		for (int i = 0; i < N; i++) {
			char start = (char) ('A' + i); // ���� ���� �� int���� ���� Ÿ���� int�� ���U�Ǿ� �����
			hm.put(start, s.nextInt());
		}
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') {
				st.push((double) hm.get(sentence.charAt(i)));
			} else {
				double first = st.pop();
				double second = st.pop();
				double result = 0;
				switch (sentence.charAt(i)) {
				case '+':
					result = first + second;
					break;
				case '-':
					result = second - first;
					break;
				case '*':
					result = first * second;
					break;
				case '/':
					result = (double) second / first;
				}
				st.push(result);
			}
		}
		System.out.printf("%.2f", st.pop());
	}

}
