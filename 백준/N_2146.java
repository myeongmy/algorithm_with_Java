//백준 2146번
/*문제
여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.



위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.



물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

입력
첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

출력
첫째 줄에 가장 짧은 다리의 길이를 출력한다.*/

package 백준;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;

	}
}

public class N_2146 {
	static int[][] c = new int[100][100]; // 방문 여부 및 섬 번호 저장(섬 번호 1부터 시작)
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void dfs(int i, int j, int[][] A, int islandNum) {
		c[i][j] = islandNum;

		for (int v = 0; v < dx.length; v++) {
			if (i + dx[v] >= 0 && i + dx[v] < A.length && j + dy[v] >= 0 && j + dy[v] < A.length) {
				if (A[i + dx[v]][j + dy[v]] == 1 && c[i + dx[v]][j + dy[v]] == 0) {
					dfs(i + dx[v], j + dy[v], A, islandNum);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				A[i][j] = s.nextInt();
		}

		// 1. dfs로 먼저 연결된 섬을 구하기
		int islandNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] == 1 && c[i][j] == 0) {
					dfs(i, j, A, islandNum);
					islandNum++;
				}
			}
		}

		// 2. 큐에 섬들 전부 집어넣기
		Queue<Point> q = new LinkedList<Point>();
		int[][] dist = new int[N][N]; // 거리 저장을 위한 배열 선언
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (c[i][j] != 0) {
					q.add(new Point(i, j));
				} else {
					dist[i][j] = -1;
				}
			}
		}
		int min = 200;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dx.length; i++) {
				if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A.length) {
					if (c[p.i + dx[i]][p.j + dy[i]] == 0) {
						q.offer(new Point(p.i + dx[i], p.j + dy[i]));
						c[p.i + dx[i]][p.j + dy[i]] = c[p.i][p.j];
						dist[p.i + dx[i]][p.j + dy[i]] = dist[p.i][p.j] + 1;
					} else if (c[p.i + dx[i]][p.j + dy[i]] != c[p.i][p.j]) {
						if (min > dist[p.i + dx[i]][p.j + dy[i]] + dist[p.i][p.j])
							min = dist[p.i + dx[i]][p.j + dy[i]] + dist[p.i][p.j];
					}
				}
			}
		}
		System.out.println(min);

	}

}
