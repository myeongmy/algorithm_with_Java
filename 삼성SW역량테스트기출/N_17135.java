//���� 17135�� (ĳ�� ���潺)
//�ùķ��̼� ����
/*����
ĳ�� ���潺�� ���� ���� �������� ���� ��� �� ����� �����̴�. ������ ����Ǵ� ���� ũ�Ⱑ N��M�� ���������� ��Ÿ�� �� �ִ�. �������� 1��1 ũ���� ĭ���� �������� �ְ�, �� ĭ�� ���Ե� ���� ���� �ִ� �ϳ��̴�. �������� N������ �ٷ� �Ʒ�(N+1�� ��)�� ��� ĭ���� ���� �ִ�.

���� �����Լ� ��Ű�� ���� �ü� 3���� ��ġ�Ϸ��� �Ѵ�. �ü��� ���� �ִ� ĭ�� ��ġ�� �� �ְ�, �ϳ��� ĭ���� �ִ� 1���� �ü��� ���� �� �ִ�. ������ �ϸ��� �ü��� �� �ϳ��� ������ �� �ְ�, ��� �ü��� ���ÿ� �����Ѵ�. �ü��� �����ϴ� ���� �Ÿ��� D������ �� �߿��� ���� ����� ���̰�, �׷��� ���� ������ ��쿡�� ���� ���ʿ� �ִ� ���� �����Ѵ�. ���� ���� ���� �ü����� ���ݴ��� �� �ִ�. ���ݹ��� ���� ���ӿ��� ���ܵȴ�. �ü��� ������ ������, ���� �̵��Ѵ�. ���� �Ʒ��� �� ĭ �̵��ϸ�, ���� �ִ� ĭ���� �̵��� ��쿡�� ���ӿ��� ���ܵȴ�. ��� ���� �����ǿ��� ���ܵǸ� ������ ������. 

���� ������ ���ٽ��� �ü��� ��ġ�� ������ ���� ������ �������ִ�. ����, �� ������ �ü��� ��ġ�� �߿��ϴ�. �������� ���°� �־����� ��, �ü��� �������� ������ �� �ִ� ���� �ִ� ���� ����غ���.

�������� �� ��ġ (r1, c1), (r2, c2)�� �Ÿ��� |r1-r2| + |c1-c2|�̴�.

�Է�
ù° �ٿ� ������ ���� �� N, ���� �� M, �ü��� ���� �Ÿ� ���� D�� �־�����. ��° �ٺ��� N���� �ٿ��� �������� ���°� �־�����. 0�� �� ĭ, 1�� ���� �ִ� ĭ�̴�.

���
ù° �ٿ� �ü��� �������� ������ �� �ִ� ���� �ִ� ���� ����Ѵ�.*/

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

public class N_17135 {
	static LinkedList<Point> enemy;
	static int[] result = new int[5];
	static int max_cnt = 0;
	static int cnt;
	static int N;
	static int M;
	static int D;

	static void go(int index, int selected, int[][] A) {
		if (selected == 3) {
			Queue<Point> q = new LinkedList<Point>(); // �̹� �Ͽ� ������ ���� ��ġ
			int[][] B = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++)
				B[i] = A[i].clone();
			cnt = 0;
			while (true) {
				int numOfOne = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (B[i][j] == 1) {
							numOfOne++;
							enemy.offer(new Point(i, j));
						}
					}
				}
				if (numOfOne == 0) // ��������
					break;
				for (int i = 0; i < 3; i++) {
					int min_dist = 10000;
					Point min_po = new Point(-1, -1);
					for (int j = 0; j < enemy.size(); j++) {
						int dist = Math.abs(enemy.get(j).i - N) + Math.abs(enemy.get(j).j - result[i]);
						if (dist <= D && min_dist > dist) {
							min_dist = dist;
							min_po.i = enemy.get(j).i;
							min_po.j = enemy.get(j).j;
						} else if (dist <= D && min_dist == dist && min_po.j > enemy.get(j).j) {
							min_po.i = enemy.get(j).i;
							min_po.j = enemy.get(j).j;
						}
					}
					q.offer(new Point(min_po.i, min_po.j));
				}
				// �� ����
				while (!q.isEmpty()) {
					Point p = q.poll();
					if (p.i != -1 && p.j != -1 && B[p.i][p.j] == 1) {
						B[p.i][p.j] = 0;
						cnt++;
					}

				}

				// �� ������
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (B[i][j] == 1) {
							B[i][j] = 0;
							if (i + 1 < N)
								B[i + 1][j] = 1;
						}
					}
				}
				enemy.clear();
			}
			if (max_cnt < cnt) {
				max_cnt = cnt;
			}
			return;
		}
		if (index >= M )
			return;
		result[selected] = index;
		go(index + 1, selected + 1, A);
		result[selected] = 0;

		go(index + 1, selected, A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		D = s.nextInt(); // �ü��� ���� �Ÿ� ����
		int[][] A = new int[N][M];
		enemy = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 1)
					enemy.offer(new Point(i, j));
			}
		}
		go(0, 0, A);
		System.out.println(max_cnt);
	}

}
