//���� 3055��
// BFS ����(�ִ� �Ÿ� ���ϱ�)
/*����
����� ������ ���� �̹����� ���� ���� ������ �տ� �־���, �� �ɷ��� �����غ��� ���� ��ó�� Ƽ������ ȫ���� ����Ű���� �Ѵ�. �� ������ ����ġ�� �� ���� ��� �ִ�. ����ġ�� ���� ģ�� ģ���� ����� ���� ������ ���� ������ ȫ���� ���Ϸ��� �Ѵ�.

Ƽ������ ������ R�� C���� �̷���� �ִ�. ����ִ� ���� '.'�� ǥ�õǾ� �ְ�, ���� ���ִ� ������ '*', ���� 'X'�� ǥ�õǾ� �ִ�. ����� ���� 'D'��, ����ġ�� ��ġ�� 'S'�� ��Ÿ������ �ִ�.

�� �и��� ����ġ�� ���� �ִ� ĭ�� ������ �� ĭ �� �ϳ��� �̵��� �� �ִ�. (��, �Ʒ�, ������, ����) ���� �� �и��� ����ִ� ĭ���� Ȯ���Ѵ�. ���� �ִ� ĭ�� �������ִ� ����ִ� ĭ(��� �� ���� ����)�� ���� ���� �ȴ�. ���� ����ġ�� ���� ����� �� ����. ��, ����ġ�� ���� ���ִ� �������� �̵��� �� ����, ���� ����� �ұ��� �̵��� �� ����.

Ƽ������ ������ �־����� ��, ����ġ�� �����ϰ� ����� ���� �̵��ϱ� ���� �ʿ��� �ּ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����ġ�� ���� �� ������ ĭ���� �̵��� �� ����. ��, ���� �ð��� ���� �� ������ ĭ���� ����ġ�� �̵��� �� ����. �̵��� �� ������ ����ġ�� ���� ������ �����̴�. 

�Է�
ù° �ٿ� 50���� �۰ų� ���� �ڿ��� R�� C�� �־�����.

���� R�� �ٿ��� Ƽ������ ������ �־�����, �������� ������ ���ڸ� �־�����. 'D'�� 'S'�� �ϳ����� �־�����.

���
ù° �ٿ� ����ġ�� ����� ���� �̵��� �� �ִ� ���� ���� �ð��� ����Ѵ�. ����, �����ϰ� ����� ���� �̵��� �� ���ٸ�, "KAKTUS"�� ����Ѵ�.*/

package ����;

import java.util.*;

class Point5 {
	int i;
	int j;
	int type; // 0�̸� ����ġ, 1�̸� ��������

	Point5(int i, int j, int type) {
		this.i = i;
		this.j = j;
		this.type = type;
	}
}

public class N_3055 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int R = s.nextInt();
		int C = s.nextInt();
		int[][] A = new int[R][C];
		Queue<Point5> q = new LinkedList<Point5>();
		int be_x = 0;
		int be_y = 0;
		for (int i = 0; i < R; i++) {
			String str = s.next();
			for (int j = 0; j < C; j++) {
				A[i][j] = str.charAt(j);
				if (A[i][j] == 'D') {
					be_x = i;
					be_y = j;
				}
			}
		}
		// �������� ť�� �ֱ� -> ����ġ�� ���� ���� �� ������ ĭ���� �̵� ���ϹǷ� ť�� �������̺��� ��� ���� �ٽ��̴�.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] == '*')
					q.offer(new Point5(i, j, 1));
			}
		}
		int[][] c = new int[R][C];
		// ����ġ ť�� �ֱ�
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] == 'S') {
					q.offer(new Point5(i, j, 0));
					c[i][j] = 1;
				}
			}
		}

		while (!q.isEmpty()) {
			Point5 p = q.poll();
			if (p.i == be_x && p.j == be_y)
				break;
			if (p.type == 1) {
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (A[p.i + dx[i]][p.j + dy[i]] == '.') {
							q.offer(new Point5(p.i + dx[i], p.j + dy[i], 1));
							A[p.i + dx[i]][p.j + dy[i]] = '*';
						}
					}
				}
			} else if (p.type == 0) {
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if ((A[p.i + dx[i]][p.j + dy[i]] == '.' || A[p.i + dx[i]][p.j + dy[i]] == 'D')
								&& c[p.i + dx[i]][p.j + dy[i]] == 0) {
							q.offer(new Point5(p.i + dx[i], p.j + dy[i], 0));
							c[p.i + dx[i]][p.j + dy[i]] = c[p.i][p.j] + 1;
						}
					}
				}
			}
		}
		if (c[be_x][be_y] == 0) {
			System.out.println("KAKTUS");
			System.exit(0);
		}
		System.out.println(c[be_x][be_y] - 1);

	}

}
