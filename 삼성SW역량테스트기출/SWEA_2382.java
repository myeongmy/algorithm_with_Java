//[모의 SW 역량테스트] 미생물 격리
// 시뮬레이션 문제
/*정사각형 구역 안에 K개의 미생물 군집이 있다.

이 구역은 가로 N개, 세로 N개, 총 N * N 개의 동일한 크기의 정사각형 셀들로 이루어져 있다.

미생물들이 구역을 벗어나는걸 방지하기 위해, 가장 바깥쪽 가장자리 부분에 위치한 셀들에는 특수한 약품이 칠해져 있다.

[Fig. 1]은 9개의 군집이 한 변이 7개의 셀로 이루어진 구역에 배치되어 있는 예이다.

가장자리의 빨간 셀은 약품이 칠해져 있는 셀이다.



[Fig. 1]
 

   ① 최초 각 미생물 군집의 위치와 군집 내 미생물의 수, 이동 방향이 주어진다. 약품이 칠해진 부분에는 미생물이 배치되어 있지 않다. 이동방향은 상, 하, 좌, 우 네 방향 중 하나이다.

   ② 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동한다.

   ③ 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 
       미생물 수가 홀수인 경우 반으로 나누어 떨어지지 않으므로, 다음과 같이 정의한다.
       살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
       따라서 군집에 미생물이 한 마리 있는 경우 살아남은 미생물 수가 0이 되기 때문에, 군집이 사라지게 된다,

   ④ 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다. 
       합쳐 진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다. 
       합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.
     

M 시간 동안 이 미생물 군집들을 격리하였다. M시간 후 남아 있는 미생물 수의 총합을 구하여라.

시간에 지남에 따라 군집이 변하는 예를 보자.

[Fig. 2]은 최초 군집의 배치를 그림으로 표현한 것이다. 이는 예제 입력 1번과 동일하다. (N = 7, K = 9)
 

[Fig. 2]

1시간 후 [Fig. 3]과 같이 군집들이 이동한다.

A 군집은 약품이 칠해진 구역(가장 자리의 빨간 셀)로 이동하게 되어, 미생물 중3마리만 남고 나머지는 죽는다. 이동 방향은 상에서 하로 바뀐다.

D, E, F 군집은 모두 세로 위치 3, 가로 위치 3에 위치한 셀로 모이게 되며, 합쳐진 군집의 미생물 수는 8 + 14 + 3 = 25가 된다.

E 군집의 미생물 수가 가장 많기 때문에, 합쳐 진 군집의 이동 방향은 E 군집의 이동 방향인 상이 된다.

G, H 군집도 세로 위치 2, 가로 위치 5에 위치한 셀로 모이게 되며, 미생물 수는 108이 되고 이동 방향은 상이 된다.

 

[Fig. 3]


시작으로부터 2시간이 지났을 때, [Fig. 4]와 같이 군집들이 이동한다.

A, B 그룹은 이동 중 섞이지 않고 각 그룹의 이동 방향으로 움직이는데, B 그룹은 약품이 칠해진 셀로 이동하므로 미생물 수가 7에서 3으로 반감하고, 이동 방향이 상에서 하로 바뀐다.
 
 

[Fig. 4]


2시간이 지난 후, 남아 있는 미생물 수는 총 3 + 3 + 5 + 25 + 108 + 1 = 145이다.


[제약사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 5초

2. 구역의 모양은 정사각형으로 주어지며, 한 변의 셀의 개수 N은 5이상 100이하의 정수이다. (5 ≤ N ≤ 100)

3. 최초 배치되어 있는 미생물 군집의 개수 K는 5이상 1,000이하의 정수이다. (5 ≤ K ≤ 1,000)

4. 격리 시간 M은 1이상 1,000이하의 정수이다. (1 ≤ M ≤ 1,000)

5. 최초 약품이 칠해진 가장자리 부분 셀에는 미생물 군집이 배치되어 있지 않다.

6. 최초에 둘 이상의 군집이 동일한 셀에 배치되는 경우는 없다.

7. 각 군집 내 미생물 수는 1 이상 10,000 이하의 정수이다.

8. 군집의 이동방향은 상하좌우 4방향 중 한 방향을 가진다. (상: 1, 하: 2, 좌: 3, 우: 4)

9. 주어진 입력으로 진행하였을 때, 동일한 셀에 같은 미생물 수를 갖는 두 군집이 모이는 경우는 발생하지 않는다.

10.  각 군집의 정보는 세로 위치, 가로 위치, 미생물 수, 이동 방향 순으로 주어진다. 각 위치는 0번부터 시작한다.


[입력]

첫 줄에는 총 테스트 케이스의 개수 T가 주어진다.

그 다음 줄부터 T개의 테스트 케이스가 차례대로 주어진다.

각 테스트 케이스의 첫째 줄에는 구역의 한 변에 있는 셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K가 순서대로 주어지며, 다음 K줄에 걸쳐서 미생물 군집 K개의 정보가 주어진다.

미생물 군집의 정보는 세로 위치, 가로 위치, 미생물 수, 이동 방향 순으로 4개의 정수가 주어진다.


[출력]

테스트 케이스의 개수 만큼 T개의 줄에 각 테스트 케이스에 대한 답을 출력한다.

각 줄은 “#x”로 시작하고, 공백을 하나 둔 후 정답을 출력한다. (x는 테스트 케이스의 번호이며, 1번부터 시작한다.)

출력해야 할 정답은 M시간 후 남아 있는 미생물 수의 총 합이다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Gunzip {
	int i;
	int j;
	int num;
	int dir;

	Gunzip(int i, int j, int num, int dir) {
		this.i = i;
		this.j = j;
		this.num = num;
		this.dir = dir;
	}
}

public class SWEA_2382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt(); // 구역 크기
			int M = s.nextInt();
			int K = s.nextInt(); // 군집 개수

			Gunzip[] arr = new Gunzip[K]; // 각 미생물 군집에 대한 정보를 저장하는 배열(배열 인덱스: 군집 번호 의미)
			ArrayList<Integer>[][] A = (ArrayList<Integer>[][]) new ArrayList[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					A[j][k] = new ArrayList<Integer>(); // 각 지점에 있는 미생물 군집 번호 저장
				}
			}
			for (int j = 0; j < K; j++) {
				arr[j] = new Gunzip(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
				A[arr[j].i][arr[j].j].add(j);
			}
			// 시뮬레이션 실행
			int time = 0;
			Queue<Integer> q = new LinkedList<Integer>(); // 군집 번호 저장
			while (time != M) {
				// 큐에 군집 넣기
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (A[j][k].size() != 0)
							q.offer(A[j][k].get(0));
					}
				}
				while (!q.isEmpty()) {
					int num = q.poll();
					if (arr[num].dir == 1) { // 상

						A[arr[num].i][arr[num].j].remove(0); // 원래 위치 지우기
						if (arr[num].i - 1 == 0) {
							arr[num].dir = 2;
							arr[num].num /= 2;
						}
						A[arr[num].i - 1][arr[num].j].add(num);
						arr[num].i -= 1; // 위치 업데이트
					} else if (arr[num].dir == 2) { // 하

						A[arr[num].i][arr[num].j].remove(0);
						if (arr[num].i + 1 == N - 1) {
							arr[num].dir = 1;
							arr[num].num /= 2;
						}
						A[arr[num].i + 1][arr[num].j].add(num);
						arr[num].i += 1;
					} else if (arr[num].dir == 3) {

						A[arr[num].i][arr[num].j].remove(0);
						if (arr[num].j - 1 == 0) {
							arr[num].dir = 4;
							arr[num].num /= 2;
						}
						A[arr[num].i][arr[num].j - 1].add(num);
						arr[num].j -= 1;
					} else if (arr[num].dir == 4) {

						A[arr[num].i][arr[num].j].remove(0);
						if (arr[num].j + 1 == N - 1) {
							arr[num].dir = 3;
							arr[num].num /= 2;
						}
						A[arr[num].i][arr[num].j + 1].add(num);
						arr[num].j += 1;
					}
				}

				// 두 개 이상의 군집이 한 셀에 모이는 경우 처리
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (A[j][k].size() >= 2) {
							int max = Integer.MIN_VALUE;
							int max_dir = 0;
							int sum = 0;
							for (int r = 0; r < A[j][k].size(); r++) {
								sum += arr[A[j][k].get(r)].num;
								if (max < arr[A[j][k].get(r)].num) {
									max = arr[A[j][k].get(r)].num;
									max_dir = arr[A[j][k].get(r)].dir;
								}
							}
							arr[A[j][k].get(0)].num = sum;
							arr[A[j][k].get(0)].dir = max_dir;
							for (int r = A[j][k].size() - 1; r >= 0; r--) {    //오류 원인. 리스트에서 원소 제거할 때는 뒤에서 부터 제거해야 인덱스 에러 나지 않는다.
								if (r != 0)
									A[j][k].remove(r);
							}
						}
					}
				}
				time++;
			}
			int result = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (A[j][k].size() != 0) {
						result += arr[A[j][k].get(0)].num;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}

}
