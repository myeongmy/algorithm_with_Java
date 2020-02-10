//���� 16236�� (�Ʊ� ���)
//BFS+�ùķ��̼� ����
/*����
N��N ũ���� ������ ����� M������ �Ʊ� ��� 1������ �ִ�. ������ 1��1 ũ���� ���簢�� ĭ���� �������� �ִ�. �� ĭ���� ����Ⱑ �ִ� 1���� �����Ѵ�.

�Ʊ� ���� ������ ��� ũ�⸦ ������ �ְ�, �� ũ��� �ڿ����̴�. ���� ó���� �Ʊ� ����� ũ��� 2�̰�, �Ʊ� ���� 1�ʿ� �����¿�� ������ �� ĭ�� �̵��Ѵ�.

�Ʊ� ���� �ڽ��� ũ�⺸�� ū ����Ⱑ �ִ� ĭ�� ������ �� ����, ������ ĭ�� ��� ������ �� �ִ�. �Ʊ� ���� �ڽ��� ũ�⺸�� ���� ����⸸ ���� �� �ִ�. ����, ũ�Ⱑ ���� ������ ���� �� ������, �� ����Ⱑ �ִ� ĭ�� ������ �� �ִ�.

�Ʊ� �� ���� �̵����� �����ϴ� ����� �Ʒ��� ����.

�� �̻� ���� �� �ִ� ����Ⱑ ������ ���ٸ� �Ʊ� ���� ���� ���� ������ ��û�Ѵ�.
���� �� �ִ� ����Ⱑ 1�������, �� ����⸦ ������ ����.
���� �� �ִ� ����Ⱑ 1�������� ���ٸ�, �Ÿ��� ���� ����� ����⸦ ������ ����.
�Ÿ��� �Ʊ� �� �ִ� ĭ���� ����Ⱑ �ִ� ĭ���� �̵��� ��, �������ϴ� ĭ�� ������ �ּڰ��̴�.
�Ÿ��� ����� ����Ⱑ ���ٸ�, ���� ���� �ִ� �����, �׷��� ����Ⱑ �����������, ���� ���ʿ� �ִ� ����⸦ �Դ´�.
�Ʊ� ����� �̵��� 1�� �ɸ���, ����⸦ �Դµ� �ɸ��� �ð��� ���ٰ� �����Ѵ�. ��, �Ʊ� �� ���� �� �ִ� ����Ⱑ �ִ� ĭ���� �̵��ߴٸ�, �̵��� ���ÿ� ����⸦ �Դ´�. ����⸦ ������, �� ĭ�� �� ĭ�� �ȴ�.

�Ʊ� ���� �ڽ��� ũ��� ���� ���� ����⸦ ���� �� ���� ũ�Ⱑ 1 �����Ѵ�. ���� ���, ũ�Ⱑ 2�� �Ʊ� ���� ����⸦ 2���� ������ ũ�Ⱑ 3�� �ȴ�.

������ ���°� �־����� ��, �Ʊ� �� �� �� ���� ���� ���� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ũ�� N(2 �� N �� 20)�� �־�����.

��° �ٺ��� N���� �ٿ� ������ ���°� �־�����. ������ ���´� 0, 1, 2, 3, 4, 5, 6, 9�� �̷���� �ְ�, �Ʒ��� ���� �ǹ̸� ������.

0: �� ĭ
1, 2, 3, 4, 5, 6: ĭ�� �ִ� ������� ũ��
9: �Ʊ� ����� ��ġ
�Ʊ� ���� ������ �� ���� �ִ�.

���
ù° �ٿ� �Ʊ� �� ���� ���� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ� �ð��� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Shark {
	int i; // �Ʊ� ����� ���� ��ġ
	int j;
	int size; // ũ��
	int ate; // ���� ����� ��

	Shark(int i, int j, int size, int ate) {
		this.i = i;
		this.j = j;
		this.size = size;
		this.ate = ate;
	}

}

class Point3 implements Comparable<Point3> {
	int i;
	int j;
	int cnt;

	Point3(int i, int j, int cnt) {
		this.i = i;
		this.j = j;
		this.cnt = cnt;
	}

	public int compareTo(Point3 p) {
		if (this.cnt < p.cnt) {
			return -1;
		} else if (this.cnt > p.cnt) {
			return 1;
		} else {
			if (this.i < p.i)
				return -1;
			else if (this.i == p.i) {
				if (this.j < p.j)
					return -1;
				else
					return 1;

			} else
				return 1;
		}
	}
}

public class N_16236 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		Shark sh = new Shark(0, 0, 2, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 9) {
					sh.i = i;
					sh.j = j;
				}

			}
		}

		int time = 0;
		while (true) {

			int[][] c = new int[N][N];
			PriorityQueue<Point3> q = new PriorityQueue<Point3>();
			int flag = 0;

			c[sh.i][sh.j] = 1;
			q.offer(new Point3(sh.i, sh.j, 0));

			while (!q.isEmpty()) {
				Point3 p = q.poll();
				if (A[p.i][p.j] != 0 && A[p.i][p.j] < sh.size) {
					A[sh.i][sh.j] = 0;
					sh.i = p.i;
					sh.j = p.j;
					sh.ate++;
					time += p.cnt;
					flag = 1;
					A[p.i][p.j] = 0;
					break;
				}
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < N && p.j + dy[i] >= 0 && p.j + dy[i] < N) {
						if (A[p.i + dx[i]][p.j + dy[i]] <= sh.size && c[p.i + dx[i]][p.j + dy[i]] == 0) {
							c[p.i + dx[i]][p.j + dy[i]] = 1;
							q.offer(new Point3(p.i + dx[i], p.j + dy[i], p.cnt + 1));

						}
					}
				}
			}
			if (sh.ate == sh.size) {
				sh.size++;
				sh.ate = 0;
			}
			if (flag == 0)
				break;
		}
		System.out.println(time);
	}

}
