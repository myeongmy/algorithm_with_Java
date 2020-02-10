//���� 16234��(�α��̵�)
//dfs ����
/*����
N��Nũ���� ���� �ְ�, ���� 1��1���� ĭ���� �������� �ִ�. ������ ������ ���� �ϳ��� �����ϸ�, r�� c���� �ִ� ���󿡴� A[r][c]���� ��� �ִ�. ������ ���� ���̿��� ���漱�� �����Ѵ�. ��� ����� 1��1 ũ���̱� ������, ��� ���漱�� ���簢�� �����̴�.

���ú��� �α� �̵��� ���۵Ǵ� ���̴�.

�α� �̵��� ������ ���� ����ǰ�, �� �̻� �Ʒ� ����� ���� �α� �̵��� ���� ������ ���ӵȴ�.

���漱�� �����ϴ� �� ������ �α� ���̰� L�� �̻�, R�� ���϶��, �� ���� �����ϴ� ���漱�� ���� �Ϸ絿�� ����.
���� ���ǿ� ���� ������ϴ� ���漱�� ��� ���ȴٸ�, �α� �̵��� �����Ѵ�.
���漱�� �����־� ������ ĭ���� �̿��� �̵��� �� ������, �� ���� ���� �Ϸ� ������ �����̶�� �Ѵ�.
������ �̷�� �ִ� �� ĭ�� �α����� (������ �α���) / (������ �̷�� �ִ� ĭ�� ����)�� �ȴ�. ���ǻ� �Ҽ����� ������.
������ ��ü�ϰ�, ��� ���漱�� �ݴ´�.
�� ������ �α����� �־����� ��, �α� �̵��� �� �� �߻��ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N, L, R�� �־�����. (1 �� N �� 50, 1 �� L �� R �� 100)

��° �ٺ��� N���� �ٿ� �� ������ �α����� �־�����. r�� c���� �־����� ������ A[r][c]�� ���̴�. (1 �� A[r][c] �� 100)

�α� �̵��� �߻��ϴ� Ƚ���� 2,000�� ���� �۰ų� ���� �Է¸� �־�����.

���
�α� �̵��� �� �� �߻��ϴ��� ù° �ٿ� ����Ѵ�.*/

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

public class N_16234 {
	static ArrayList<Point> list = new ArrayList<Point>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int L;
	static int R;

	static void dfs(int i, int j, int[][] A, int[][] c) {
		c[i][j] = 1;
		list.add(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A.length) {
				if (Math.abs(A[i][j] - A[i + dx[k]][j + dy[k]]) >= L && Math.abs(A[i][j] - A[i + dx[k]][j + dy[k]]) <= R
						&& c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		L = s.nextInt();
		R = s.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		int moving = 0;
		int flag = 0;
		while (true) {
			int[][] c = new int[N][N];
			int lastMoving = moving;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (c[i][j] == 0) {
						dfs(i, j, A, c);
						if (list.size() > 1) {
							int sum = 0;
							for (int k = 0; k < list.size(); k++) {
								sum += A[list.get(k).i][list.get(k).j];
							}
							sum = sum / list.size();
							for (int k = 0; k < list.size(); k++) {
								A[list.get(k).i][list.get(k).j] = sum;
							}
							flag = 1;
						}
						list.clear();
					}
				}
			}
			if(flag == 1) moving++;
			flag = 0;
			if (lastMoving == moving)
				break;
		}
		System.out.println(moving);
	}

}
