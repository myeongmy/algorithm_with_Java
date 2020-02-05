//백준 5014번
//BFS 문제

/*문제
강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.

스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.

보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)

강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.

입력
첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.

출력
첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력한다. 만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.*/

package 백준;

import java.util.*;

class Stair {
	int num;
	int cnt;

	Stair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class N_5014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int F = s.nextInt(); // 총 수
		int S = s.nextInt(); // 현재 층
		int G = s.nextInt(); // 목표 층
		int U = s.nextInt(); // 한 번 누르면 위로 몇 층 올라가는지
		int D = s.nextInt(); // 한 번 누르면 아래로 몇 층 내려가는지
		int[] A = new int[F + 1]; // 방문 여부 저장

		Queue<Stair> q = new LinkedList<Stair>();
		A[S] = 1;
		q.offer(new Stair(S, 0));

		while (!q.isEmpty()) {
			Stair st = q.poll();
			if (st.num == G) {
				System.out.println(st.cnt);
				System.exit(0);
			}
			if (st.num + U < A.length && A[st.num + U] == 0) {
				A[st.num + U] = 1;
				q.offer(new Stair(st.num + U, st.cnt + 1));
			}

			if (st.num - D >= 1 && A[st.num - D] == 0) {
				A[st.num - D] = 1;
				q.offer(new Stair(st.num - D, st.cnt + 1));
			}
		}
		System.out.println("use the stairs");

	}

}
