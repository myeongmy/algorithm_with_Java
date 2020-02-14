//���� 17142�� (������ 3)
//BFS + ���Ʈ ����(����) ����
/*����
��ü�� ġ������ ���̷����� �����ϴ� �����ҿ� �¿��̰� ħ���߰�, ���̷����� �����Ϸ��� �Ѵ�. ���̷����� Ȱ�� ���¿� ��Ȱ�� ���°� �ִ�. ���� ó���� ��� ���̷����� ��Ȱ�� �����̰�, Ȱ�� ������ ���̷����� �����¿�� ������ ��� �� ĭ���� ���ÿ� �����Ǹ�, 1�ʰ� �ɸ���. �¿��̴� �������� ���̷��� M���� Ȱ�� ���·� �����Ϸ��� �Ѵ�.

�����Ҵ� ũ�Ⱑ N��N�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1��1 ũ���� ���簢������ �������� �ִ�. �����Ҵ� �� ĭ, ��, ���̷����� �̷���� ������, ���� ĭ �ϳ��� ���� �����Ѵ�. Ȱ�� ���̷����� ��Ȱ�� ���̷����� �ִ� ĭ���� ���� ��Ȱ�� ���̷����� Ȱ������ ���Ѵ�.

���� ���, �Ʒ��� ���� �����Ұ� ���� ��츦 ���캸��. 0�� �� ĭ, 1�� ��, 2�� ���̷����� ��ġ�̴�.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2
M = 3�̰�, ���̷����� �Ʒ��� ���� Ȱ�� ���·� ������ ��� 6�ʸ� ��� ĭ�� ���̷����� �۶߸� �� �ִ�. ���� -, ��Ȱ�� ���̷����� *, Ȱ�� ���̷����� 0, �� ĭ�� ���̷����� ������ �ð����� ǥ���ߴ�.

* 6 5 4 - - 2
5 6 - 3 - 0 1
4 - - 2 - 1 2
3 - 2 1 2 2 3
2 2 1 0 1 - -
1 - 2 1 2 3 4
0 - 3 2 3 4 *
�ð��� �ּҰ� �Ǵ� ����� �Ʒ��� ����, 4�ʸ��� ��� ĭ�� ���̷����� �۶߸� �� �ִ�.

0 1 2 3 - - 2
1 2 - 3 - 0 1
2 - - 2 - 1 2
3 - 2 1 2 2 3
3 2 1 0 1 - -
4 - 2 1 2 3 4
* - 3 2 3 4 *
�������� ���°� �־����� ��, ��� �� ĭ�� ���̷����� �۶߸��� �ּ� �ð��� ���غ���.

�Է�
ù° �ٿ� �������� ũ�� N(4 �� N �� 50), ���� �� �ִ� ���̷����� ���� M(1 �� M �� 10)�� �־�����.

��° �ٺ��� N���� �ٿ� �������� ���°� �־�����. 0�� �� ĭ, 1�� ��, 2�� ���̷����� ���� �� �ִ� ��ġ�̴�. 2�� ������ M���� ũ�ų� ����, 10���� �۰ų� ���� �ڿ����̴�.

���
�������� ��� �� ĭ�� ���̷����� �ְ� �Ǵ� �ּ� �ð��� ����Ѵ�. ���̷����� ��� ���Ƶ� ��� �� ĭ�� ���̷����� �۶߸� �� ���� ��쿡�� -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_17142 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static char[][] A;
	static int min = 100000;    //min�� 1000���� ��Ƽ� ����������.

	static void go(int index, int selected, ArrayList<Point> list, int M) {
		if (selected == M) {
			// �迭 ����
			char[][] B = new char[A.length][A[0].length];
			for (int i = 0; i < B.length; i++)
				B[i] = A[i].clone();

			// BFS
			Queue<Point> q = new LinkedList<Point>();
			int[][] c = new int[A.length][A[0].length];
			for (int i = 0; i < result.size(); i++) {
				B[list.get(result.get(i)).i][list.get(result.get(i)).j] = '0';
				q.offer(new Point(list.get(result.get(i)).i, list.get(result.get(i)).j));
				c[list.get(result.get(i)).i][list.get(result.get(i)).j] = 1;
			}

			while (!q.isEmpty()) {
				Point p = q.poll();

				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < B.length && p.j + dy[i] >= 0 && p.j + dy[i] < B[0].length) {
						if (c[p.i + dx[i]][p.j + dy[i]] == 0 && B[p.i + dx[i]][p.j + dy[i]] != '1') {    //���� �ƴϸ� ��Ȱ�� ���̷��� �����ε� �������� �� ����
							q.offer(new Point(p.i + dx[i], p.j + dy[i]));
							c[p.i + dx[i]][p.j + dy[i]] = c[p.i][p.j] + 1;
						}
					}
				}
			}
			// �ִ밪 ���ϱ� �� ��� �� �������� Ȯ��
			int max = -1;
			for (int i = 0; i < B.length; i++) {
				for (int j = 0; j < B[0].length; j++) {
					if (B[i][j] != '*' && c[i][j] > max)    //�� ������ ��Ȱ�� ���¿��� �κ��� ����ϸ� �ȵǹǷ� ���� �߰�
						max = c[i][j];
					if (B[i][j] == '0' && c[i][j] == 0)
						return;
				}
			}
			if (min > max-1)
				min = max - 1;

			return;
		}
		if (index >= list.size())
			return;
		result.add(index);
		go(index + 1, selected + 1, list, M);
		result.remove(result.size() - 1);

		go(index + 1, selected, list, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		A = new char[N][N];
		ArrayList<Point> list = new ArrayList<Point>(); // Ȱ�� ���̷����� ���� �� �ִ� ��ġ ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.next().charAt(0);
				if (A[i][j] == '2') {
					list.add(new Point(i, j));
					A[i][j] = '*';
				}
			}
		}
		// M�� ����
		go(0, 0, list, M);
		if (min == 100000) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(min);
	}

}
