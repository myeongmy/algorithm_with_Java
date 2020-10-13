//백준 14632번 고급 작품
//구현

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_14632 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int K = Integer.parseInt(br.readLine());

			char[][][] stamp = new char[K][][];
			for (int i = 0; i < K; i++) {
				String[] arr = br.readLine().split(" ");
				int H = Integer.parseInt(arr[0]);
				int W = Integer.parseInt(arr[1]);

				stamp[i] = new char[H][W];
				for (int j = 0; j < H; j++) {
					String str = br.readLine();
					for (int k = 0; k < W; k++) {
						stamp[i][j][k] = str.charAt(k);
					}
				}
			}

			char[][] A = new char[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					A[i][j] = '.';
				}
			}

			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				String[] arr = br.readLine().split(" ");
				int stampNum = Integer.parseInt(arr[0]);
				int x = Integer.parseInt(arr[1]);
				int y = Integer.parseInt(arr[2]);

				for (int j = x; j < x + stamp[stampNum - 1].length; j++) {
					for (int k = y; k < y + stamp[stampNum - 1][0].length; k++) {
						if (j < 0 || j >= N || k < 0 || k >= M)
							continue;
						A[j][k] = stamp[stampNum - 1][j - x][k - y];
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(A[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
