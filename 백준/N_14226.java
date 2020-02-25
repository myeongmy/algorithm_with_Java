//백준 14226번
/*문제
영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
화면에 있는 이모티콘 중 하나를 삭제한다.
모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

출력
첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.*/

package 백준;

import java.util.*;

class Sticker {
	int s;
	int c;
	int cnt;

	Sticker(int s, int c, int cnt) {
		this.s = s;
		this.c = c;
		this.cnt = cnt;
	}
}

public class N_14226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int S = s.nextInt();
		int[][] c = new int[2000][2000]; // 방문 여부 저장

		Queue<Sticker> q = new LinkedList<Sticker>();
		c[1][0] = 1;
		q.offer(new Sticker(1, 0, 0));

		while (!q.isEmpty()) {
			Sticker st = q.poll();
			if(st.s == S) {
				System.out.println(st.cnt);
				System.exit(0);
			}
			// 1번째 연산: 클립보드에 화면에 있는 이모티콘 복사하기
			if (st.s < 2000 && c[st.s][st.s] == 0) {
				q.offer(new Sticker(st.s, st.s, st.cnt + 1));
				c[st.s][st.s] = 1;
			}
			
			//2번째 연산: 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			if(st.s+st.c < 2000 && c[st.s+st.c][st.c] == 0) {
				q.offer(new Sticker(st.s+st.c, st.c, st.cnt+1));
				c[st.s+st.c][st.c] = 1;
			}
			
			//3번째 연산: 화면에 있는 이모티콘 중 하나를 삭제
			if(st.s-1 >=0 && c[st.s-1][st.c] == 0) {
				q.offer(new Sticker(st.s-1, st.c, st.cnt+1));
				c[st.s-1][st.c] = 1;
			}
		}
	}

}
