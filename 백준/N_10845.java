//백준 10845번
/*
 문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class N_10845 {
	// 1. 큐를 직접 구현한 방법
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub BufferedReader br = new BufferedReader(new
	 * InputStreamReader(System.in)); try { int N =
	 * Integer.parseInt(br.readLine()); int[] queue = new int[10000]; int begin
	 * = 0; int end = 0; for (int i = 0; i < N; i++) { String command =
	 * br.readLine();
	 * 
	 * if (command.startsWith("push")) { String[] arr = command.split(" ");
	 * queue[end] = Integer.parseInt(arr[1]); end++; } else if
	 * (command.startsWith("pop")) { if (begin == end) { System.out.println(-1);
	 * continue; } System.out.println(queue[begin]); queue[begin] = 0; begin++;
	 * } else if (command.startsWith("size")) { System.out.println(end - begin);
	 * } else if (command.startsWith("empty")) { if (begin == end) {
	 * System.out.println(1); } else { System.out.println(0); } } else if
	 * (command.startsWith("front")) { if (begin == end) {
	 * System.out.println(-1); continue; } System.out.println(queue[begin]); }
	 * else { if (begin == end) { System.out.println(-1); continue; }
	 * System.out.println(queue[end - 1]); } } } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	// 2. 라이브러리를 이용하는 방법
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				String command = br.readLine();
				if (command.startsWith("push")) {
					String[] arr = command.split(" ");
					q.offer(Integer.parseInt(arr[1]));
				} else if (command.startsWith("pop")) {
					if (q.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(q.poll());
				} else if (command.startsWith("size")) {
					System.out.println(q.size());
				} else if (command.startsWith("empty")) {
					if (q.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
				} else if (command.startsWith("front")) {
					if (q.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(q.peek());
				} else {
					if (q.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					Iterator<Integer> it = q.iterator();
					int flag = 0;
					while (it.hasNext()) {
						int last = it.next();
						if (flag == q.size() - 1)
							System.out.println(last);
						flag++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
