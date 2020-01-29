//백준 4963번
/*문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러쌓여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.*/

package 백준;

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
