//백준 14502번
//BFS 문제
/*문제
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.*/

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

public class N_14502 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[] result = new int[5];
	static ArrayList<Point> list2 = new ArrayList<Point>(); // 1이 있는 부분 인덱스 저장 해둔것
	static Queue<Point> q = new LinkedList<Point>();
	static int max = -1;

	static void go(int index, int selected, ArrayList<Point> list, int[][] A) {
		if (selected == 3) {
			int[][] visited = new int[A.length][A[0].length];
			for (int i = 0; i < visited.length; i++)
				visited[i] = A[i].clone();

			// 벽 생성
			for (int i = 0; i < selected; i++) {
				visited[list.get(result[i]).i][list.get(result[i]).j] = 1;
			}

			// bfs 수행
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if(visited[i][j] == 2)
						q.offer(new Point(i, j));
				}
				
			}
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < dx.length; i++) {
					if (p.i + dx[i] >= 0 && p.i + dx[i] < A.length && p.j + dy[i] >= 0 && p.j + dy[i] < A[0].length) {
						if (visited[p.i + dx[i]][p.j + dy[i]] == 0) {
							visited[p.i + dx[i]][p.j + dy[i]] = 2;
							q.offer(new Point(p.i + dx[i], p.j + dy[i]));
						}
					}
				}
			}

			// 0의 개수 계산
			int numZero = 0;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if (visited[i][j] == 0)
						numZero++;
				}
			}

			if (max < numZero)
				max = numZero;

			return;
		}
		if (index >= list.size())
			return;

		result[selected] = index;
		go(index + 1, selected + 1, list, A);
		result[selected] = 0;

		go(index + 1, selected, list, A);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		ArrayList<Point> list = new ArrayList<Point>(); // 0이 있는 부분 인덱스 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 0)
					list.add(new Point(i, j));
				if (A[i][j] == 2)
					q.offer(new Point(i, j));
				if (A[i][j] == 1)
					list2.add(new Point(i, j));
			}
		}

		// 리스트에서 세 개 선택
		go(0, 0, list, A);

		System.out.println(max);
	}

}
