//백준 6593번 상범 빌딩
//BFS 알고리즘

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_6593 {
	static class Point {
		int i;
		int j;
		int k;
		int cnt;

		Point(int i, int j, int k, int cnt) {
			this.i = i;
			this.j = j;
			this.k = k;
			this.cnt = cnt;

		}
	}

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Label: while (true) {
				String[] input = br.readLine().split(" ");
				int L = Integer.parseInt(input[0]);
				int R = Integer.parseInt(input[1]);
				int C = Integer.parseInt(input[2]);

				if (L == 0 && R == 0 && C == 0)
					break;

				char[][][] A = new char[L][R][C];
				int si = 0;
				int sj = 0;
				int sk = 0;

				for (int i = 0; i < L; i++) {
					for (int j = 0; j < R; j++) {
						String str = br.readLine();
						for (int k = 0; k < C; k++) {
							A[i][j][k] = str.charAt(k);
							if (A[i][j][k] == 'S') {
								si = i;
								sj = j;
								sk = k;
							}
						}
					}
					br.readLine();
				}

				// bfs
				Queue<Point> q = new LinkedList<Point>();
				int[][][] c = new int[L][R][C];

				q.offer(new Point(si, sj, sk, 0));
				c[si][sj][sk] = 1;

				while (!q.isEmpty()) {
					Point p = q.poll();
					
					if (A[p.i][p.j][p.k] == 'E') {
						System.out.println("Escaped in " + p.cnt + " minute(s).");
						continue Label;
					}

					for (int i = 0; i < dx.length; i++) {
						if (p.i + dx[i] >= 0 && p.i + dx[i] < L && p.j + dy[i] >= 0 && p.j + dy[i] < R
								&& p.k + dz[i] >= 0 && p.k + dz[i] < C) {
							if (A[p.i + dx[i]][p.j + dy[i]][p.k + dz[i]] != '#'
									&& c[p.i + dx[i]][p.j + dy[i]][p.k + dz[i]] == 0) {
								q.offer(new Point(p.i + dx[i], p.j + dy[i], p.k + dz[i], p.cnt + 1));
								c[p.i + dx[i]][p.j + dy[i]][p.k + dz[i]] = 1;
							}
						}
					}
				}
				System.out.println("Trapped!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
