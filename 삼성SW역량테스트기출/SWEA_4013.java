//[모의 SW 역량테스트] 특이한 자석
//시뮬레이션 문제
/*엔지니어링 선표는 일을 하던 도중 창고에서 특이한 자석이 놓여있는 판을 발견했다.

이 판에는 4개의 자석이 놓여져 있었고, 각 자석은 8개의 ‘날’(튀어나온 곳)를 가지고 있다.

자석의 각 날 마다 N 극 또는 S 극의 자성을 가지고 있다.

이 특이한 자석은 [Fig. 1] 과 같이 1 번부터 4 번까지 판에 일렬로 배치되어 있고,

빨간색 화살표 위치에 날 하나가 오도록 배치되어 있다.

 
                       
심심한 선표는 이 특이한 자석을 가지고 놀아보니 신기한 규칙을 발견했다.

임의의 자석을 1 칸씩 K 번 회전시키려고 해보니,

하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 인력에 의해 반대 방향으로 1 칸 회전된다.

이를 신기하게 생각한 선표는 무작위로 자석을 돌렸을 때, 모든 회전이 끝난 후, 아래와 같은 방법으로 점수를 계산을 하고자 한다.

- 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.

- 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.

- 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.

- 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.

 

4 개 자석의 자성 정보와 자석을 1 칸씩 K 번 회전시키려고 할 때,

K 번 자석을 회전시킨 후 획득하는 점수의 총 합을 출력하는 프로그램을 작성하라.

 

[예시]

[Fig. 1] 과 같이 자석의 자성 정보가 주어지고, 아래의 순서와 같이 자석을 1 칸씩 2 번 회전시키는 경우를 생각해보자.

① 1 번 자석을 시계방향으로 회전

② 3 번 자석을 반시계 방향으로 회전

 

[Fig. 2-1] 에서 1 번 자석을 시계방향으로 1 칸 회전시키면, 2 번 자석은 1 번 자석과 서로 붙어 있는 날의 자성이 달라 반시계 방향으로 1 칸 회전된다.

이 때, 3 번 자석은 2 번 자석과 서로 붙어 있는 날의 자성이 N 극으로 같아서 회전되지 않는다.

3 번 자석이 회전되지 않기 때문에 4 번 자석도 회전되지 않는다.



                      
[Fig. 2-1] 의 회전 결과는 [Fig. 2-2] 이다.


                      
[Fig. 2-2] 에서 3 번 자석을 반시계 방향으로 1 칸 회전시키면, [Fig. 3-1] 과 같이 자석들이 회전하게 된다.


                      
[Fig. 3-1] 의 회전 결과는 [Fig. 3-2] 이다.


                      
 

모든 자석의 회전이 끝난 후 획득하는 점수는 0 + 2 + 0 + 8 = 10 이 된다.

따라서, 이 예제의 정답은 10 이다.

 

[제약사항]

1. 시간제한 : 최대 50 개 테스트 케이스를 모두 통과하는 데 C / C++ / Java 모두 3 초

2. 자석의 개수는 4 개이며, 각 자석은 8 개의 날을 가지고 있다.

3. 자석을 회전시키는 횟수 K 는 1 이상 20 이하의 정수이다. ( 1 ≤ K ≤ 20 )

4. 하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성이 다를 경우에만 반대 방향으로 1 칸 회전된다.

5. 자석을 회전시키는 방향은 시계방향이 1 로, 반시계 방향이 -1 로 주어진다.

6. 날의 자성은 N 극이 0 으로, S 극이 1 로 주어진다.

7. 각 자석의 날 자성정보는 빨간색 화살표 위치의 날부터 시계방향 순서대로 주어진다.

  예를 들어, [Fig. 1] 의 1 번 자석의 자성정보는 0 0 1 0 0 1 0 0 과 같이 주어진다.

 

 

[입력]

입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 자석을 회전시키는 횟수 K 가 주어진다.

다음 4 개의 줄에는 1 번 자석부터 4 번 자석까지 각각 8 개 날의 자성정보가 차례대로 주어진다.

그 다음 K 개의 줄에는 자석을 1 칸씩 회전시키는 회전 정보가 주어진다.

자석의 회전 정보는 회전시키려는 자석의 번호, 회전방향으로 구성되어 있다.

회전방향은 1 일 경우 시계방향이며, -1 일 경우 반시계방향이다.

 

 

[출력]

테스트 케이스 개수만큼 T 개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.

각 줄은 "#t" 로 시작하고 공백을 하나 둔 다음 정답을 출력한다. ( t 는 1 부터 시작하는 테스트 케이스의 번호이다. )

정답은 모든 자석의 회전이 끝난 후 획득한 점수의 총 합이다.*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

public class SWEA_4013 {

	static void clockwise(int[][] A, int num) {
		int temp = A[num][A[0].length - 1];
		for (int i = A[0].length - 1; i >= 1; i--) {
			A[num][i] = A[num][i - 1];
		}
		A[num][0] = temp;
	}

	static void counterclockwise(int[][] A, int num) {
		int temp = A[num][0];
		for (int i = 0; i < A[0].length - 1; i++) {
			A[num][i] = A[num][i + 1];
		}
		A[num][A[0].length - 1] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수
				int[][] A = new int[5][8];

				for (int j = 1; j <= 4; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < 8; k++) {
						A[j][k] = Integer.parseInt(arr[k]); // 0: n극, 1:S극
					}
				}
				for (int j = 0; j < K; j++) {
					String[] arr = br.readLine().split(" ");
					int num = Integer.parseInt(arr[0]);
					int dir = Integer.parseInt(arr[1]); // 1: 시계, 2: 반시계

					ArrayList<Integer> clock = new ArrayList<Integer>(); // 시계 방향으로 돌려야할 자석 번호 저장
					ArrayList<Integer> counterclock = new ArrayList<Integer>(); // 반시계 방향으로 돌려야할 자석 번호 저장

					// 자기 자신
					if (dir == 1)
						clock.add(num);
					else
						counterclock.add(num);
					// 왼쪽 탐색
					int current = dir;
					for (int k = num - 1; k >= 1; k--) {
						if (A[k][2] != A[k + 1][6]) {
							if (current == 1) {
								counterclock.add(k);
								current = 2;
							} else {
								clock.add(k);
								current = 1;
							}
						} else {
							break;
						}

					}
					// 오른쪽 탐색
					current = dir;
					for (int k = num + 1; k <= 4; k++) {
						if (A[k - 1][2] != A[k][6]) {
							if (current == 1) {
								counterclock.add(k);
								current = 2;
							} else {
								clock.add(k);
								current = 1;
							}
						} else {
							break;
						}
					}
					// clockwise
					for (int k = 0; k < clock.size(); k++) {
						clockwise(A, clock.get(k));
					}
					// counterclock
					for (int k = 0; k < counterclock.size(); k++) {
						counterclockwise(A, counterclock.get(k));
					}
				}
				// 점수 계산
				int result = 0;
				int gap = 1;
				for (int k = 1; k <= 4; k++) {
					if (A[k][0] == 1) {
						result += gap;
					}
					gap *= 2;
				}
				System.out.println("#" + (i + 1) + " " + result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
