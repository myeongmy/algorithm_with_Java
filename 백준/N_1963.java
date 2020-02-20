//백준 1963번
//BFS 문제 + 에라토스테너스의 체
/*문제
소수를 유난히도 좋아하는 창영이는 게임 아이디 비밀번호를 4자리 ‘소수’로 정해놓았다. 어느 날 창영이는 친한 친구와 대화를 나누었는데:

“이제 슬슬 비번 바꿀 때도 됐잖아”
“응 지금은 1033으로 해놨는데... 다음 소수를 무엇으로 할지 고민중이야"
“그럼 8179로 해”
“흠... 생각 좀 해볼게. 이 게임은 좀 이상해서 비밀번호를 한 번에 한 자리 밖에 못 바꾼단 말이야. 예를 들어 내가 첫 자리만 바꾸면 8033이 되니까 소수가 아니잖아. 여러 단계를 거쳐야 만들 수 있을 것 같은데... 예를 들면... 1033 1733 3733 3739 3779 8779 8179처럼 말이야.”
“흠...역시 소수에 미쳤군. 그럼 아예 프로그램을 짜지 그래. 네 자리 소수 두 개를 입력받아서 바꾸는데 몇 단계나 필요한지 계산하게 말야.”
“귀찮아”
그렇다. 그래서 여러분이 이 문제를 풀게 되었다. 입력은 항상 네 자리 소수만(1000 이상) 주어진다고 가정하자. 주어진 두 소수 A에서 B로 바꾸는 과정에서도 항상 네 자리 소수임을 유지해야 하고, ‘네 자리 수’라 하였기 때문에 0039 와 같은 1000 미만의 비밀번호는 허용되지 않는다.

입력
첫 줄에 test case의 수 T가 주어진다. 다음 T줄에 걸쳐 각 줄에 1쌍씩 네 자리 소수가 주어진다.

출력
각 test case에 대해 두 소수 사이의 변환에 필요한 최소 회수를 출력한다. 불가능한 경우 Impossible을 출력한다.*/

package 백준;

import java.util.*;
import java.io.*;

class Game {
	int num;
	int cnt;

	Game(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class N_1963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			//미리 소수 구해두기 (에라토스테너스의 체 이용)
			boolean [] prime = new boolean[10000];    //true면 합성수, false면 소수
			for(int i=2;i<10000;i++) {
				if(prime[i] == false) {
					for(int j = i*2;j<10000;j += i)
						prime[j] = true;
				}
			}
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int a = Integer.parseInt(arr[0]);
				int b = Integer.parseInt(arr[1]);

				// bfs 풀이
				int[] c = new int[10000];
				Queue<Game> q = new LinkedList<Game>();

				c[a] = 1;
				q.offer(new Game(a, 0));
				while (!q.isEmpty()) {
					Game g = q.poll();
					if (g.num == b) {
						bw.write(Integer.toString(g.cnt));
						bw.newLine();
						break;
					}

					// 첫째자리 수 바꾸기
					int temp = g.num / 1000;
					for (int j = 1; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 1000 + g.num % 1000] == false && c[j * 1000 + g.num % 1000] == 0) {
							q.offer(new Game(j * 1000 + g.num % 1000, g.cnt + 1));
							c[j * 1000 + g.num % 1000] = 1;
						}
					}

					// 둘째자리 수 바꾸기
					temp = (g.num / 100) % 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 100 + g.num % 100 + (g.num / 1000) * 1000] == false && c[j * 100 + g.num % 100 + (g.num / 1000) * 1000] == 0) {
							q.offer(new Game(j * 100 + g.num % 100 + (g.num / 1000) * 1000, g.cnt + 1));
							c[j * 100 + g.num % 100 + (g.num / 1000) * 1000] = 1;
						}

					}

					// 셋째자리 수 바꾸기
					temp = (g.num % 100) / 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 10 + g.num % 10 + (g.num / 100) * 100] == false && c[j * 10 + g.num % 10 + (g.num / 100) * 100] == 0) {
							q.offer(new Game(j * 10 + g.num % 10 + (g.num / 100) * 100, g.cnt + 1));
							c[j * 10 + g.num % 10 + (g.num / 100) * 100] = 1;
						}
					}

					// 넷째자리 수 바꾸기
					temp = g.num % 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[(g.num / 10) * 10 + j] == false && c[(g.num / 10) * 10 + j] == 0) {
							q.offer(new Game((g.num / 10) * 10 + j, g.cnt + 1));
							c[(g.num / 10) * 10 + j] = 1;
						}
					}

				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
