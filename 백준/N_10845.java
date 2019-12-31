//���� 10845��
/*
 ����
������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class N_10845 {
	// 1. ť�� ���� ������ ���
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

	// 2. ���̺귯���� �̿��ϴ� ���
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
