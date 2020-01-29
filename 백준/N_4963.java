//���� 4963��
/*����
���簢������ �̷���� �ִ� ���� �ٴ� ������ �־�����. ���� ������ ���� ���α׷��� �ۼ��Ͻÿ�.



�� ���簢���� ����, ���� �Ǵ� �밢������ ����Ǿ� �ִ� �簢���� �ɾ �� �ִ� �簢���̴�. 

�� ���簢���� ���� ���� ��������, �� ���簢������ �ٸ� ���簢������ �ɾ �� �� �ִ� ��ΰ� �־�� �Ѵ�. ������ �ٴٷ� �ѷ��׿� ������, ���� ������ ���� �� ����.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� ù° �ٿ��� ������ �ʺ� w�� ���� h�� �־�����. w�� h�� 50���� �۰ų� ���� ���� �����̴�.

��° �ٺ��� h�� �ٿ��� ������ �־�����. 1�� ��, 0�� �ٴ��̴�.

�Է��� ������ �ٿ��� 0�� �� �� �־�����.

���
�� �׽�Ʈ ���̽��� ���ؼ�, ���� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_4963 {
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, 1, 1, -1, -1 };

	static void dfs(int i, int j, int[][] A, int[][] c) {
		c[i][j] = 1;

		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A[0].length) {
				if (A[i + dx[v]][j + dy[v]] == 1 && c[i + dx[v]][j + dy[v]] == 0)
					dfs(i + dx[v], j + dy[v], A, c);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int w;
		int h;
		while ((w = s.nextInt()) != 0 && (h = s.nextInt()) != 0) {
			int[][] A = new int[h][w];
			int[][] c = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					A[i][j] = s.nextInt();
				}
			}
			int numOfLand = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (A[i][j] == 1 && c[i][j] == 0) {
						dfs(i, j, A, c);
						numOfLand++;
					}

				}
			}
			System.out.println(numOfLand);
			;
		}
	}

}
