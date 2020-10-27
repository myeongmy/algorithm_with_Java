//백준 2933번 미네랄
//시뮬레이션

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_2933 {
	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[][] A;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<Point> cluster = new ArrayList<Point>();
	static int flag = 0;

	static void dfs(int i, int j, int[][] c) {
		c[i][j] = 1;
		if (i == A.length - 1)
			flag = 1;
		cluster.add(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0)
					dfs(i + dx[k], j + dy[k], c);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);

			A = new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();

				for (int j = 0; j < C; j++) {
					if (str.charAt(j) == '.')
						A[i][j] = 0;
					else if (str.charAt(j) == 'x')
						A[i][j] = 1;
				}
			}

			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int dir = 0;

			for (int i = 0; i < arr.length; i++) {
				int height = R - Integer.parseInt(arr[i]);

				// 해당 높이 지우기
				if (dir == 0) {
					for (int j = 0; j < C; j++) {
						if (A[height][j] == 1) {
							A[height][j] = 0;
							break;
						}
					}
				} else if (dir == 1) {
					for (int j = C - 1; j >= 0; j--) {
						if (A[height][j] == 1) {
							A[height][j] = 0;
							break;
						}
					}
				}

				dir = (dir + 1) % 2;

				// dfs로 공중에 떠있는 클러스터 찾기
				int[][] c = new int[R][C];

				Label1: for (int m = 0; m < R; m++) {
					for (int n = 0; n < C; n++) {
						flag = 0;
						cluster.clear();

						if (A[m][n] == 1 && c[m][n] == 0) {
							dfs(m, n, c);
							if (flag == 0) { // 공중에 떠있는 클러스터

								for (int k = 0; k < cluster.size(); k++) { // 먼저 지우기
									A[cluster.get(k).i][cluster.get(k).j] = 0;
								}

								int down = 1;
								Label: while (true) {
									for (int k = 0; k < cluster.size(); k++) {
										if (cluster.get(k).i + down >= R
												|| A[cluster.get(k).i + down][cluster.get(k).j] == 1)
											break Label;
									}
									down++;
								}

								for (int k = 0; k < cluster.size(); k++) {
									A[cluster.get(k).i + (down - 1)][cluster.get(k).j] = 1;
								}

								break Label1;
							}

						}
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] == 0)
						System.out.print(".");
					else
						System.out.print("x");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
