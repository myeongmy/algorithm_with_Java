//백준 1743번 음식물 피하기
//dfs

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1743 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int count = 0;
	static int max = Integer.MIN_VALUE;

	static void dfs(int i, int j, int[][] c, int[][] A) {
		c[i][j] = 1;
		count++;

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0)
					dfs(i + dx[k], j + dy[k], c, A);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 세로 길이
			int M = Integer.parseInt(input[1]); // 가로 길이
			int K = Integer.parseInt(input[2]); // 음식물 쓰레기 갯수

			int[][] A = new int[N][M];
			for (int i = 0; i < K; i++) {
				String[] arr = br.readLine().split(" ");
				A[Integer.parseInt(arr[0]) - 1][Integer.parseInt(arr[1]) - 1] = 1;
			}

			int[][] c = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (A[i][j] == 1 && c[i][j] == 0) {
						count = 0;
						dfs(i, j, c, A);
						if (max < count)
							max = count;
					}
				}
			}

			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
