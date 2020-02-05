//���� 2583��
//DFS ����
/*����
������ ������ 1�� M��N(M,N��100)ũ���� �����̰� �ִ�. �� ������ ���� ���ݿ� ���߾� K���� ���簢���� �׸� ��, �̵� K���� ���簢���� ���θ� ������ ������ �κ��� �� ���� �и��� �������� ����������.

���� ��� M=5, N=7 �� ������ ���� <�׸� 1>�� ���� ���簢�� 3���� �׷ȴٸ�, �� ������ ������ <�׸� 2>�� ���� 3���� �и��� �������� ���������� �ȴ�.



<�׸� 2>�� ���� �и��� �� ������ ���̴� ���� 1, 7, 13�� �ȴ�.

M, N�� K �׸��� K���� ���簢���� ��ǥ�� �־��� ��, K���� ���簢�� ���θ� ������ ������ �κ��� �� ���� �и��� �������� ������������, �׸��� �и��� �� ������ ���̰� �������� ���Ͽ� �̸� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� M�� N, �׸��� K�� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. M, N, K�� ��� 100 ������ �ڿ����̴�. ��° �ٺ��� K���� �ٿ��� �� �ٿ� �ϳ��� ���簢���� ���� �Ʒ� �������� x, y��ǥ���� ������ �� �������� x, y��ǥ���� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. �������� ���� �Ʒ� �������� ��ǥ�� (0,0)�̰�, ������ �� �������� ��ǥ��(N,M)�̴�. �ԷµǴ� K���� ���簢������ ������ ��ü�� ä��� ���� ����.

���
ù° �ٿ� �и��Ǿ� ���������� ������ ������ ����Ѵ�. ��° �ٿ��� �� ������ ���̸� ������������ �����Ͽ� ��ĭ�� ���̿� �ΰ� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_2583 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int area = 0;

	static void dfs(int i, int j, int[][] A) {
		A[i][j] = 1;
		area++;
		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A[0].length) {
				if (A[i + dx[v]][j + dy[v]] == 0) {
					dfs(i + dx[v], j + dy[v], A);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();
		int K = s.nextInt();
		int[][] A = new int[M][N];
		for (int i = 0; i < K; i++) {
			int startX = s.nextInt();
			int startY = s.nextInt();
			int finalX = s.nextInt();
			int finalY = s.nextInt();

			for (int m = M - finalY; m < M - startY; m++) {
				for (int n = startX; n < finalX; n++) {
					A[m][n]++;
				}
			}
		}

		int connected = 0;
		ArrayList<Integer> areaList = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == 0) {
					dfs(i, j, A);
					connected++;
					areaList.add(area);
					area = 0;
				}
			}
		}

		System.out.println(connected);
		Collections.sort(areaList);
		for (int i = 0; i < connected; i++)
			System.out.print(areaList.get(i) + " ");
	}

}
