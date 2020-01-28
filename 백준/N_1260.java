//���� 1260��
/*����
�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.

�Է�
ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.

���
ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.*/

package ����;

import java.util.*;

public class N_1260 {
	static boolean[] c = new boolean[1001];
	static boolean[] c1 = new boolean[1001];
	static Queue<Integer> q = new LinkedList<Integer>();

	static void go(int v, ArrayList<Integer>[] adlist) {
		if (c[v]) {
			return;
		}
		c[v] = true;
		System.out.print(v + " ");

		for (int a : adlist[v]) {
			if (c[a] == false)
				go(a, adlist);
		}
	}

	static void bfs(int v, ArrayList<Integer>[] adlist) {
		c1[v] = true;
		q.offer(v);
		while (!q.isEmpty()) {
			int a = q.poll();
			System.out.print(a + " ");
			for (int i : adlist[a]) {
				if (c1[i] == false) {
					q.offer(i);
					c1[i] = true;
				}

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int V = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 1; i <= M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		for (int i = 1; i <= N; i++)
			Collections.sort(adlist[i]);
		go(V, adlist);
		System.out.println();
		bfs(V, adlist);
		System.out.println();
	}

}
