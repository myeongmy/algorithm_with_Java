//���� 13460��(����Ż�� 2)
// ���� ���¿��� ��� ������ ���� ���� ���¸� ����� ���� �ּ� Ƚ���� ���ؾ� �ϹǷ� bfs�� �̿��Ѵ�.
/*����
��ŸƮ��ũ���� �Ǹ��ϴ� ��̿� �峭�� �߿��� ���� �αⰡ ���� ��ǰ�� ���� Ż���̴�. ���� Ż���� ���簢�� ���忡 ���� ������ �Ķ� ������ �ϳ��� ���� ����, ���� ������ ������ ���� ������ �����̴�.

������ ���� ũ��� N, ���� ũ��� M�̰�, ���ǻ� 1��1ũ���� ĭ���� �������� �ִ�. ���� �ٱ� ��� ���� ��� ������ �ְ�, ���忡�� ������ �ϳ� �ִ�. ���� ������ �Ķ� ������ ũ��� ���忡�� 1��1ũ���� ĭ�� ���� ä��� �������̰�, ���� �ϳ��� �� �ִ�. ������ ��ǥ�� ���� ������ ������ ���ؼ� ������ ���̴�. �̶�, �Ķ� ������ ���ۿ� ���� �� �ȴ�.

�̶�, ������ ������ �ǵ帱 ���� ����, �߷��� �̿��ؼ� �̸� ���� ������ �Ѵ�. �������� ����̱�, ���������� ����̱�, �������� ����̱�, �Ʒ������� ����̱�� ���� �� ���� ������ �����ϴ�.

������ ���ۿ��� ���� ���ÿ� �����δ�. ���� ������ ���ۿ� ������ ����������, �Ķ� ������ ���ۿ� ������ �����̴�. ���� ������ �Ķ� ������ ���ÿ� ���ۿ� ������ �����̴�. ���� ������ �Ķ� ������ ���ÿ� ���� ĭ�� ���� �� ����. ��, ���� ������ �Ķ� ������ ũ��� �� ĭ�� ��� �����Ѵ�. ����̴� ������ �׸��ϴ� ���� �� �̻� ������ �������� ���� �� �����̴�.

������ ���°� �־����� ��, �ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ��� ������ ����, ���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����. ���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. �� ���ڿ��� '.', '#', 'O', 'R', 'B' �� �̷���� �ִ�. '.'�� �� ĭ�� �ǹ��ϰ�, '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.

�ԷµǴ� ��� ������ �����ڸ����� ��� '#'�� �ִ�. ������ ������ �� �� �̸�, ���� ������ �Ķ� ������ �׻� 1���� �־�����.

���
�ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. ����, 10�� ���Ϸ� �������� ���� ������ ������ ���� ���� �� ������ -1�� ����Ѵ�.*/

package �ＺSW�����׽�Ʈ����;

import java.util.*;

class Status {
	int rx;
	int ry;
	int bx;
	int by;
	int cnt;

	Status(int rx, int ry, int bx, int by, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class N_13460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // ����
		int M = s.nextInt(); // ����
		char[][] A = new char[N][M];
		int srx = 0;
		int sry = 0;
		int sbx = 0;
		int sby = 0;
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j);
				if (A[i][j] == 'R') {
					srx = i;
					sry = j;
				}
				if (A[i][j] == 'B') {
					sbx = i;
					sby = j;
				}
			}
		}

		// bfs
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][][][] c = new int[20][20][20][20];
		Queue<Status> q = new LinkedList<Status>();
		c[srx][sry][sbx][sby] = 1;
		q.offer(new Status(srx, sry, sbx, sby, 0));

		while (!q.isEmpty()) {
			Status st = q.poll();
			if(st.cnt > 10) break;
			if (A[st.rx][st.ry] == 'O' && A[st.bx][st.by] != 'O') {
				System.out.println(st.cnt);
				System.exit(0);
			}
			for (int i = 0; i < dx.length; i++) { // �� �������� �̵� ����
				int next_rx = st.rx;
				int next_ry = st.ry;
				int next_bx = st.bx;
				int next_by = st.by;

				while (true) {

					// ���� �� �� �������� �����̱�
					if (A[next_rx][next_ry] != '#' && A[next_rx][next_ry] != 'O') {
						next_rx += dx[i];
						next_ry += dy[i];
					} else if (A[next_rx][next_ry] == '#') {
						next_rx -= dx[i];
						next_ry -= dy[i];
						break;
					} else {
						break;
					}
				}
				
				while (true) {

					// �Ķ� �� �� �������� �����̱�
					if (A[next_bx][next_by] != '#' && A[next_bx][next_by] != 'O') {
						next_bx += dx[i];
						next_by += dy[i];
					} else if (A[next_bx][next_by] == '#') {
						next_bx -= dx[i];
						next_by -= dy[i];
						break;
					} else {
						break;
					}
				}
				
				if (A[next_rx][next_ry] != 'O' && next_rx == next_bx && next_by == next_ry) { // ���� ���� �Ķ� ���� �� ���� ��ġ�ϸ� �ȵȴ�.
					if (Math.abs(next_rx - st.rx) + Math.abs(next_ry - st.ry) > Math.abs(next_bx - st.bx)
							+ Math.abs(next_by - st.by)) {
						next_rx -= dx[i];
						next_ry -= dy[i];
					} else {
						next_bx -= dx[i];
						next_by -= dy[i];
					}

				}
				if (c[next_rx][next_ry][next_bx][next_by] == 0) {
					
					q.offer(new Status(next_rx, next_ry, next_bx, next_by, st.cnt + 1));
					c[next_rx][next_ry][next_bx][next_by] = 1;
				}
			}

		}
		System.out.println(-1);
	}

}
