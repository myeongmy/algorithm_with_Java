//백준 10971번
//시작점을 고정하여 푸는 방법

package 백준;

import java.util.Scanner;

public class N_10971_v2 {
	static int[][] A;
	static boolean[] c = new boolean[11];
	static int[] result = new int[11];
	static int min = 1000000 * 10 + 1;

	static void go(int index, int N) {
		if (index == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (A[result[i]][result[i + 1]] == 0)
					return;
				sum += A[result[i]][result[i + 1]];
			}
			if (A[result[N - 1]][result[0]] == 0)
				return;
			sum += A[result[N - 1]][result[0]];
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = 1; i <= N - 1; i++) {
			if (c[i] == true)
				continue;
			c[i] = true;
			result[index] = i;
			go(index + 1, N);
			c[i] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		result[0] = 0;
		go(1, N);
		System.out.println(min);
	}

}
