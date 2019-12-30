//백준 10828번
/*
 문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
*/

package codingtest_study.백준;

import java.util.Scanner;
import java.util.Stack;

public class N_10828 {
	/*
	 * // 라이브러리 사용하지 않고 구현 static int[] stack = new int[10000]; static int size
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
	// 라이브러리 사용해서 구현
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
