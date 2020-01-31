//백준 12100번(2048 easy)
//완전 탐색 문제

package 삼성SW역량테스트기출;

import java.util.*;

public class N_12100 {
	static int[] result = new int[7];
	static int[][] cases = new int[1024][5];
	static int num = 0;

	static void go(int index) {
		if (index == 5) {
			for (int i = 0; i < index; i++) {
				cases[num][i] = result[i];
			}
			num++;
			return;
		}
		for (int i = 0; i <= 3; i++) {
			result[index] = i;
			go(index + 1);
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		go(0);
		// 1. 5번 이동시키는 경우의 수를 구한다. (순열 이용해서) 0: 상, 1: 하, 2: 좌, 3: 우
		int max = 0;
		for (int i = 0; i < cases.length; i++) {    
			int[][] B = new int[N][N]; // 배열 복사 과정
			for (int k = 0; k < N; k++)
				B[k] = A[k].clone();
			
			for (int j = 0; j < 5; j++) { 
				int [][] visited = new int[N][N]; 
				if (cases[i][j] == 0) { // 위로 이동
					for (int m = 0; m < N; m++) {
						for (int n = 0; n < N; n++) {
							int next_m = m;
							int next_n = n;

							if (B[m][n] == 0)
								continue;
							while (true) {
								if (next_m > 0 && B[next_m - 1][next_n] == 0) {
									next_m -= 1;
									next_n = n;
									B[next_m][next_n] = B[next_m + 1][next_n];
									B[next_m + 1][next_n] = 0; // 이동하고 떠난 자리는 0으로 바꾸어주어야 함
								} else {
									break;
								}
							}
							if (next_m > 0 && B[next_m - 1][next_n] == B[next_m][next_n] & visited[next_m - 1][next_n] == 0) {
								
								next_m -= 1;
								next_n = n;
								B[next_m][next_n] *= 2;
								B[next_m + 1][next_n] = 0;
								visited[next_m][next_n] = 1;
							} 
						}
					}
				}

				if (cases[i][j] == 1) { // 아래로 이동
					for (int m = N-1; m >=0 ; m--) {
						for (int n = 0; n < N; n++) {
							int next_m = m;
							int next_n = n;

							if (B[m][n] == 0)
								continue;
							while (true) {
								if (next_m < N - 1 && B[next_m + 1][next_n] == 0) {
									next_m += 1;
									next_n = n;
									B[next_m][next_n] = B[next_m - 1][next_n];
									B[next_m - 1][next_n] = 0; // 이동하고 떠난 자리는 0으로 바꾸어주어야 함
								} else {
									break;
								}
							}
							if (next_m < N - 1 && B[next_m + 1][next_n] == B[next_m][next_n] && visited[next_m + 1][next_n] == 0) {

								next_m += 1;
								next_n = n;
								B[next_m][next_n] *= 2;
								B[next_m - 1][next_n] = 0;
								visited[next_m][next_n] = 1;
							} 
						}
					}
				}

				if (cases[i][j] == 2) { // 좌로 이동
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < N; m++) {
							int next_m = m;
							int next_n = n;

							if (B[m][n] == 0)
								continue;
							while (true) {
								if (next_n > 0 && B[next_m][next_n - 1] == 0) {
									next_m = m;
									next_n -= 1;
									B[next_m][next_n] = B[next_m][next_n + 1];
									B[next_m][next_n + 1] = 0; // 이동하고 떠난 자리는 0으로 바꾸어주어야 함
								} else {
									break;
								}
							}
							if (next_n > 0 && B[next_m][next_n - 1] == B[next_m][next_n] && visited[next_m][next_n - 1] == 0) {
								
								next_m = m;
								next_n -= 1;
								B[next_m][next_n] *= 2;
								B[next_m][next_n + 1] = 0;
								visited[next_m][next_n] = 1;
							} 
						}
					}
				}

				if (cases[i][j] == 3) { // 우로 이동
					for (int n = N-1; n >=0; n--) {
						for (int m = 0; m < N; m++) {
							int next_m = m;
							int next_n = n;

							if (B[m][n] == 0)
								continue;
							while (true) {
								if (next_n < N - 1 && B[next_m][next_n + 1] == 0) {
									next_m = m;
									next_n += 1;
									B[next_m][next_n] = B[next_m][next_n - 1];
									B[next_m][next_n - 1] = 0; // 이동하고 떠난 자리는 0으로 바꾸어주어야 함
								} else {
									break;
								}
							}
							if (next_n < N - 1 && B[next_m][next_n + 1] == B[next_m][next_n] && visited[next_m][next_n + 1] == 0) {
								
								next_m = m;
								next_n += 1;
								B[next_m][next_n] *= 2;
								B[next_m][next_n - 1] = 0;
								visited[next_m][next_n] = 1;
							} 
						}
					}
				}
			}

			for (int q = 0; q < N; q++) {
				for (int z = 0; z < N; z++) {
					if (max < B[q][z])
						max = B[q][z];
				}
			}
		}
		System.out.println(max);
	}

}
