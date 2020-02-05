//���� 14502��
//BFS ����
/*����
��ü�� ġ������ ���̷����� �����ϴ� �����ҿ��� ���̷����� ����Ǿ���. ������ ���̷����� ���� ������ �ʾҰ�, ���̷����� Ȯ���� ���� ���ؼ� �����ҿ� ���� ������� �Ѵ�.

�����Ҵ� ũ�Ⱑ N��M�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1��1 ũ���� ���簢������ �������� �ִ�. �����Ҵ� �� ĭ, ������ �̷���� ������, ���� ĭ �ϳ��� ���� �����Ѵ�. 

�Ϻ� ĭ�� ���̷����� �����ϸ�, �� ���̷����� �����¿�� ������ �� ĭ���� ��� �������� �� �ִ�. ���� ���� �� �ִ� ���� ������ 3���̸�, �� 3���� ������ �Ѵ�.

���� ���, �Ʒ��� ���� �����Ұ� ���� ��츦 ���캸��.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
�̶�, 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ���̴�. �ƹ��� ���� ������ �ʴ´ٸ�, ���̷����� ��� �� ĭ���� �������� �� �ִ�.

2�� 1��, 1�� 2��, 4�� 6���� ���� ����ٸ� ������ ����� �Ʒ��� �������� �ȴ�.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
���̷����� ���� ���� ����� �Ʒ��� ��������.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
���� 3�� ���� ��, ���̷����� ���� �� ���� ���� ���� �����̶�� �Ѵ�. ���� �������� ���� ������ ũ��� 27�̴�.

�������� ������ �־����� �� ���� �� �ִ� ���� ���� ũ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 8)

��° �ٺ��� N���� �ٿ� ������ ����� �־�����. 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ��ġ�̴�. 2�� ������ 2���� ũ�ų� ����, 10���� �۰ų� ���� �ڿ����̴�.

�� ĭ�� ������ 3�� �̻��̴�.

���
ù° �ٿ� ���� �� �ִ� ���� ������ �ִ� ũ�⸦ ����Ѵ�.*/

package ����;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_14502 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] result = new int[5];
	static ArrayList<Point> list2 = new ArrayList<Point>(); // 1�� �ִ� �κ� �ε��� ���� �صа�
	static Queue<Point> q = new LinkedList<Point>();
	static int max = -1;

	static void go(int index, int selected, ArrayList<Point> list, int[][] A) {
		if (selected == 3) {
			int[][] visited = new int[A.length][A[0].length];
			for (int i = 0; i < visited.length; i++)
				visited[i] = A[i].clone();

			// �� ����
			for (int i = 0; i < selected; i++) {
				visited[list.get(result[i]).i][list.get(result[i]).j] = 1;
			}

			// bfs ����
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if(visited[i][j] == 2)
						q.offer(new Point(i, j));
				}
				
			}
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (visited[p.i + dx[i]][p.j + dy[i]] == 0) {
							visited[p.i + dx[i]][p.j + dy[i]] = 2;
							q.offer(new Point(p.i + dx[i], p.j + dy[i]));
						}
					}
				}
			}

			// 0�� ���� ���
			int numZero = 0;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if (visited[i][j] == 0)
						numZero++;
				}
			}

			if (max < numZero)
				max = numZero;

			return;
		}
		if (index >= list.size())
			return;

		result[selected] = index;
		go(index + 1, selected + 1, list, A);
		result[selected] = 0;

		go(index + 1, selected, list, A);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		ArrayList<Point> list = new ArrayList<Point>(); // 0�� �ִ� �κ� �ε��� ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 0)
					list.add(new Point(i, j));
				if (A[i][j] == 2)
					q.offer(new Point(i, j));
				if (A[i][j] == 1)
					list2.add(new Point(i, j));
			}
		}

		// ����Ʈ���� �� �� ����
		go(0, 0, list, A);

		System.out.println(max);
	}

}
