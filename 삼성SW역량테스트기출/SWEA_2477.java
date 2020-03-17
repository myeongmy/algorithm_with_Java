//[모의 SW 역량테스트] 차량 정비소
//시뮬레이션 문제 (시간 순 시뮬레이션 문제)
// 시간 순 시뮬레이션 문제는 시간을 1씩 증가시키면서 QUEUE에서 필요한 것을 꺼내다가 구현하면 된다.
/*고객이 차량 정비소에 지갑을 두고 갔다.

차량 정비소에서 근무하는 이 대리는 고객에게 지갑을 돌려주려고 한다.

하지만, 차량 정비소를 방문한 고객이 너무 많아 모두 전화하여 확인하기가 불가능하다.

다행히 지갑에는 고객만족도 설문지가 있다.

고객만족도 설문지에는 고객이 이용했던 접수 창구번호와 정비 창구번호가 있다.

이 대리는 이 정보를 이용하여 전화로 확인할 고객을 정하려고 한다.

차량 정비소에는 N개의 접수 창구와 M개의 정비 창구가 있다.

접수 창구는 1부터 N까지 번호가 붙어 있다. 정비 창구도 1부터 M까지 번호가 붙어 있다.

차량 정비소에는 [Fig. 1]와 같이 두 단계를 거쳐 고객의 차량을 정비한다.

첫 단계는 접수 창구에서 고장을 접수하는 것이고, 두 번째 단계는 정비 창구에서 차량을 정비하는 것이다.
 


[Fig. 1]

차량 정비가 끝난 고객은 고객만족도 조사를 위해 고객만족도 설문지를 받는다.

접수 창구 및 정비 창구의 담당자 업무 능력이 달라서 담당자 별 처리 시간이 다르다.

한 담당자의 처리 시간은 고객과 고장의 종류에 상관 없이 항상 같다.

접수 창구 i에서 고객 한 명의 고장을 접수하는 데 걸리는 처리 시간은 ai이다. (1 ≤ i ≤ N)

정비 창구 j에서 고객 한 명의 차량을 정비하는 데 걸리는 처리 시간은 bj이다. (1 ≤ j ≤ M)

지금까지 차량 정비소를 방문한 고객은 K명이다.

고객은 도착하는 대로 1번부터 고객번호를 부여 받는다.

고객번호 k의 고객이 차량 정비소에 도착하는 시간은 tk이다. (1 ≤ k ≤ K)

고객이 차량 정비소에 도착하면, 빈 접수 창구가 있는 경우 빈 접수 창구에 가서 고장을 접수한다.

빈 접수 창구가 없는 경우 빈 접수 창구가 생길 때까지 기다린다.

고장 접수를 완료하면 정비 창구로 이동한다.

빈 정비 창구가 있는 경우 빈 정비 창구에 가서 차량을 정비 받는다.

빈 정비 창구가 없는 경우 빈 정비 창구가 생길 때까지 기다린다.

접수 창구의 우선순위는 아래와 같다.

   ① 여러 고객이 기다리고 있는 경우 고객번호가 낮은 순서대로 우선 접수한다.
   ② 빈 창구가 여러 곳인 경우 접수 창구번호가 작은 곳으로 간다.


정비 창구의 우선순위는 아래와 같다.

   ① 먼저 기다리는 고객이 우선한다.
   ② 두 명 이상의 고객들이 접수 창구에서 동시에 접수를 완료하고 정비 창구로 이동한 경우, 이용했던 접수 창구번호가 작은 고객이 우선한다.
   ③ 빈 창구가 여러 곳인 경우 정비 창구번호가 작은 곳으로 간다.


고객이 차량 정비소에 도착하여 접수 창구로 가는 시간 또는 접수 창구에서 정비 창구로 이동하는 시간은 무시할 수 있다. 즉, 이동 시간은 0이다.

고객의 도착 시간 tk, 접수 창구의 처리 시간 ai, 정비 창구의 처리 시간 bj가 주어졌을 때, 지갑을 분실한 고객과 같은 접수 창구와 같은 정비 창구를 이용한 고객의 고객번호들을 찾아 그 합을 출력하는 프로그램을 작성하라.

만약, 그런 고객이 없는 경우 -1을 출력한다.


[예시]

[Fig. 2]과 같이 접수 창구가 2개, 정비 창구가 2개가 있다고 하자. (N = 2, M = 2)
 

[Fig. 2]


접수 창구의 처리 시간 ai와 정비 창구의 처리 시간 bj는 [Table 1]과 같이 주어진다.

 
[Table 1]


지금까지 고객 6명이 이용했다. (K = 6)

고객 k의 도착 시간 tk는 [Table 2]와 같이 주어진다.

 

[Table 2]


지갑을 분실한 고객은 접수 창구 1과 정비 창구 2를 이용했다고 한다.

이 대리는 지갑을 분실한 고객과 같은 접수 창구 1과 정비 창구 2를 이용한 고객들의 고객번호를 알고 싶어 한다.

시간 별 고객들의 이동은 [Fig. 3]와 같다.

[Fig. 3]
 

접수 창구 1과 정비 창구 2를 이용한 고객의 고객번호는 1과 6이다.

따라서, 정답은 1 + 6 = 7이다.


[제약사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 3초

2. 접수 창구의 개수 N과 정비 창구의 개수 M은 1 이상 9 이하의 정수이다. (1 ≤ N, M ≤ 9)

3. 접수 창구 i에서 고장을 접수하는 처리 시간 ai는 1 이상 20 이하의 정수이다. (1 ≤ ai ≤ 20)

4. 정비 창구 j에서 차량을 정비하는 처리 시간 bj는 1 이상 20 이하의 정수이다. (1 ≤ bj ≤ 20)

5. 차량 정비소를 방문한 고객의 수 K는 2 이상 1,000 이하의 정수이다. (2 ≤ K ≤ 1,000)

6. 고객 k의 도착 시간 tk는 0 이상 1,000 이하의 정수이다. (0 ≤ tk ≤ 1,000)

7. 지갑을 두고 간 고객이 이용한 접수 창구번호 A는 1 이상 N 이하의 정수이다. (1 ≤ A ≤ N)

8. 지갑을 두고 간 고객이 이용한 정비 창구번호 B는 1 이상 M 이하의 정수이다. (1 ≤ B ≤ M)

9. 창구번호와 고객번호는 1부터 시작한다.


[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 접수 창구의 개수 N, 정비 창구의 개수 M, 차량 정비소를 방문한 고객의 수 K, 지갑을 두고 간 고객이 이용한 접수 창구번호 A와 정비 창구번호 B가 주어진다.

두 번째 줄에는 i번째 접수 창구가 고장을 접수하는 데 걸리는 시간 ai가 N개 주어진다.

세 번째 줄에는 j번째 정비 창구가 차량을 정비하는 데 걸리는 시간 bj가 M개 주어진다.

네 번째 줄에는 k번째 고객이 차량 정비소를 방문하는 시간 tk가 순서대로 K개 주어진다.


[출력]

테스트 케이스의 개수만큼 T줄에 T개의 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 "#x"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (x는 1부터 시작하는 테스트 케이스의 번호이다)

출력해야 할 정답은 지갑을 두고 간 고객과 같은 접수 창구 A와 같은 정비 창구 B를 이용한 고객들의 고객번호의 합이다. 만약 그런 고객이 없는 경우 정답으로 -1을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Center implements Comparable<Center> {
	int num; // 고객 번호
	int arriveT; // 도착 시간

	Center(int num, int arriveT) {
		this.num = num;
		this.arriveT = arriveT;
	}

	public int compareTo(Center c) {
		if (this.arriveT < c.arriveT)
			return -1;
		else if (this.arriveT == c.arriveT) {
			if (this.num < c.num)
				return -1;
			else
				return 1;
		} else {
			return 1;
		}
	}
}

class Person {
	int receiptNum;
	int repairNum;

	Person(int r, int k) {
		receiptNum = r;
		repairNum = k;
	}
}

class Window {
	int demanding; // 총 소요시간
	int now; // 현재 진행된 시간
	int isEmpty; // 빈 창구인지, 아닌지 여부(0: 빈 곳)
	int customer;

	Window(int demanding, int now, int isEmpty, int customer) {
		this.demanding = demanding;
		this.now = now;
		this.isEmpty = isEmpty;
		this.customer = customer;
	}
}

public class SWEA_2477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt(); // 접수 창구 개수
			int M = s.nextInt(); // 정비 창구 개수
			int K = s.nextInt(); // 방문 고객 수
			int A = s.nextInt(); // 지갑을 두고 간 손님이 이용한 접수 창구 번호
			int B = s.nextInt(); // 지갑을 두고 간 손님이 이용한 정비 창구 번호

			Window[] Ai = new Window[N + 1];
			Window[] Bi = new Window[M + 1];
			PriorityQueue<Center> firstWaiting = new PriorityQueue<Center>();
			Queue<Integer> secondWaiting = new LinkedList<Integer>();
			Person[] result = new Person[K + 1];
			for (int j = 1; j <= K; j++)
				result[j] = new Person(0, 0);
			for (int j = 1; j <= N; j++)
				Ai[j] = new Window(s.nextInt(), 0, 0, 0);
			for (int j = 1; j <= M; j++)
				Bi[j] = new Window(s.nextInt(), 0, 0, 0);
			for (int j = 1; j <= K; j++)
				firstWaiting.offer(new Center(j, s.nextInt()));

			int time = 0;
			int numFinished = 0;
			while (numFinished != K) {
				// 정비 창구 시간+1
				for (int j = 1; j < Bi.length; j++) {
					if (Bi[j].isEmpty == 1) {
						Bi[j].now++;
						if (Bi[j].now == Bi[j].demanding) {
							Bi[j].isEmpty = 0;
							Bi[j].now = 0;
							numFinished++;
						}
					}

				}
				// 접수 창구 시간 +1
				for (int j = 1; j < Ai.length; j++) {
					if (Ai[j].isEmpty == 1) {
						Ai[j].now++;
						if (Ai[j].now == Ai[j].demanding) {
							Ai[j].isEmpty = 0;
							Ai[j].now = 0;
							secondWaiting.offer(Ai[j].customer);
						}
					}
				}
				// 줄에서 사람 뽑아서 정비 창구에 넣기
				for (int j = 1; j < Bi.length; j++) {
					if (Bi[j].isEmpty == 0 && !secondWaiting.isEmpty()) {
						Bi[j].customer = secondWaiting.poll();
						if (j == B) {
							result[Bi[j].customer].repairNum = B;
						}
						Bi[j].isEmpty = 1;
					}
				}
				// 줄에서 사람 뽑아서 창구에 넣기
				while (!firstWaiting.isEmpty() && firstWaiting.peek().arriveT <= time) {
					int flag = 0;
					for (int j = 1; j < Ai.length; j++) {
						if (Ai[j].isEmpty == 0) {
							flag = 1;
							Center c = firstWaiting.poll();
							if (j == A) {
								result[c.num].receiptNum = A;
							}
							Ai[j].isEmpty = 1;
							Ai[j].customer = c.num;
							break;
						}
					}
					if (flag == 0)
						break;
				}
				time++;
			}
			int tot = 0;
			for (int j = 1; j <= K; j++) {
				if (result[j].receiptNum == A && result[j].repairNum == B) {
					tot += j;
				}
			}
			if (tot == 0)
				tot = -1;
			System.out.println("#" + (i + 1) + " " + tot);
		}
	}

}
