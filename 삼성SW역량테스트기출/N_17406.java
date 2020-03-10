//백준 17406번 (배열 돌리기 4)
//브루트 포스 + 시뮬레이션 문제
/*문제
크기가 N×M 크기인 배열 A가 있을때, 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다. 배열 A가 아래와 같은 경우 1행의 합은 6, 2행의 합은 4, 3행의 합은 15이다. 따라서, 배열 A의 값은 4이다.

1 2 3
2 1 1
4 5 6
배열은 회전 연산을 수행할 수 있다. 회전 연산은 세 정수 (r, c, s)로 이루어져 있고, 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을 시계 방향으로 한 칸씩 돌린다는 의미이다. 배열의 칸 (r, c)는 r행 c열을 의미한다.

예를 들어, 배열 A의 크기가 6×6이고, 회전 연산이 (3, 4, 2)인 경우에는 아래 그림과 같이 회전하게 된다.

A[1][1]   A[1][2] → A[1][3] → A[1][4] → A[1][5] → A[1][6]
             ↑                                       ↓
A[2][1]   A[2][2]   A[2][3] → A[2][4] → A[2][5]   A[2][6]
             ↑         ↑                   ↓         ↓
A[3][1]   A[3][2]   A[3][3]   A[3][4]   A[3][5]   A[3][6]
             ↑         ↑                   ↓         ↓
A[4][1]   A[4][2]   A[4][3] ← A[4][4] ← A[4][5]   A[4][6]
             ↑                                       ↓
A[5][1]   A[5][2] ← A[5][3] ← A[5][4] ← A[5][5] ← A[5][6]

A[6][1]   A[6][2]   A[6][3]   A[6][4]   A[6][5]   A[6][6]
회전 연산이 두 개 이상이면, 연산을 수행한 순서에 따라 최종 배열이 다르다.

다음은 배열 A의 크기가 5×6이고, 회전 연산이 (3, 4, 2), (4, 2, 1)인 경우의 예시이다.

1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
1 8 2 3 2 5
3 2 3 7 2 6
8 4 5 1 1 3
3 3 1 1 4 5
9 2 1 4 3 1
1 8 2 3 2 5
3 2 3 7 2 6
3 8 4 1 1 3
9 3 5 1 4 5
2 1 1 4 3 1
배열 A	(3, 4, 2) 연산 수행 후	(4, 2, 1) 연산 수행 후
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
1 2 3 2 5 6
3 8 7 2 1 3
3 8 2 1 4 5
9 4 3 1 1 1
3 2 5 1 4 3
1 8 2 3 2 5
3 8 2 7 2 6
3 4 3 1 1 3
9 2 1 1 4 5
3 5 1 4 3 1
배열 A	(4, 2, 1) 연산 수행 후	(3, 4, 2) 연산 수행 후
배열 A에 (3, 4, 2), (4, 2, 1) 순서로 연산을 수행하면 배열 A의 값은 12, (4, 2, 1), (3, 4, 2) 순서로 연산을 수행하면 15 이다.

배열 A와 사용 가능한 회전 연산이 주어졌을 때, 배열 A의 값의 최솟값을 구해보자. 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다.

입력
첫째 줄에 배열 A의 크기 N, M, 회전 연산의 개수 K가 주어진다.

둘째 줄부터 N개의 줄에 배열 A에 들어있는 수 A[i][j]가 주어지고, 다음 K개의 줄에 회전 연산의 정보 r, c, s가 주어진다.

출력
배열 A의 값의 최솟값을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Rotate {
	int r;
	int c;
	int s;

	Rotate(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class N_17406 {
	static int[] result = new int[10];
	static int[] c = new int[10];
	static int total_min = Integer.MAX_VALUE;

	static void go(int index, int[][] A, Rotate[] ro, int K) {
		if (index == K) {
			int[][] A1 = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++)
				A1[i] = A[i].clone();
			for (int i = 0; i < K; i++) {
				int r = ro[result[i]].r;
				int c = ro[result[i]].c;
				int s = ro[result[i]].s;

				int length = 3; // 정사각형 한 변의 길이
				for (int j = 1; j <= s; j++) {
					int a = A1[r - 1 - j][c - 1 - j];
					int b = A1[r - 1 - j][c - 1 - j + (length - 1)];
					int c2 = A1[r - 1 - j + (length - 1)][c - 1 - j];
					int d = A1[r - 1 - j + (length - 1)][c - 1 - j + (length - 1)];

					// b 기준
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j][c - 1 - j + (length - 1) - k] = A1[r - 1 - j][c - 1 - j + (length - 1) - k - 1];
					}
					// d 기준
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + (length - 1) - k][c - 1 - j
								+ (length - 1)] = A1[r - 1 - j + (length - 1) - k - 1][c - 1 - j + (length - 1)];
					}
					// c 기준
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + (length - 1)][c - 1 - j + k] = A1[r - 1 - j + (length - 1)][c - 1 - j + k + 1];
					}
					// a 기준
					for (int k = 0; k < length - 1; k++) {
						A1[r - 1 - j + k][c - 1 - j] = A1[r - 1 - j + k + 1][c - 1 - j];
					}
					A1[r - 1 - j + 1][c - 1 - j + (length - 1)] = b;
					A1[r - 1 - j + (length - 1)][c - 1 - j + (length - 1) - 1] = d;
					A1[r - 1 - j + (length - 1) - 1][c - 1 - j] = c2;
					length += 2;
				}

			}
			// 배열의 최소 합 구하기
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < A1.length; i++) {
				int sum = 0;
				for (int j = 0; j < A1[0].length; j++) {
					sum += A1[i][j];
				}
				if (min > sum)
					min = sum;
			}
			if (total_min > min)
				total_min = min;
			return;
		}
		for (int i = 0; i < K; i++) {
			if (c[i] == 1)
				continue;
			c[i] = 1;
			result[index] = i;
			go(index + 1, A, ro, K);
			c[i] = 0;
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int K = s.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
			}
		}
		Rotate[] ro = new Rotate[K]; // 회전 연산 정보 저장 배열
		for (int i = 0; i < K; i++) {
			int r = s.nextInt();
			int c = s.nextInt();
			int st = s.nextInt();

			ro[i] = new Rotate(r, c, st);
		}
		go(0, A, ro, K);
		System.out.println(total_min);
	}

}
