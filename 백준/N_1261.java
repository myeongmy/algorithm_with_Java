//백준 1261번
/*문제
알고스팟 운영진이 모두 미로에 갇혔다. 미로는 N*M 크기이며, 총 1*1크기의 방으로 이루어져 있다. 미로는 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다.

알고스팟 운영진은 여러명이지만, 항상 모두 같은 방에 있어야 한다. 즉, 여러 명이 다른 방에 있을 수는 없다. 어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다. 즉, 현재 운영진이 (x, y)에 있을 때, 이동할 수 있는 방은 (x+1, y), (x, y+1), (x-1, y), (x, y-1) 이다. 단, 미로의 밖으로 이동 할 수는 없다.

벽은 평소에는 이동할 수 없지만, 알고스팟의 무기 AOJ를 이용해 벽을 부수어 버릴 수 있다. 벽을 부수면, 빈 방과 동일한 방으로 변한다.

만약 이 문제가 알고스팟에 있다면, 운영진들은 궁극의 무기 sudo를 이용해 벽을 한 번에 다 없애버릴 수 있지만, 안타깝게도 이 문제는 Baekjoon Online Judge에 수록되어 있기 때문에, sudo를 사용할 수 없다.

현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다. 0은 빈 방을 의미하고, 1은 벽을 의미한다.

(1, 1)과 (N, M)은 항상 뚫려있다.

출력
첫째 줄에 알고스팟 운영진이 (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력한다.*/

package 백준;

import java.util.*;

class Algo {
	int i;
	int j;
	int cnt;

	Algo(int i, int j, int cnt) {
		this.i = i;
		this.j = j;
		this.cnt = cnt;
	}
}

public class N_1261 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();

		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = s.next();
			for (int j = 0; j < M; j++)
				A[i][j] = str.charAt(j) - 48;
		}

		// bfs 풀이
		int[][] c = new int[N][M]; 
		ArrayDeque<Algo> q = new ArrayDeque<Algo>();

		c[0][0] = 1;
		q.offerLast(new Algo(0, 0, 0));

		while (!q.isEmpty()) {
			Algo a = q.poll();
			if (a.i == N - 1 && a.j == M - 1) {
				System.out.println(a.cnt);
				System.exit(0);
			}
			for (int i = 0; i < dx.length; i++) {
				if (a.i + dx[i] >= 0 && a.i + dx[i] < A.length && a.j + dy[i] >= 0
						&& a.j + dy[i] < A[0].length) {
					if (A[a.i + dx[i]][a.j + dy[i]] == 0 && c[a.i + dx[i]][a.j + dy[i]] == 0) {
						q.offerFirst(new Algo(a.i + dx[i], a.j + dy[i], a.cnt));
						c[a.i + dx[i]][a.j + dy[i]] = 1;
					}
					if (A[a.i + dx[i]][a.j + dy[i]] == 1 && c[a.i + dx[i]][a.j + dy[i]] == 0) {
						q.offerLast(new Algo(a.i + dx[i], a.j + dy[i], a.cnt + 1));
						c[a.i + dx[i]][a.j + dy[i]] = 1;
					}
				}
			}
		}
		System.out.println(min);
	}

}
