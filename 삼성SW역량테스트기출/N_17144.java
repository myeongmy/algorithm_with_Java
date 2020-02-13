//백준 17144번
//큐를 이용한 시뮬레이션 문제
/*문제
미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.



공기청정기는 항상 왼쪽 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

1초 동안 아래 적힌 일이 순서대로 일어난다.

미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
확산되는 양은 Ar,c/5이고 소수점은 버린다.
(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
공기청정기가 작동한다.
공기청정기에서는 바람이 나온다.
위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.


방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.

입력
첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.

둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

출력
첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Point5 {
	int i;
	int j;
	int amount;

	Point5(int i, int j, int amount) {
		this.i = i;
		this.j = j;
		this.amount = amount;
	}
}

public class N_17144 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Point5[] m;

	static void up_circulate(int[][] A) {
		int x1 = A[m[0].i][m[0].j];
		int x2 = A[m[0].i][A[0].length - 1];
		int x3 = A[0][A[0].length - 1];
		int x4 = A[0][0];

		for (int i = A[0].length - 1; i > 0; i--) {
			if (i == 1) {
				A[m[0].i][1] = 0;
				break;
			}
			A[m[0].i][i] = A[m[0].i][i - 1];
		}
		for (int i = 0; i < m[0].i; i++) {
			if (i == m[0].i - 1) {
				A[i][A[0].length - 1] = x2;
				break;
			}
			A[i][A[0].length - 1] = A[i + 1][A[0].length - 1];
		}
		for (int i = 0; i < A[0].length - 1; i++) {
			if (i == A[0].length - 2) {
				A[0][i] = x3;
				break;
			}
			A[0][i] = A[0][i + 1];
		}
		for (int i = m[0].i; i > 0; i--) {
			if (i == 1) {
				A[i][0] = x4;
				break;
			}
			if (i == m[0].i)
				continue;
			A[i][0] = A[i - 1][0];
		}
	}

	static void down_circulate(int[][] A) {
		int x1 = A[m[1].i][m[1].j];
		int x2 = A[m[1].i][A[0].length - 1];
		int x3 = A[A.length - 1][A[0].length - 1];
		int x4 = A[A.length - 1][0];

		for (int i = A[0].length - 1; i > 0; i--) {
			if (i == 1) {
				A[m[1].i][1] = 0;
				break;
			}
			A[m[1].i][i] = A[m[1].i][i - 1];
		}
		for (int i = A.length - 1; i > m[1].i; i--) {
			if (i == m[1].i + 1) {
				A[i][A[0].length - 1] = x2;
				break;
			}
			A[i][A[0].length - 1] = A[i - 1][A[0].length - 1];
		}
		for (int i = 0; i < A[0].length - 1; i++) {
			if (i == A[0].length - 2) {
				A[A.length - 1][i] = x3;
				break;
			}
			A[A.length - 1][i] = A[A.length - 1][i + 1];
		}
		for (int i = m[1].i; i < A.length - 1; i++) {
			if (i == m[1].i)
				continue;
			if (i == A.length - 2) {
				A[i][0] = x4;
				break;
			}
			A[i][0] = A[i + 1][0];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int R = s.nextInt();
		int C = s.nextInt();
		int T = s.nextInt();
		int[][] A = new int[R][C];
		m = new Point5[2]; // 공기청정기의 위치 저장
		Queue<Point5> q = new LinkedList<Point5>();
		int a = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == -1) {
					m[a] = new Point5(i, j, 0);
					a++;
				}
			}
		}
		while (T != 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (A[i][j] != -1 && A[i][j] != 0)
						q.offer(new Point5(i, j, A[i][j]));
				}
			}
			while (!q.isEmpty()) {
				Point5 p = q.poll();
				int count = 0;
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (A[p.i + dx[i]][p.j + dy[i]] != -1) {
							count++;
							A[p.i + dx[i]][p.j + dy[i]] += p.amount / 5;
						}
					}
				}
				A[p.i][p.j] -= (p.amount / 5) * count;
			}
			// 위쪽 순환
			up_circulate(A);
			// 아래쪽 순환
			down_circulate(A);
			T--;
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] != -1)
					sum += A[i][j];
			}
		}
		System.out.println(sum);

	}

}
