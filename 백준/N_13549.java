//백준 13549번
/*문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/

package 백준;

import java.util.*;

class Hide {
	int x;
	int cnt;

	Hide(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}

public class N_13549 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();

		// bfs 풀이
		int[] c = new int[100001]; // 방문 여부 저장
		ArrayDeque<Hide> q = new ArrayDeque<Hide>();

		c[N] = 1;
		q.offerLast(new Hide(N, 0));

		while (!q.isEmpty()) {
			Hide h = q.poll();
			if (h.x == K) {
				System.out.println(h.cnt);
				System.exit(0);
			}

			if (2 * h.x <= 100000 && c[2 * h.x] == 0) {
				q.offerFirst(new Hide(2 * h.x, h.cnt));
				c[2 * h.x] = 1;
			}
			if (h.x - 1 >= 0 && c[h.x - 1] == 0) {
				q.offerLast(new Hide(h.x - 1, h.cnt + 1));
				c[h.x - 1] = 1;
			}
			if (h.x + 1 <= 100000 && c[h.x + 1] == 0) {
				q.offerLast(new Hide(h.x + 1, h.cnt + 1));
				c[h.x + 1] = 1;
			}
		}
	}

}
