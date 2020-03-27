//[모의SW역량테스트] 무선 충전
//시뮬레이션 + 브루트 포스 문제
/*스마트폰을 무선 충전 할 때 최적의 BC (Battery Charger)를 선택하는 알고리즘을 개발하고자 한다. [그림 1]과 같이 가로 세로 10*10 영역의 지도가 주어졌을 때, 설치된 BC 정보는 다음과 같다.
 

BC 1

BC 2

BC 3

위치 Location (X, Y)

(4, 4)

(7, 10)

(6, 3)

충전 범위 Coverage (C)

1

3

2

성능 Performance (P)

100

40

70

 

               
                                                             [그림 1]

 

 

BC의 충전 범위가 C일 때, BC와 거리가 C 이하이면 BC에 접속할 수 있다. 이때, 두 지점 A(XA, YA), B(XB, YB) 사이의 거리는 다음과 같이 구할 수 있다.

D = |XA – XB| + |YA – YB|

위의 [그림 1]에서 (4,3)과 (5,4) 지점은 BC 1과 BC 3의 충전 범위에 모두 속하기 때문에, 이 위치에서는 두 BC 중 하나를 선택하여 접속할 수 있다.
 

                       
                                                              [그림 2]
 

[그림 2]와 같이 사용자 A와 B의 이동 궤적이 주어졌다고 가정하자. T는 초(Second)를 의미한다. 예를 들어 5초에 사용자 A는 (5, 2) 지점에, 사용자 B는 (6, 9) 지점에 위치한다.

매초마다 특정 BC의 충전 범위에 안에 들어오면 해당 BC에 접속이 가능하다. 따라서 T=5에 사용자 A는 BC 3에, 사용자 B는 BC 2에 접속할 수 있다. 이때, 접속한 BC의 성능(P)만큼 배터리를 충전 할 수 있다. 만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.

BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 모든 사용자가 충전한 양의 합의 최댓값을 구하는 프로그램을 작성하라.
 

[그림 2]에서 T=11일 때, 사용자 A는 BC 1과 3 둘 중 하나에 접속이 가능하다. 같은 시간에 사용자 B는 BC 1에 접속할 수 밖에 없다. 따라서 사용자 A가 같은 BC 1에 접속한다면 충전되는 양를 반씩 나눠 갖게 되어 비효율적이다. 따라서 사용자 A가 BC 3에 접속하는 것이 더 이득이다.
 

T=11

사용자 A

사용자 B

충전량 합

접속한 BC
(충전량)

BC 1 (50)

BC 1 (50)

50 + 50 = 100

BC 3 (70)

BC 1 (100)

70 + 100 = 170

 
 

위 예제에서 매 초마다 충전한 양은 다음과 같다. 따라서 총 충전한 양의 총합은 720 + 480 = 1200 이다.
 

시간(T)

0

1

2

3

4

5

6

7

8

9

10

11

12

13

14

15

16

17

18

19

20

Sum

사용자A

0

0

0

0

0

70

70

70

70

70

70

70

0

70

0

0

40

40

40

0

40

720

사용자B

40

40

40

40

40

40

40

0

0

0

0

100

0

100

0

0

0

0

0

0

0

480

 

[제약사항]

1. 지도의 가로, 세로 크기는 10이다.
2. 사용자는 총 2명이며, 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
3. 총 이동 시간 M은 20이상 100이하의 정수이다. (20 ≤ M ≤ 100)
4. BC의 개수 A는 1이상 8이하의 정수이다. (1 ≤ A ≤ 8)
5. BC의 충전 범위 C는 1이상 4이하의 정수이다. (1 ≤ C ≤ 4)
6. BC의 성능 P는 10이상 500이하의 짝수이다. (10 ≤ P ≤ 500)
7. 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
8. 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다. 사용자가 지도 밖으로 이동하는 경우는 없다.
 

[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
테스트 케이스의 첫 번째 줄에는 총 이동 시간(M), BC의 개수(A)가 주어진다.
그 다음 2개의 줄에는 각각 사용자 A와 B의 이동 정보가 주어진다.
한 사용자의 이동 정보는 M개의 숫자로 구성되며, 각각의 숫자는 다음과 같이 매초마다 이동 방향을 의미한다.
 

숫자

0

1

2

3

4

이동 방향

이동하지 않음

상 (UP)

우 (RIGHT)

하 (DOWN)

좌 (LEFT)


그 다음 줄에는 A개의 줄에 걸쳐 BC의 정보가 주어진다.
하나의 BC 정보는 좌표(X, Y), 충전 범위(C), 처리량(P)로 구성된다.

 

[출력]

출력은 "#t"를 찍고 한 칸 띄운 다음 정답을 출력한다. (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
정답은 모든 사용자의 충전량 합의 최대값을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

public class SWEA_5644 {
	static int[][][] array = { { { 0, 0 } }, { { 0, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } },
			{ { 0, 0 }, { 0, -2 }, { 0, -1 }, { 0, 1 }, { 0, 2 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { -2, 0 },
					{ 1, -1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },
			{ { 0, 0 }, { 0, -3 }, { 0, -2 }, { 0, -1 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { -1, -2 }, { -1, -1 },
					{ -1, 0 }, { -1, 1 }, { -1, 2 }, { -2, -1 }, { -2, 0 }, { -2, 1 }, { -3, 0 }, { 1, -2 }, { 1, -1 },
					{ 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, -1 }, { 2, 0 }, { 2, 1 }, { 3, 0 } },
			{ { 0, -4 }, { 0, -3 }, { 0, -2 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { -1, -3 },
					{ -1, -2 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { -1, 2 }, { -1, 3 }, { -2, -2 }, { -2, -1 },
					{ -2, 0 }, { -2, 1 }, { -2, 2 }, { -3, -1 }, { -3, 0 }, { -3, 1 }, { -4, 0 }, { 1, -3 }, { 1, -2 },
					{ 1, -1 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, -2 }, { 2, -1 }, { 2, 0 }, { 2, 1 },
					{ 2, 2 }, { 3, -1 }, { 3, 0 }, { 3, 1 }, { 4, 0 } } };
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int M = Integer.parseInt(arr[0]); // 총 시간
				int A = Integer.parseInt(arr[1]); // 배터리 개수

				int[][] people = new int[2][M + 1]; // 사용자 이동 정보
				for (int j = 0; j < 2; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 1; k <= M; k++) {
						people[j][k] = Integer.parseInt(arr1[k - 1]);
					}
				}

				ArrayList<Integer>[][] land = (ArrayList<Integer>[][]) new ArrayList[10][10];
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++)
						land[j][k] = new ArrayList<Integer>();
				}

				int[] battery = new int[A + 1]; // 배터리 충전량 저장
				for (int j = 0; j < A; j++) {
					String[] arr2 = br.readLine().split(" ");
					int si = Integer.parseInt(arr2[1]) - 1;
					int sj = Integer.parseInt(arr2[0]) - 1;
					int c = Integer.parseInt(arr2[2]);
					int p = Integer.parseInt(arr2[3]);

					battery[j + 1] = p;
					for (int k = 0; k < array[c].length; k++) {
						if (si + array[c][k][0] >= 0 && si + array[c][k][0] < 10 && sj + array[c][k][1] >= 0
								&& sj + array[c][k][1] < 10)
							land[si + array[c][k][0]][sj + array[c][k][1]].add(j + 1);
					}
				}

				int Ai = 0;
				int Aj = 0;
				int Bi = 9;
				int Bj = 9;

				int result = 0;
				int time = 0;
				while (time != M + 1) {
					if (time == 0) {
						if (land[Ai][Aj].size() == 0 && land[Bi][Bj].size() == 0) {

						} else if (land[Ai][Aj].size() == 0 && land[Bi][Bj].size() != 0) {
							int max = Integer.MIN_VALUE;
							for (int k = 0; k < land[Bi][Bj].size(); k++) {
								if (max < battery[land[Bi][Bj].get(k)])
									max = battery[land[Bi][Bj].get(k)];
							}
							result += max;
						} else if (land[Ai][Aj].size() != 0 && land[Bi][Bj].size() == 0) {
							int max = Integer.MIN_VALUE;
							for (int k = 0; k < land[Ai][Aj].size(); k++) {
								if (max < battery[land[Ai][Aj].get(k)])
									max = battery[land[Ai][Aj].get(k)];
							}
							result += max;
						} else if (land[Ai][Aj].size() != 0 && land[Bi][Bj].size() != 0) {
							int max = Integer.MIN_VALUE;
							for (int j = 0; j < land[Ai][Aj].size(); j++) {
								for (int k = 0; k < land[Bi][Bj].size(); k++) {
									int mid = 0;
									if (land[Ai][Aj].get(j) == land[Bi][Bj].get(k)) {
										mid = battery[land[Ai][Aj].get(j)];
									} else if (land[Ai][Aj].get(j) != land[Bi][Bj].get(k)) {
										mid += battery[land[Ai][Aj].get(j)];
										mid += battery[land[Bi][Bj].get(k)];
									}
									if (max < mid)
										max = mid;
								}
							}
							result += max;
						}
					} else {
						Ai = Ai + dx[people[0][time]];
						Aj = Aj + dy[people[0][time]];
						Bi = Bi + dx[people[1][time]];
						Bj = Bj + dy[people[1][time]];

						if (land[Ai][Aj].size() == 0 && land[Bi][Bj].size() == 0) {

						} else if (land[Ai][Aj].size() == 0 && land[Bi][Bj].size() != 0) {
							int max = Integer.MIN_VALUE;
							for (int k = 0; k < land[Bi][Bj].size(); k++) {
								if (max < battery[land[Bi][Bj].get(k)])
									max = battery[land[Bi][Bj].get(k)];
							}
							result += max;
						} else if (land[Ai][Aj].size() != 0 && land[Bi][Bj].size() == 0) {
							int max = Integer.MIN_VALUE;
							for (int k = 0; k < land[Ai][Aj].size(); k++) {
								if (max < battery[land[Ai][Aj].get(k)])
									max = battery[land[Ai][Aj].get(k)];
							}
							result += max;
						} else if (land[Ai][Aj].size() != 0 && land[Bi][Bj].size() != 0) {
							int max = Integer.MIN_VALUE;
							for (int j = 0; j < land[Ai][Aj].size(); j++) {
								for (int k = 0; k < land[Bi][Bj].size(); k++) {
									int mid = 0;
									if (land[Ai][Aj].get(j) == land[Bi][Bj].get(k)) {
										mid = battery[land[Ai][Aj].get(j)];
									} else if (land[Ai][Aj].get(j) != land[Bi][Bj].get(k)) {
										mid += battery[land[Ai][Aj].get(j)];
										mid += battery[land[Bi][Bj].get(k)];
									}
									if (max < mid)
										max = mid;
								}
							}
							result += max;
						}
					}
					time++;
				}
				System.out.println("#" + (i + 1) + " " + result);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
