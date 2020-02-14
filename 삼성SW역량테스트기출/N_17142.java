//백준 17142번 (연구소 3)
//BFS + 브루트 포스(조합) 문제
/*문제
인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다. 바이러스는 활성 상태와 비활성 상태가 있다. 가장 처음에 모든 바이러스는 비활성 상태이고, 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다. 승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.

연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스의 위치이다.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2
M = 3이고, 바이러스를 아래와 같이 활성 상태로 변경한 경우 6초면 모든 칸에 바이러스를 퍼뜨릴 수 있다. 벽은 -, 비활성 바이러스는 *, 활성 바이러스는 0, 빈 칸은 바이러스가 퍼지는 시간으로 표시했다.

* 6 5 4 - - 2
5 6 - 3 - 0 1
4 - - 2 - 1 2
3 - 2 1 2 2 3
2 2 1 0 1 - -
1 - 2 1 2 3 4
0 - 3 2 3 4 *
시간이 최소가 되는 방법은 아래와 같고, 4초만에 모든 칸에 바이러스를 퍼뜨릴 수 있다.

0 1 2 3 - - 2
1 2 - 3 - 0 1
2 - - 2 - 1 2
3 - 2 1 2 2 3
3 2 1 0 1 - -
4 - 2 1 2 3 4
* - 3 2 3 4 *
연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.

입력
첫째 줄에 연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)이 주어진다.

둘째 줄부터 N개의 줄에 연구소의 상태가 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 위치이다. 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.

출력
연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다. 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_17142 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static char[][] A;
	static int min = 100000;    //min을 1000으로 잡아서 에러났었음.

	static void go(int index, int selected, ArrayList<Point> list, int M) {
		if (selected == M) {
			// 배열 복사
			char[][] B = new char[A.length][A[0].length];
			for (int i = 0; i < B.length; i++)
				B[i] = A[i].clone();

			// BFS
			Queue<Point> q = new LinkedList<Point>();
			int[][] c = new int[A.length][A[0].length];
			for (int i = 0; i < result.size(); i++) {
				B[list.get(result.get(i)).i][list.get(result.get(i)).j] = '0';
				q.offer(new Point(list.get(result.get(i)).i, list.get(result.get(i)).j));
				c[list.get(result.get(i)).i][list.get(result.get(i)).j] = 1;
			}

			while (!q.isEmpty()) {
				Point p = q.poll();

				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < B.length && p.j + dy[i] >= 0 && p.j + dy[i] < B[0].length) {
						if (c[p.i + dx[i]][p.j + dy[i]] == 0 && B[p.i + dx[i]][p.j + dy[i]] != '1') {    //벽이 아니면 비활성 바이러스 쪽으로도 퍼져나갈 수 있음
							q.offer(new Point(p.i + dx[i], p.j + dy[i]));
							c[p.i + dx[i]][p.j + dy[i]] = c[p.i][p.j] + 1;
						}
					}
				}
			}
			// 최대값 구하기 및 모두 다 퍼졌는지 확인
			int max = -1;
			for (int i = 0; i < B.length; i++) {
				for (int j = 0; j < B[0].length; j++) {
					if (B[i][j] != '*' && c[i][j] > max)    //다 돌고나서 비활성 상태였던 부분은 고려하면 안되므로 조건 추가
						max = c[i][j];
					if (B[i][j] == '0' && c[i][j] == 0)
						return;
				}
			}
			if (min > max-1)
				min = max - 1;

			return;
		}
		if (index >= list.size())
			return;
		result.add(index);
		go(index + 1, selected + 1, list, M);
		result.remove(result.size() - 1);

		go(index + 1, selected, list, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		A = new char[N][N];
		ArrayList<Point> list = new ArrayList<Point>(); // 활성 바이러스가 놓일 수 있는 위치 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.next().charAt(0);
				if (A[i][j] == '2') {
					list.add(new Point(i, j));
					A[i][j] = '*';
				}
			}
		}
		// M개 선택
		go(0, 0, list, M);
		if (min == 100000) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(min);
	}

}
