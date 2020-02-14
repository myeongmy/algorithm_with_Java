//백준 17140번 (이차원 배열과 연산)
//시뮬레이션 + 정렬 문제
/*문제
크기가 3×3인 배열 A가 있다. 1초가 지날때마다 배열에 연산이 적용된다.

R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다. 그 다음, 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다. 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다. 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.

예를 들어, [3, 1, 1]에는 3이 1번, 1가 2번 등장한다. 따라서, 정렬된 결과는 [3, 1, 1, 2]가 된다. 다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다. 다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.

정렬된 결과를 배열에 다시 넣으면 행 또는 열의 크기가 커질 수 있다. R 연산이 적용된 경우에는 행의 크기가 가장 큰 행을 기준으로 모든 행의 크기가 커지고, C 연산이 적용된 경우에는 열의 크기가 가장 큰 열을 기준으로 모든 열의 크기가 커진다. 행 또는 열의 크기가 커진 곳에는 0이 채워진다. 수를 정렬할 때 0은 무시해야 한다. 예를 들어, [3, 2, 0, 0]을 정렬한 결과는 [3, 2]를 정렬한 결과와 같다.

행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.

배열 A에 들어있는 수와 r, c, k가 주어졌을 때, A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간을 구해보자.

입력
첫째 줄에 r, c, k가 주어진다. (1 ≤ r, c, k ≤ 100)

둘째 줄부터 3개의 줄에 배열 A에 들어있는 수가 주어진다. 배열 A에 들어있는 수는 100보다 작거나 같은 자연수이다.

출력
A[r][c]에 들어있는 값이 k가 되기 위한 연산의 최소 시간을 출력한다. 이 값이 100을 넘어가는 경우에는 -1을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Po implements Comparable<Po> {
	int num;
	int time;

	Po(int num, int time) {
		this.num = num;
		this.time = time;
	}

	public int compareTo(Po p) {
		if (this.time < p.time)
			return -1;
		else if (this.time > p.time)
			return 1;
		else if (this.time == p.time) {
			if (this.num < p.num)
				return -1;
			else if (this.num > p.num)
				return 1;
		}
		return 0;
	}
}

public class N_17140 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int c = s.nextInt();
		int k = s.nextInt();
		int cur_x = 3;
		int cur_y = 3;
		int[][] A = new int[105][105];
		for (int i = 0; i < cur_x; i++) {
			for (int j = 0; j < cur_y; j++) {
				A[i][j] = s.nextInt();
			}
		}

		int time = 0;
		while (true) {
			if (time > 100) {
				System.out.println(-1);
				System.exit(0);
			}
			if (A[r - 1][c - 1] == k)
				break;
			if (cur_x >= cur_y) {
				int new_y = 0;
				for (int i = 0; i < cur_x; i++) {
					HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
					for (int j = 0; j < cur_y; j++) {
						if (A[i][j] == 0)
							continue;
						hm.put(A[i][j], hm.getOrDefault(A[i][j], 0) + 1);
					}
					Set<Integer> set = hm.keySet();
					Iterator<Integer> it = set.iterator();
					PriorityQueue<Po> q = new PriorityQueue<Po>();
					while (it.hasNext()) {
						int a = it.next();
						q.offer(new Po(a, hm.get(a)));
					}
					if (q.size() * 2 > new_y)
						new_y = q.size() * 2;
					int j = 0;
					while (!q.isEmpty()) {
						Po p = q.poll();
						A[i][j] = p.num;
						A[i][j + 1] = p.time;
						j += 2;
					}
					for (int z = j; z < cur_y; z++) { // 이 부분 처리를 안해줘서 맨 끝에 0이 아닌 숫자가 남아 있어서 오류 났었음.
						A[i][z] = 0;
					}

				}
				cur_y = new_y;

			} else if (cur_x < cur_y) {
				int new_x = 0;
				for (int i = 0; i < cur_y; i++) {
					HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
					for (int j = 0; j < cur_x; j++) {
						if (A[j][i] == 0)
							continue;
						hm.put(A[j][i], hm.getOrDefault(A[j][i], 0) + 1);
					}
					Set<Integer> set = hm.keySet();
					Iterator<Integer> it = set.iterator();
					PriorityQueue<Po> q = new PriorityQueue<Po>();
					while (it.hasNext()) {
						int a = it.next();
						q.offer(new Po(a, hm.get(a)));
					}
					if (q.size() * 2 > new_x)
						new_x = q.size() * 2;
					int j = 0;
					while (!q.isEmpty()) {
						Po p = q.poll();
						A[j][i] = p.num;
						A[j + 1][i] = p.time;
						j += 2;
					}
					for (int z = j; z < cur_x; z++) {
						A[z][i] = 0;
					}
				}
				cur_x = new_x;

			}
			time++;
		}
		System.out.println(time);

	}

}
