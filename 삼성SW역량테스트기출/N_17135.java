//백준 17135번 (캐슬 디펜스)
//시뮬레이션 문제
/*문제
캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.

성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다. 

게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 따라서, 이 게임은 궁수의 위치가 중요하다. 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.

격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

입력
첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다.

출력
첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.*/

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

public class N_17135 {
	static LinkedList<Point> enemy;
	static int[] result = new int[5];
	static int max_cnt = 0;
	static int cnt;
	static int N;
	static int M;
	static int D;

	static void go(int index, int selected, int[][] A) {
		if (selected == 3) {
			Queue<Point> q = new LinkedList<Point>(); // 이번 턴에 삭제할 적의 위치
			int[][] B = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++)
				B[i] = A[i].clone();
			cnt = 0;
			while (true) {
				int numOfOne = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (B[i][j] == 1) {
							numOfOne++;
							enemy.offer(new Point(i, j));
						}
					}
				}
				if (numOfOne == 0) // 게임종료
					break;
				for (int i = 0; i < 3; i++) {
					int min_dist = 10000;
					Point min_po = new Point(-1, -1);
					for (int j = 0; j < enemy.size(); j++) {
						int dist = Math.abs(enemy.get(j).i - N) + Math.abs(enemy.get(j).j - result[i]);
						if (dist <= D && min_dist > dist) {
							min_dist = dist;
							min_po.i = enemy.get(j).i;
							min_po.j = enemy.get(j).j;
						} else if (dist <= D && min_dist == dist && min_po.j > enemy.get(j).j) {
							min_po.i = enemy.get(j).i;
							min_po.j = enemy.get(j).j;
						}
					}
					q.offer(new Point(min_po.i, min_po.j));
				}
				// 적 공격
				while (!q.isEmpty()) {
					Point p = q.poll();
					if (p.i != -1 && p.j != -1 && B[p.i][p.j] == 1) {
						B[p.i][p.j] = 0;
						cnt++;
					}

				}

				// 적 내려옴
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (B[i][j] == 1) {
							B[i][j] = 0;
							if (i + 1 < N)
								B[i + 1][j] = 1;
						}
					}
				}
				enemy.clear();
			}
			if (max_cnt < cnt) {
				max_cnt = cnt;
			}
			return;
		}
		if (index >= M )
			return;
		result[selected] = index;
		go(index + 1, selected + 1, A);
		result[selected] = 0;

		go(index + 1, selected, A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		D = s.nextInt(); // 궁수의 공격 거리 제한
		int[][] A = new int[N][M];
		enemy = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 1)
					enemy.offer(new Point(i, j));
			}
		}
		go(0, 0, A);
		System.out.println(max_cnt);
	}

}
