//���� 11725��
/*����
��Ʈ ���� Ʈ���� �־�����. �̶�, Ʈ���� ��Ʈ�� 1�̶�� ������ ��, �� ����� �θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����� ���� N (2 �� N �� 100,000)�� �־�����. ��° �ٺ��� N-1���� �ٿ� Ʈ�� �󿡼� ����� �� ������ �־�����.

���
ù° �ٺ��� N-1���� �ٿ� �� ����� �θ� ��� ��ȣ�� 2�� ������ ������� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_11725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		int[] parent = new int[N + 1]; // �θ� ��� ����
		// bfs Ǯ��
		int[] c = new int[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		c[1] = 1;
		q.offer(1);

		while (!q.isEmpty()) {
			int a = q.poll();

			for (int t : adlist[a]) {
				if (c[t] == 0) {
					c[t] = 1;
					q.offer(t);
					parent[t] = a;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

}
