//백준 1600번 말이 되고픈 원숭이
//bfs

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1600 {
	static class Point {
		int i;
		int j;
		int horse; // 말의 움직임으로 몇번 움직였는지
		int cnt;

		Point(int i, int j, int horse, int cnt) {
			this.i = i;
			this.j = j;
			this.horse = horse;
			this.cnt = cnt;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[] hdx = { -2, -1, -2, -1, 1, 2, 1, 2 };
	static int[] hdy = { -1, -2, 1, 2, -2, -1, 2, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int W = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[1]);

		int[][] A = new int[H][W];
		for (int i = 0; i < A.length; i++) {
			String[] arr = br.readLine().split(" ");

			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = Integer.parseInt(arr[j]);
			}
		}

		// bfs 돌리기
		Queue<Point> q = new LinkedList<Point>();
		int[][][] c = new int[H][W][K + 1];

		q.offer(new Point(0, 0, 0, 1));
		c[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.horse < K) {
				for (int i = 0; i < hdx.length; i++) {
					if (p.i + hdx[i] >= 0 && p.i + hdx[i] < A.length && p.j + hdy[i] >= 0
							&& p.j + hdy[i] < A[0].length) {
						if (A[p.i + hdx[i]][p.j + hdy[i]] == 0 && c[p.i + hdx[i]][p.j + hdy[i]][p.horse + 1] == 0) {
							q.offer(new Point(p.i + hdx[i], p.j + hdy[i], p.horse + 1, p.cnt + 1));
							c[p.i + hdx[i]][p.j + hdy[i]][p.horse + 1] = p.cnt + 1;
						}
					}
				}
			}

			for (int i = 0; i < dx.length; i++) {
				if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
					if (A[p.i + dx[i]][p.j + dy[i]] == 0 && c[p.i + dx[i]][p.j + dy[i]][p.horse] == 0) {
						q.offer(new Point(p.i + dx[i], p.j + dy[i], p.horse, p.cnt + 1));
						c[p.i + dx[i]][p.j + dy[i]][p.horse] = p.cnt + 1;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (c[A.length - 1][A[0].length - 1][i] != 0 && min > c[A.length - 1][A[0].length - 1][i])
				min = c[A.length - 1][A[0].length - 1][i];
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min - 1);
	}

}
