//백준 19238번 스타트 택시
//bfs+시뮬레이션

package 삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_19238 {
	static class Point {
		int si;
		int sj;
		int fi;
		int fj;

		Point(int si, int sj, int fi, int fj) {
			this.si = si;
			this.sj = sj;
			this.fi = fi;
			this.fj = fj;
		}
	}

	static class Node implements Comparable<Node> {
		int i;
		int j;
		int cnt;

		Node(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		public int compareTo(Node n) {
			if (this.cnt < n.cnt) {
				return -1;
			} else if (this.cnt > n.cnt) {
				return 1;
			} else {
				if (this.i < n.i)
					return -1;
				else if (this.i > n.i)
					return 1;
				else {
					if (this.j < n.j)
						return -1;
					else if (this.j > n.j)
						return 1;
					else
						return 0;
				}
			}
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int fuel = Integer.parseInt(input[2]);

			int[][] A = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().split(" ");

				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(arr[j]);
					if (A[i][j] == 1)
						A[i][j] = 500; // 벽
				}
			}

			String[] arr = br.readLine().split(" ");
			int taxii = Integer.parseInt(arr[0]) - 1;
			int taxij = Integer.parseInt(arr[1]) - 1;

			Point[] person = new Point[M + 1]; // 각 손님의 출발지와 도착지 저장

			for (int i = 1; i <= M; i++) {
				String[] arr1 = br.readLine().split(" ");
				int si = Integer.parseInt(arr1[0]) - 1;
				int sj = Integer.parseInt(arr1[1]) - 1;
				int fi = Integer.parseInt(arr1[2]) - 1;
				int fj = Integer.parseInt(arr1[3]) - 1;

				person[i] = new Point(si, sj, fi, fj);
			}

			for (int i = 1; i <= M; i++) {
				A[person[i].si][person[i].sj] = i;
			}

			int remove = 0;

			while (true) {
				// 택시에서 승객까지 가는 최단 거리
				int dist = 0;
				int si = 0;
				int sj = 0;
				int personNum = 0;

				PriorityQueue<Node> pq = new PriorityQueue<Node>();
				int[][] c = new int[N][N];
				pq.offer(new Node(taxii, taxij, 0));
				c[taxii][taxij] = 1;

				while (!pq.isEmpty()) {
					Node n = pq.poll();
					if (A[n.i][n.j] != 500 && A[n.i][n.j] != 0) {
						dist = n.cnt;
						si = n.i;
						sj = n.j;
						personNum = A[n.i][n.j];

						break;
					}
					for (int i = 0; i < dx.length; i++) {
						if (n.i + dx[i] >= 0 && n.i + dx[i] < N && n.j + dy[i] >= 0 && n.j + dy[i] < N) {
							if (A[n.i + dx[i]][n.j + dy[i]] != 500 && c[n.i + dx[i]][n.j + dy[i]] == 0) {
								pq.offer(new Node(n.i + dx[i], n.j + dy[i], n.cnt + 1));
								c[n.i + dx[i]][n.j + dy[i]] = 1;
							}
						}
					}
				}
				if (personNum == 0) {
					System.out.println(-1); // 택시에서 승객으로 이동하는 것이 불가능(벽에 의해)
					System.exit(0);
				}

				fuel -= dist;
				if (fuel < 0)
					break;
				A[si][sj] = 0;

				// 손님 위치에서 목적지까지 가는 최단 거리
				int flag = 0;
				PriorityQueue<Node> q = new PriorityQueue<Node>();
				c = new int[N][N];
				q.offer(new Node(si, sj, 0));
				c[si][sj] = 1;
				while (!q.isEmpty()) {
					Node n = q.poll();

					if (n.i == person[personNum].fi && n.j == person[personNum].fj) {
						flag = 1;
						fuel -= n.cnt;
						if (fuel < 0)
							break;
						fuel += (n.cnt * 2);
						taxii = n.i;
						taxij = n.j;
						remove++;

						break;
					}
					for (int i = 0; i < dx.length; i++) {
						if (n.i + dx[i] >= 0 && n.i + dx[i] < N && n.j + dy[i] >= 0 && n.j + dy[i] < N) {
							if (A[n.i + dx[i]][n.j + dy[i]] != 500 && c[n.i + dx[i]][n.j + dy[i]] == 0) {   //오답의 원인(다른 승객이 있는 곳을 지나갈 수 있음)
								q.offer(new Node(n.i + dx[i], n.j + dy[i], n.cnt + 1));
								c[n.i + dx[i]][n.j + dy[i]] = 1;
							}
						}
					}
				}

				if (flag == 0) {    //모든 승객을 이동시킬 수 없는 경우(벽에 의해)
					System.out.println(-1);
					System.exit(0);
				}
				if (fuel < 0)
					break;
				if (remove == M)
					break;

			}

			if (fuel < 0)
				System.out.println(-1);
			else
				System.out.println(fuel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
