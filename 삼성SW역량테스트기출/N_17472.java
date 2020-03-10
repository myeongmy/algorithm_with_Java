//백준 17472번 (다리 만들기 2)
//bfs + 완전 탐색 문제
/*문제
섬으로 이루어진 나라가 있고, 모든 섬을 다리로 연결하려고 한다. 이 나라의 지도는 N×M 크기의 이차원 격자로 나타낼 수 있고, 격자의 각 칸은 땅이거나 바다이다.

섬은 연결된 땅이 상하좌우로 붙어있는 덩어리를 말하고, 아래 그림은 네 개의 섬으로 이루어진 나라이다. 색칠되어있는 칸은 땅이다.


다리는 바다에만 건설할 수 있고, 다리의 길이는 다리가 격자에서 차지하는 칸의 수이다. 다리를 연결해서 모든 섬을 연결하려고 한다. 섬 A에서 다리를 통해 섬 B로 갈 수 있을 때, 섬 A와 B를 연결되었다고 한다. 다리의 양 끝은 섬과 인접한 바다 위에 있어야 하고, 한 다리의 방향이 중간에 바뀌면 안된다. 또, 다리의 길이는 2 이상이어야 한다.

다리의 방향이 중간에 바뀌면 안되기 때문에, 다리의 방향은 가로 또는 세로가 될 수 밖에 없다. 방향이 가로인 다리는 다리의 양 끝이 가로 방향으로 섬과 인접해야 하고, 방향이 세로인 다리는 다리의 양 끝이 세로 방향으로 섬과 인접해야 한다.

섬 A와 B를 연결하는 다리가 중간에 섬 C와 인접한 바다를 지나가는 경우에 섬 C는 A, B와 연결되어있는 것이 아니다. 

아래 그림은 섬을 모두 연결하는 올바른 2가지 방법이고, 다리는 회색으로 색칠되어 있다. 섬은 정수, 다리는 알파벳 대문자로 구분했다.

	
다리의 총 길이: 13

D는 2와 4를 연결하는 다리이고, 3과는 연결되어 있지 않다.

다리의 총 길이: 9 (최소)

다음은 올바르지 않은 3가지 방법이다
		

C의 방향이 중간에 바뀌었다	D의 길이가 1이다.	가로 다리인 A가 1과 가로로 연결되어 있지 않다.
다리가 교차하는 경우가 있을 수도 있다. 교차하는 다리의 길이를 계산할 때는 각 칸이 각 다리의 길이에 모두 포함되어야 한다. 아래는 다리가 교차하는 경우와 기타 다른 경우에 대한 2가지 예시이다.


 	
A의 길이는 4이고, B의 길이도 4이다.

총 다리의 총 길이: 4 + 4 + 2 = 10

다리 A: 2와 3을 연결 (길이 2)

다리 B: 3과 4를 연결 (길이 3)

다리 C: 2와 5를 연결 (길이 5)

다리 D: 1과 2를 연결 (길이 2)

총 길이: 12

나라의 정보가 주어졌을 때, 모든 섬을 연결하는 다리 길이의 최솟값을 구해보자.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 지도의 정보가 주어진다. 각 줄은 M개의 수로 이루어져 있으며, 수는 0 또는 1이다. 0은 바다, 1은 땅을 의미한다.

출력
모든 섬을 연결하는 다리 길이의 최솟값을 출력한다. 모든 섬을 연결하는 것이 불가능하면 -1을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Bridge {
	int si;
	int fi;
	int len;

	Bridge(int si, int fi, int len) {
		this.si = si;
		this.fi = fi;
		this.len = len;
	}
}

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_17472 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<Point> q = new LinkedList<Point>();
	static int[] result = new int[6];
	static int total_len = Integer.MAX_VALUE;
	static int component = 0; // 다리 연결 후 dfs 요소 개수 판단
	static int isConnected = 0;

	static void dfs(int i, int j, int[][] A, int[][] c, int islandNum) {
		c[i][j] = islandNum;
		q.offer(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A[0].length) {
				if (A[i + dx[k]][j + dy[k]] == 1 && c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c, islandNum);
				}
			}
		}
	}

	static void go(int index, int selected, LinkedList<Bridge> list, int N) {
		if (selected == N) {
			ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 2];
			for (int i = 1; i <= N + 1; i++)
				adlist[i] = new ArrayList<Integer>();
			int length = 0;
			for (int i = 0; i < N; i++) {
				adlist[list.get(result[i]).si].add(list.get(result[i]).fi);
				adlist[list.get(result[i]).fi].add(list.get(result[i]).si);
				length += list.get(result[i]).len;
			}

			int[] c = new int[N + 2];
			dfs2(1, c, adlist);
			if (component != N + 1) {
				component = 0;
				return;
			}
			component = 0;
			if (total_len > length) {
				total_len = length;
			}
			return;
		}
		if (index >= list.size())
			return;
		result[selected] = index;
		go(index + 1, selected + 1, list, N);
		result[selected] = 0;

		go(index + 1, selected, list, N);
	}

	static void dfs2(int index, int[] c, ArrayList<Integer>[] adlist) {
		c[index] = 1;
		component++;

		for (int a : adlist[index]) {
			if (c[a] == 1)
				continue;
			dfs2(a, c, adlist);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();

		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
			}
		}
		// 1. dfs로 섬 영역 구분하기
		int[][] c = new int[N][M]; // 섬 표시
		int islandNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1 && c[i][j] == 0) {
					islandNum++;
					dfs(i, j, A, c, islandNum);
				}
			}
		}
		// 2. 가능한 모든 다리 구하기
		LinkedList<Bridge> list = new LinkedList<Bridge>();
		while (!q.isEmpty()) {
			Point p = q.poll();

			int next_i = p.i;
			int next_j = p.j;
			// 상
			int len = 0;
			while (true) {
				next_i--;
				len++;
				if (next_i < 0)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2) // 문제를 제발 잘 읽자! 다리 길이는 2 이상이어야 한다.
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// 하
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_i++;
				len++;
				if (next_i >= N)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// 좌
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_j--;
				len++;
				if (next_j < 0)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
			// 우
			len = 0;
			next_i = p.i;
			next_j = p.j;
			while (true) {
				next_j++;
				len++;
				if (next_j >= M)
					break;
				if (A[next_i][next_j] == 1) {
					if (c[p.i][p.j] != c[next_i][next_j] && len - 1 >= 2)
						list.add(new Bridge(c[p.i][p.j], c[next_i][next_j], len - 1));
					break;
				}
			}
		}
		// 3. 가능한 모든 간선 중에 n-1개 선택
		go(0, 0, list, islandNum - 1);

		if (total_len == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(total_len);
	}

}
