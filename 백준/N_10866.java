//���� 10866��
/*����
������ �����ϴ� ��(Deque)�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push_front X: ���� X�� ���� �տ� �ִ´�.
push_back X: ���� X�� ���� �ڿ� �ִ´�.
pop_front: ���� ���� �տ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
pop_back: ���� ���� �ڿ� �ִ� ���� ����, �� ���� ����Ѵ�. ����, ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���� ����ִ� ������ ������ ����Ѵ�.
empty: ���� ��������� 1��, �ƴϸ� 0�� ����Ѵ�.
front: ���� ���� �տ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ���� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ���� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. �Ѥ� �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_10866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
			for (int i = 0; i < N; i++) {
				String command = br.readLine();
				if (command.startsWith("push_front")) {
					String[] arr = command.split(" ");
					deque.offerFirst(Integer.parseInt(arr[1]));

				} else if (command.startsWith("push_back")) {
					String[] arr = command.split(" ");
					deque.offerLast(Integer.parseInt(arr[1]));
				} else if (command.startsWith("pop_front")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(deque.pollFirst());
				} else if (command.startsWith("pop_back")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(deque.pollLast());
				} else if (command.startsWith("size")) {
					System.out.println(deque.size());
				} else if (command.startsWith("empty")) {
					if (deque.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
				} else if (command.startsWith("front")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(deque.peekFirst());
				} else if (command.startsWith("back")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(deque.peekLast());
				}
			}
		} catch (IOException e) {

		}
	}

}
