//���� 10828��
/*
 ����
������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� �ټ� �����̴�.

push X: ���� X�� ���ÿ� �ִ� �����̴�.
pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
*/

package codingtest_study.����;

import java.util.Scanner;
import java.util.Stack;

public class N_10828 {
	/*
	 * // ���̺귯�� ������� �ʰ� ���� static int[] stack = new int[10000]; static int size
	 * = 0;
	 * 
	 * static void push(int num) { stack[size] = num; size++; }
	 * 
	 * static void pop() { if (size == 0) System.out.println(-1); else {
	 * System.out.println(stack[size - 1]); size--; }
	 * 
	 * }
	 * 
	 * static void isEmpty() { if (size == 0) System.out.println(1); else
	 * System.out.println(0); }
	 * 
	 * static void top() { if (size == 0) { System.out.println(-1); } else {
	 * System.out.println(stack[size - 1]); } }
	 * 
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub Scanner s = new Scanner(System.in); int N = s.nextInt(); for (int i
	 * = 0; i <= N; i++) { String command = s.nextLine(); if
	 * (command.startsWith("push")) { String[] arr = command.split(" ");
	 * push(Integer.parseInt(arr[1])); } else if (command.startsWith("pop")) {
	 * pop(); } else if (command.startsWith("size")) { System.out.println(size);
	 * } else if (command.startsWith("empty")) { isEmpty(); } else if
	 * (command.startsWith("top")) { top(); } } }
	 */
	// ���̺귯�� ����ؼ� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		s.nextLine();
		Stack st = new Stack();
		for (int i = 0; i < N; i++) {
			String command = s.nextLine();
			if (command.startsWith("push")) {
				String[] arr = command.split(" ");
				st.push(Integer.parseInt(arr[1]));
			} else if (command.startsWith("pop")) {
				if (st.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(st.pop());
				}

			} else if (command.startsWith("size")) {
				System.out.println(st.size());
			} else if (command.startsWith("empty")) {
				if (st.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command.startsWith("top")) {
				if(st.size() == 0)
					System.out.println(-1);
				else
					System.out.println(st.peek());
			}
		}
	}

}
