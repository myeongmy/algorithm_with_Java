//백준 1697번
/*문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/

package 백준;

import java.util.*;

public class N_1697 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();

		int[] c = new int[200000]; // 방문 여부 및 거리 저장

		Queue<Integer> q = new LinkedList<Integer>();
		c[N] = 1;
		q.offer(N);

		while (!q.isEmpty()) {
			int a = q.poll();
			int[] dx = { -1, 1, a };
			for (int i = 0; i < dx.length; i++) {
				if (a + dx[i] >= 0 && a + dx[i] < 200000) {
					if (c[a + dx[i]] == 0) {
						q.offer(a + dx[i]);
						c[a + dx[i]] = c[a] + 1;
					}
				}
			}
			if (c[K] != 0)
				break;
		}
		System.out.println(c[K] - 1);

	}

}
