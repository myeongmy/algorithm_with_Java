//���� 11559��
//DFS ����
/*����
�ѿ�ѿ��� ���� ������ ����.

�ʵ忡 ���� ���� ������ �ѿ並 ���´�. �ѿ�� �߷��� ������ �޾� �Ʒ��� �ٴ��̳� �ٸ� �ѿ䰡 ���� ������ �Ʒ��� ��������.

�ѿ並 ���� �� ��, ���� �� �ѿ䰡 4�� �̻� �����¿�� ����Ǿ� ������ ����� ���� �� �ѿ���� �Ѳ����� ��������.

�ѿ���� �������� ���� ���� �ٸ� �ѿ���� �ִٸ�, ���� �߷��� ������ �޾� ���ʴ�� �Ʒ��� �������� �ȴ�.

�Ʒ��� �������� ���� �ٽ� ���� ���� �ѿ���� 4�� �̻� ���̰� �Ǹ� �� ������ �Ǵµ�, ���� �� �ѿ���� �������� �ٽ� ������ �ݺ��� ������ 1���⾿ �þ��.

���� �� �ִ� �ѿ䰡 ���� �׷��� �ִٸ� ���ÿ� ������ �ϰ� ���� �׷��� �������� �ѹ��� ���Ⱑ �߰��ȴ�.

���Դ� �ֱ� �ѿ�ѿ� ���ӿ� ǫ ������. �� ������ 1:1�� �ٴ� ���������̶� �� �״� �͵� �߿�������, ������ �Ͷ߸��ٸ� ���Ⱑ �� ���� ���� �ٷ� �ľ��� �� �ִ� �ɷµ� �ʿ��ϴ�. ������ ���� �Ƿ��� �����Ͽ� ���Դ� �ڱ� �ʵ忡�� �Ű� ���� �ٻڴ�. ������ �ʵ尡 �־����� ��, ���Ⱑ �� �� �������� �Ͼ�� ����Ͽ� ���Ը� ��������!

�Է�
12*6�� ���ڰ� �־�����.

�̶� .�� ������̰� .�� �ƴѰ��� ������ ������ �ѿ並 ��Ÿ����.

R�� ����, G�� �ʷ�, B�� �Ķ�, P�� ����, Y�� ����̴�.(��� �빮�ڷ� �־�����.)

�Է����� �־����� �ʵ�� �ѿ���� ���� �Ʒ��� ������ ���� ����(�� �ѿ� �Ʒ��� �� ĭ�� �ִ� ���� ����) �̴�.

���
���� �־��� ��Ȳ���� ��Ⱑ �Ǵ��� ����϶�. (�ϳ��� ������ �ʴ´ٸ� 0�� ����ϸ� �ȴ�.)*/

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

public class N_11559 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int connectedCom = 0;
	static LinkedList<Point> list = new LinkedList<Point>();

	static void dfs(int i, int j, char[][] A, int[][] c) {
		c[i][j] = 1;
		connectedCom++;
		list.add(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == A[i][j] && c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		char[][] A = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = s.next();
			for (int j = 0; j < 6; j++) {
				A[i][j] = str.charAt(j);
			}
		}
		// dfs Ǯ��
		int result = 0;
		while (true) {
			int[][] c = new int[12][6];
			int flag = 0; // �� �̻� ���߸� ���� �ִ��� ����
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (A[i][j] != '.' && c[i][j] == 0) {
						connectedCom = 0;
						dfs(i, j, A, c);
						if (connectedCom >= 4) {
							flag = 1;
							for (int k = 0; k < list.size(); k++) {
								A[list.get(k).i][list.get(k).j] = '.';
							}
						}
						list.clear();
					}
				}
			}
			if(flag == 1)
				result++;
			if (flag == 0)
				break;
			// ������
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (A[i][j] != '.') {
						int next_i = i;
						while (true) {
							if (next_i + 1 >= 12 || A[next_i + 1][j] != '.')
								break;
							next_i++;
						}
						if (next_i != i) {
							A[next_i][j] = A[i][j];
							A[i][j] = '.';
						}
					}
				}
			}
		}
		System.out.println(result);
	}

}
