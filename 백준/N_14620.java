//백준 14620번
//브루트 포스 문제

package 백준;

import java.io.*;
import java.util.*;

public class N_14620 {
	static int[] result = new int[3];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	static void go(int index, int selected, int[][] A) {
		if (selected == 3) {
			// 꽃을 3개 피워보기
			int[][] B = new int[A.length][A.length];

			for (int i = 0; i < 3; i++) {
				int row = result[i] / A.length;
				int col = result[i] % A.length;

				B[row][col]++;
				for (int j = 0; j < dx.length; j++) {
					B[row + dx[j]][col + dy[j]]++;
				}
			}

			// 겹치는 곳 있는지 확인
			for (int i = 0; i < B.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (B[i][j] >= 2)
						return;
				}
			}

			// 비용 계산
			int sum = 0;
			for (int i = 0; i < B.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (B[i][j] == 1)
						sum += A[i][j];
				}
			}

			if (min > sum)
				min = sum;
			return;
		}

		if (index >= A.length * A.length)
			return;
		int i = index / A.length;
		int j = index % A.length;

		if (i == 0 || i == A.length - 1 || j == 0 || j == A.length - 1)
			go(index + 1, selected, A);
		else {
			result[selected] = index;
			go(index + 1, selected + 1, A);
			result[selected] = 0;

			go(index + 1, selected, A);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());

			int[][] A = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(arr[j]);
				}
			}

			go(0, 0, A);
			System.out.println(min);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
