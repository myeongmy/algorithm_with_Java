//���� 16940��
/*����
BOJ���� ������ ���������� ��쿡�� ����� ������ ����Ѵ�. ����� ������ ������ ����� ���� �����ϴ� �ڵ带 ���ؼ� ���� ������ �����ϴ� ����̴�. ������ ����� ���� �ڵ带 �ϳ� �������� �Ѵ�.

������ ������ N�̰�, ������ 1���� N���� ��ȣ�� �Ű����ִ� ����� �׷����� ���� ��, BFS �˰����� ������ ���� ���·� �̷���� �ִ�.

ť�� ���� ������ �ִ´�. �� �������� ���� ������ 1�̴�. 1�� �湮�ߴٰ� ó���Ѵ�.
ť�� ��� ���� ���� ���� ������ �ݺ��Ѵ�.
ť�� ����ִ� ù ������ ť���� ������. �� ������ x��� ����.
x�� ����Ǿ� ������, ���� �湮���� ���� ���� y�� ��� ť�� �ִ´�. ��� y�� �湮�ߴٰ� ó���Ѵ�.
2-2 �ܰ迡�� �湮���� ���� ������ �湮�ϴ� ������ �߿����� �ʴ�. ����, BFS�� ����� ���������� ���� �� �ִ�.

Ʈ���� �־����� ��, �ùٸ� BFS �湮 �������� ���غ���.

�Է�
ù° �ٿ� ������ �� N(2 �� N �� 100,000)�� �־�����. ��° �ٺ��� N-1���� �ٿ��� Ʈ���� ���� ������ �־�����. ������ �ٿ��� BFS �湮 ������ �־�����. BFS �湮 ������ �׻� N���� ������ �̷���� ������, 1���� N���� �ڿ����� �� ���� �����Ѵ�.

���
�Է����� �־��� BFS �湮 ������ �ùٸ� ������ 1, �ƴϸ� 0�� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_16940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		ArrayList<Integer> ex = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			ex.add(s.nextInt());

		int[] c = new int[N + 1]; // �湮 ���� ����
		Queue<Integer> q = new LinkedList<Integer>();
		// bfs
		c[ex.get(0)] = 1;
		q.offer(ex.get(0));
		if (ex.get(0) != 1) { // �� �κ��� �߰��ϴ� �������� ����Ǿ���.
			System.out.println(0);
			System.exit(0);
		}
		ex.remove(0);
		while (!q.isEmpty()) {
			int a = q.poll();
			int num = 0;
			for (int k : adlist[a]) {
				if (c[k] == 0)
					num++;
			}
			for (int i = 0; i < num; i++) {
				if (adlist[a].contains(ex.get(0)) && c[ex.get(0)] == 0) {
					q.offer(ex.get(0));
					c[ex.get(0)] = 1;
					ex.remove(0);
				} else {
					System.out.println(0);
					System.exit(0);
				}
			}
		}
		if (ex.size() == 0)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
