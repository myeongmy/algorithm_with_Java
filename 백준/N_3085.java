//백준 3085번
/*문제
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_3085 {
	static int check(char[][] A) {
		int cnt;
		int result = 1;
		for (int k = 0; k < A.length; k++) {
			cnt = 1; // 오류난 원인!!!! 매 줄 바뀔 때마다 1로 초기화해주어야함!
			for (int m = 0; m < A.length-1; m++) {
				if (A[k][m] == A[k][m + 1])
					cnt++;
				else
					cnt = 1;
				if (result < cnt) 
					result = cnt;
				
			}
		}
		
		for (int k = 0; k < A.length; k++) {
			cnt = 1;
			for (int m = 0; m < A.length-1; m++) {
				if (A[m][k] == A[m + 1][k])
					cnt++;
				else
					cnt = 1;
				if (result < cnt) 
					result = cnt;
					
				
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		s.nextLine();
		char[][] A = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = s.nextLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = str.charAt(j);
			}
		}

		int result = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != N - 1) {
					char temp;
					temp = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = temp;

					int num = check(A);
					
					if (result < num)
						result = num;
					temp = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = temp;

				}
				if (i != N - 1) {
					char temp = A[i][j];
					A[i][j] = A[i + 1][j];
					A[i + 1][j] = temp;

					int num = check(A);
					if (result < num)
						result = num;
					temp = A[i][j];
					A[i][j] = A[i + 1][j];
					A[i + 1][j] = temp;
				}
			}
		}
		System.out.println(result);

	}

}
