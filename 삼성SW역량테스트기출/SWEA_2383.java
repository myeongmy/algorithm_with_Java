//[모의 SW 역량테스트] 점심 식사시간
//브루트 포스 + 시뮬레이션 문제 (한번에 맞췄지만 다시 볼 문제이다.)
// 계단이 두 개이므로 그룹을 나누고(완전탐색) 시간을 1분씩 증가시키면서 해당 사람이 도착하면 각각 다른 큐로 이동시키면서 풀면 된다.
/*N*N 크기의 정사각형 모양의 방에 사람들이 앉아 있다.

점심을 먹기 위해 아래 층으로 내려가야 하는데, 밥을 빨리 먹기 위해 최대한 빠른 시간 내에 내려가야 한다.

방 안의 사람들은 P로, 계단 입구를 S라고 했을 때 [Fig. 1]은 사람의 위치와 계단 입구의 위치를 표시한 모습이다.

 


[Fig. 1]
 

이동 완료 시간은 모든 사람들이 계단을 내려가 아래 층으로 이동을 완료한 시간이다.

사람들이 아래층으로 이동하는 시간은 계단 입구까지 이동 시간과 계단을 내려가는 시간이 포함된다.


    ① 계단 입구까지 이동 시간
        - 사람이 현재 위치에서 계단의 입구까지 이동하는데 걸리는 시간으로 다음과 같이 계산한다.
        - 이동 시간(분) = | PR - SR | + | PC - SC |
          (PR, PC : 사람 P의 세로위치, 가로위치, SR, SC : 계단 입구 S의 세로위치, 가로위치)

    ② 계단을 내려가는 시간
        - 계단을 내려가는 시간은 계단 입구에 도착한 후부터 계단을 완전히 내려갈 때까지의 시간이다.
        - 계단 입구에 도착하면, 1분 후 아래칸으로 내려 갈 수 있다.
        - 계단 위에는 동시에 최대 3명까지만 올라가 있을 수 있다.
        - 이미 계단을 3명이 내려가고 있는 경우, 그 중 한 명이 계단을 완전히 내려갈 때까지 계단 입구에서 대기해야 한다.
        - 계단마다 길이 K가 주어지며, 계단에 올라간 후 완전히 내려가는데 K 분이 걸린다.


사람의 위치와 계단 입구의 위치 및 계단의 길이 정보가 표시된 N*N 크기의 지도가 주어진다.

이때, 모든 사람들이 계단을 내려가 이동이 완료되는 시간이 최소가 되는 경우를 찾고,

그 때의 소요시간을 출력하는 프로그램을 작성하라.


[예시]

방의 한 변의 길이 N 이 5인 지도가 [Fig. 2]와 같이 주어진 경우를 생각해보자.

지도 내에 1 은 사람을 나타내고, 2 이상 10 이하의 숫자는 계단의 입구를 나타내며 해당 숫자는 계단의 길이를 의미한다.

[Fig. 2]에는 사람 6명이 있고, 계단은 2개가 있으며 길이는 각각 3과 5이다.
 

[Fig. 2]


다음은 이동 완료되는 시간이 최소가 되는 경우 중 하나이다.

    - 1번, 2번, 3번 사람은 길이가 3인 1번 계단을 통해 이동

    - 4번, 5번, 6번 사람은 길이가 5인 2번 계단을 통해 이동





이 경우, 모든 사람이 계단을 내려가 이동 완료하는 최소 시간은 9분이다.

다른 예시로, 한 변의 길이가 N인 방에 [Fig. 3]과 같이 배치되어 있는 경우를 생각해보자.

지도 내에 1 은 사람을 나타내고, 2 이상 10 이하의 숫자는 계단의 입구를 나타내며 해당 숫자는 계단의 길이를 의미한다.

 

[Fig. 3]

 
다음은 이동이 완료되는 시간이 최소가 되는 경우 중 하나이다.

    - 1번, 2번, 3번, 4번 사람은 길이가 2인 1번 계단을 통해 이동

    - 5번, 6번 사람은 길이가 5인 2번 계단을 통해 이동







이 경우, 모든 사람이 계단을 내려가 이동 완료하는 최소 시간은 8분이다.


[제약 사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 3초

2. 방의 한 변의 길이 N은 4 이상 10 이하의 정수이다. (4 ≤ N ≤ 10)

3. 사람의 수는 1 이상 10 이하의 정수이다. (1 ≤ 사람의 수 ≤ 10)

4. 계단의 입구는 반드시 2개이며, 서로 위치가 겹치지 않는다.

5. 계단의 길이는 2 이상 10 이하의 정수이다. (2 ≤ 계단의 길이 ≤ 10)

6. 초기에 입력으로 주어지는 사람의 위치와 계단 입구의 위치는 서로 겹치지 않는다.


[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 방의 한 변의 길이 N이 주어진다.

다음 N줄에는 N*N 크기의 지도의 정보가 주어진다.

지도에서 1은 사람을, 2 이상은 계단의 입구를 나타내며 그 값은 계단의 길이를 의미한다.


[출력]

테스트 케이스의 개수만큼 T줄에 T개의 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 "#x"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (x는 1부터 시작하는 테스트 케이스의 번호이다)

정답은 이동이 완료되는 최소의 시간을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Point9 {
	int i;
	int j;
	int weight;

	Point9(int i, int j, int weight) {
		this.i = i;
		this.j = j;
		this.weight = weight;
	}
}

class SWEA implements Comparable<SWEA> {
	int num; // 사람 번호
	int dist; // 거리

	SWEA(int num, int dist) {
		this.num = num;
		this.dist = dist;
	}

	public int compareTo(SWEA sw) {
		if (this.dist < sw.dist)
			return -1;
		else if (this.dist == sw.dist) {
			if (this.num < sw.num)
				return -1;
			else
				return 1;
		} else {
			return 1;
		}
	}
}

public class SWEA_2383 {
	static LinkedList<Integer> first = new LinkedList<Integer>(); // first 계단에 속하는 사람 번호
	static LinkedList<Integer> second = new LinkedList<Integer>();
	static int min = Integer.MAX_VALUE;

	static void go(int index, ArrayList<Point9> people, Point9[] stair) {
		if (index == people.size()) {
			int time = 0;
			int time1 = 0;
			// first 계단 대상 시간 구하기
			if (first.size() != 0) {
				PriorityQueue<SWEA> q = new PriorityQueue<SWEA>();
				Queue<Integer> entrance = new LinkedList<Integer>(); // 계단 입구에 도착한 사람 번호
				LinkedList<SWEA> stairing = new LinkedList<SWEA>();
				for (int i = 0; i < first.size(); i++) {
					int a = first.get(i);
					int distance = Math.abs(people.get(a).i - stair[0].i) + Math.abs(people.get(a).j - stair[0].j);
					q.offer(new SWEA(a, distance));
				}

				int numFinished = 0; // 이동 완료 끝난 사람 수
				while (first.size() != numFinished) {
					while (!entrance.isEmpty() && stairing.size() < 3) { // 계단 입구에 있는 것 내리기
						stairing.add(new SWEA(entrance.poll(), 0));
					}
					while (!q.isEmpty() && q.peek().dist == time)
						entrance.offer(q.poll().num);
					for (int j = stairing.size() - 1; j >= 0; j--) {
						stairing.get(j).dist++;
						if (stairing.get(j).dist == stair[0].weight) {
							stairing.remove(j);
							numFinished++;
						}

					}
					time++;
				}
			}

			// second 계단 대상 시간 구하기
			if (second.size() != 0) {
				PriorityQueue<SWEA> q = new PriorityQueue<SWEA>();
				Queue<Integer> entrance = new LinkedList<Integer>(); // 계단 입구에 도착한 사람 번호
				LinkedList<SWEA> stairing = new LinkedList<SWEA>();
				for (int i = 0; i < second.size(); i++) {
					int a = second.get(i);
					int distance = Math.abs(people.get(a).i - stair[1].i) + Math.abs(people.get(a).j - stair[1].j);
					q.offer(new SWEA(a, distance));
				}

				int numFinished = 0; // 이동 완료 끝난 사람 수
				while (second.size() != numFinished) {
					while (!entrance.isEmpty() && stairing.size() < 3) { // 계단 입구에 있는 것 내리기
						stairing.add(new SWEA(entrance.poll(), 0));
					}
					while (!q.isEmpty() && q.peek().dist == time1)
						entrance.offer(q.poll().num);
					for (int j = stairing.size() - 1; j >= 0; j--) { // remove 할 때 인덱스 거꾸로 접근하는 것이 중요!!
						stairing.get(j).dist++;
						if (stairing.get(j).dist == stair[1].weight) {
							stairing.remove(j);
							numFinished++;
						}

					}
					time1++;
				}
			}
			int total = Math.max(time, time1);
			if (min > total)
				min = total;
			return;
		}

		first.add(index);
		go(index + 1, people, stair);
		first.remove(first.size() - 1);

		second.add(index);
		go(index + 1, people, stair);
		second.remove(second.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			int[][] A = new int[N][N];
			Point9[] stair = new Point9[2]; // 계단 위치 저장
			stair[0] = new Point9(0, 0, 0);
			stair[1] = new Point9(0, 0, 0);
			ArrayList<Point9> people = new ArrayList<Point9>(); // 사람의 위치 저장

			int idx = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					A[j][k] = s.nextInt();
					if (A[j][k] >= 2) {
						stair[idx].i = j;
						stair[idx].j = k;
						stair[idx].weight = A[j][k];
						idx++;
					}
					if (A[j][k] == 1) { // 사람
						people.add(new Point9(j, k, 0));
					}
				}
			}
			go(0, people, stair);
			System.out.println("#" + (i + 1) + " " + min);
			min = Integer.MAX_VALUE;
		}
	}

}
