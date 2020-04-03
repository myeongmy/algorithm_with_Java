//백준 1051번
//브루트 포스 문제
/*문제
N*M크기의 직사각형이 있다. 각 칸은 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.

출력
첫째 줄에 정답 정사각형의 크기를 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

public class N_1051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);

			int[][] A = new int[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					A[i][j] = str.charAt(j) - 48;
				}
			}

			int max_size = Integer.min(N, M);
			for (int i = max_size; i >= 2; i--) { // 정사각형 크기
				// 올 수 있는 위치
				for (int j = 0; j < N - (i - 1); j++) {
					for (int k = 0; k < M - (i - 1); k++) {
						if (A[j][k] == A[j + (i - 1)][k] && A[j][k] == A[j][k + (i - 1)]
								&& A[j][k] == A[j + (i - 1)][k + (i - 1)]) {
							System.out.println(i * i);
							System.exit(0);
						}
					}
				}

			}
			System.out.println(1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
