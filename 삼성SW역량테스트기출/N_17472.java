//���� 17472�� (�ٸ� ����� 2)
//bfs + ���� Ž�� ����
/*����
������ �̷���� ���� �ְ�, ��� ���� �ٸ��� �����Ϸ��� �Ѵ�. �� ������ ������ N��M ũ���� ������ ���ڷ� ��Ÿ�� �� �ְ�, ������ �� ĭ�� ���̰ų� �ٴ��̴�.

���� ����� ���� �����¿�� �پ��ִ� ����� ���ϰ�, �Ʒ� �׸��� �� ���� ������ �̷���� �����̴�. ��ĥ�Ǿ��ִ� ĭ�� ���̴�.


�ٸ��� �ٴٿ��� �Ǽ��� �� �ְ�, �ٸ��� ���̴� �ٸ��� ���ڿ��� �����ϴ� ĭ�� ���̴�. �ٸ��� �����ؼ� ��� ���� �����Ϸ��� �Ѵ�. �� A���� �ٸ��� ���� �� B�� �� �� ���� ��, �� A�� B�� ����Ǿ��ٰ� �Ѵ�. �ٸ��� �� ���� ���� ������ �ٴ� ���� �־�� �ϰ�, �� �ٸ��� ������ �߰��� �ٲ�� �ȵȴ�. ��, �ٸ��� ���̴� 2 �̻��̾�� �Ѵ�.

�ٸ��� ������ �߰��� �ٲ�� �ȵǱ� ������, �ٸ��� ������ ���� �Ǵ� ���ΰ� �� �� �ۿ� ����. ������ ������ �ٸ��� �ٸ��� �� ���� ���� �������� ���� �����ؾ� �ϰ�, ������ ������ �ٸ��� �ٸ��� �� ���� ���� �������� ���� �����ؾ� �Ѵ�.

�� A�� B�� �����ϴ� �ٸ��� �߰��� �� C�� ������ �ٴٸ� �������� ��쿡 �� C�� A, B�� ����Ǿ��ִ� ���� �ƴϴ�. 

�Ʒ� �׸��� ���� ��� �����ϴ� �ùٸ� 2���� ����̰�, �ٸ��� ȸ������ ��ĥ�Ǿ� �ִ�. ���� ����, �ٸ��� ���ĺ� �빮�ڷ� �����ߴ�.

	
�ٸ��� �� ����: 13

D�� 2�� 4�� �����ϴ� �ٸ��̰�, 3���� ����Ǿ� ���� �ʴ�.

�ٸ��� �� ����: 9 (�ּ�)

������ �ùٸ��� ���� 3���� ����̴�
		

C�� ������ �߰��� �ٲ����	D�� ���̰� 1�̴�.	���� �ٸ��� A�� 1�� ���η� ����Ǿ� ���� �ʴ�.
�ٸ��� �����ϴ� ��찡 ���� ���� �ִ�. �����ϴ� �ٸ��� ���̸� ����� ���� �� ĭ�� �� �ٸ��� ���̿� ��� ���ԵǾ�� �Ѵ�. �Ʒ��� �ٸ��� �����ϴ� ���� ��Ÿ �ٸ� ��쿡 ���� 2���� �����̴�.


 	
A�� ���̴� 4�̰�, B�� ���̵� 4�̴�.

�� �ٸ��� �� ����: 4 + 4 + 2 = 10

�ٸ� A: 2�� 3�� ���� (���� 2)

�ٸ� B: 3�� 4�� ���� (���� 3)

�ٸ� C: 2�� 5�� ���� (���� 5)

�ٸ� D: 1�� 2�� ���� (���� 2)

�� ����: 12

������ ������ �־����� ��, ��� ���� �����ϴ� �ٸ� ������ �ּڰ��� ���غ���.

�Է�
ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. ��° �ٺ��� N���� �ٿ� ������ ������ �־�����. �� ���� M���� ���� �̷���� ������, ���� 0 �Ǵ� 1�̴�. 0�� �ٴ�, 1�� ���� �ǹ��Ѵ�.

���
��� ���� �����ϴ� �ٸ� ������ �ּڰ��� ����Ѵ�. ��� ���� �����ϴ� ���� �Ұ����ϸ� -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Bridge {
	int si;
	int fi;
	int len;

	Bridge(int si, int fi, int len) {
		this.si = si;
		this.fi = fi;
		this.len = len;
	}
}

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_17472 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<Point> q = new LinkedList<Point>();
	static int[] result = new int[6];
	static int total_len = Integer.MAX_VALUE;
	static int component = 0; // �ٸ� ���� �� dfs ��� ���� �Ǵ�
	static int isConnected = 0;

	static void dfs(int i, int j, int[][] A, int[][] c, int islandNum) {
		c[i][j] = islandNum;
		q.offer(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c, islandNum);
				}
			}
		}
	}

	static void go(int index, int selected, LinkedList<Bridge> list, int N) {
		if (selected == N) {
			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 2];
			for (int i = 1; i <= N + 1; i++)
				adlist[i] = new ArrayList<Integer>();
			int length = 0;
			for (int i = 0; i < N; i++) {
				adlist[list.get(result[i]).si].add(list.get(result[i]).fi);
				adlist[list.get(result[i]).fi].add(list.get(result[i]).si);
				length += list.get(result[i]).len;
			}

			int[] c = new int[N + 2];
			dfs2(1, c, adlist);
			if (component != N + 1) {
				component = 0;
				return;
			}
			component = 0;
			if (total_len > length) {
				total_len = length;
			}
			return;
		}
		if (index >= list.size())
			return;
		result[selected] = index;
		go(index + 1, selected + 1, list, N);
		result[selected] = 0;

		go(index + 1, selected, list, N);
	}

	static void dfs2(int index, int[] c, ArrayList<Integer>[] adlist) {
		c[index] = 1;
		component++;

		for (int a : adlist[index]) {
			if (c[a] == 1)
				continue;
			dfs2(a, c, adlist);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();

		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
			}
		}
		// 1. dfs�� �� ���� �����ϱ�
		int[][] c = new int[N][M]; // �� ǥ��
		int islandNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1 && c[i][j] == 0) {
					islandNum++;
					dfs(i, j, A, c, islandNum);
				}
			}
		}
		// 2. ������ ��� �ٸ� ���ϱ�
		LinkedList<Bridge> list = new LinkedList<Bridge>();
		while (!q.isEmpty()) {
			Point p = q.poll();

			int next_i = p.i;
			int next_j = p.j;
			// ��
			int len = 0;
			while (true) {
				next_i--;
				len++;
				if (next_i < 0)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2) // ������ ���� �� ����! �ٸ� ���̴� 2 �̻��̾�� �Ѵ�.
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// ��
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_i++;
				len++;
				if (next_i >= N)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// ��
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_j--;
				len++;
				if (next_j < 0)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// ��
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_j++;
				len++;
				if (next_j >= M)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
		}
		// 3. ������ ��� ���� �߿� n-1�� ����
		go(0, 0, list, islandNum - 1);

		if (total_len == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(total_len);
	}

}
