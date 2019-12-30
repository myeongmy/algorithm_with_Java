//���� 1874��
/*
 ����
���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. ������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.

1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. �̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. ������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. �̸� ����ϴ� ���α׷��� �ۼ��϶�.

�Է�
ù �ٿ� n (1 �� n �� 100,000)�� �־�����. ��° �ٺ��� n���� �ٿ��� ������ �̷�� 1�̻� n������ ������ �ϳ��� ������� �־�����. ���� ���� ������ �� �� ������ ���� ����.

���
�Էµ� ������ ����� ���� �ʿ��� ������ �� �ٿ� �� ���� ����Ѵ�. push������ +��, pop ������ -�� ǥ���ϵ��� �Ѵ�. �Ұ����� ��� NO�� ����Ѵ�.
*/

package codingtest_study.����;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class N_1874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		LinkedList<Character> list = new LinkedList<Character>();
		int N = s.nextInt();
		int lastIn = 0;
		for (int i = 0; i < N; i++) {
			int num = s.nextInt();

			if (st.empty() || num > st.peek()) {
				if (st.empty()) {
					for (int j = lastIn + 1; j <= num; j++) {
						st.push(j);
						list.add('+');
					}
					st.pop();
					list.add('-');
					lastIn = num;
				} else {

					for (int j = lastIn + 1; j <= num; j++) {
						st.push(j);
						list.add('+');
					}
					st.pop();
					list.add('-');
					lastIn = num;
				}
			} else if (num == st.peek()) {
				st.pop();
				list.add('-');
			} else {
				System.out.println("NO");
				System.exit(0); // �������� ����
			}
		}
		while (!list.isEmpty()) {
			System.out.println(list.get(0));
			list.remove(0);
		}
	}

}
