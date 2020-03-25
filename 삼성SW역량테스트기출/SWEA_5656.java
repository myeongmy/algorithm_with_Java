//[모의 SW역량테스트] 벽돌 깨기
//브루트 포스 + 시뮬레이션 문제
/*구술을 쏘아 벽돌을 깨트리는 게임을 하려고 한다.

구슬은 N번만 쏠 수 있고, 벽돌들의 정보는 아래와 같이 W x H 배열로 주어진다.

( 0 은 빈 공간을 의미하며, 그 외의 숫자는 벽돌을 의미한다. )
 

 

게임의 규칙은 다음과 같다.

① 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.

② 벽돌은 숫자 1 ~ 9 로 표현되며,

   구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.

 

아래는 벽돌에 적힌 숫자와, 구술이 명중했을 시 제거되는 범위의 예이다.


 

③ 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.

 

예를 들어 아래와 같이 4 번 벽돌에 구술이 명중할 경우,




9번 벽돌은 4 번 벽돌에 반응하여,


 

동시에 제거된다.

 

④ 빈 공간이 있을 경우 벽돌은 밑으로 떨어지게 된다.



 

N 개의 벽돌을 떨어트려 최대한 많은 벽돌을 제거하려고 한다.

N, W, H, 그리고 벽돌들의 정보가 주어질 때,

▶ 남은 벽돌의 개수를 구하라!

 

※ sample input 1

 

N = 3, W = 10, K = 10 이고 벽돌들의 정보가 아래와 같을 때,




최대한 많은 벽돌을 깨트리는 방법은 아래와 같으며, 정답은 12 가 된다.

그림의 빨간 색 원은 구술이 명중한 위치이며, 주황색 칸은 폭발의 범위를 의미한다.

 

i) 첫 번째 구술



ii) 두 번째 구술



iii) 세 번째 구술

 

[제약 사항]

1. 1 ≤ N ≤ 4

2. 2 ≤ W ≤ 12

3. 2 ≤ H ≤ 15

 
[입력]

가장 첫 줄에는 총 테스트 케이스의 개수 T 가 주어지고,

그 다음 줄부터 T 개의 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 N, W, H 가 순서대로 공백을 사이에 두고 주어지고,

다음 H 줄에 걸쳐 벽돌들의 정보가 1 줄에 W 개씩 주어진다.



[출력]

출력은 #t 를 찍고 한 칸 띄운 다음 정답을 출력한다.

(t 는 테스트 케이스의 번호를 의미하며 1 부터 시작한다)*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class SWEA_5656 {
	static int[][] A;
	static int[] result = new int[5];
	static int min = Integer.MAX_VALUE;

	static void go(int index, int N) {
		if (index == N) {
			// 배열 복사
			int[][] B = new int[A.length][A[0].length];
			for (int i = 0; i < B.length; i++)
				B[i] = A[i].clone();

			Queue<Point> q = new LinkedList<Point>();

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				// 0이 아닌 곳 찾기
				int j;
				for (j = 0; j < A.length; j++) {
					if (B[j][result[i]] != 0)
						break;
				}
				if (j == A.length)    //예외 처리: 한 열에 벽돌이 없어서 더 이상 부술게 없는 경우
					continue;

				q.offer(new Point(j, result[i]));

				while (!q.isEmpty()) {
					Point p = q.poll();
					// 연결된 곳 찾기
					// 1. 상
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.i - k < 0 || B[p.i - k][p.j] == 0)
							continue;
						q.offer(new Point(p.i - k, p.j));
					}
					// 2. 하
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.i + k >= B.length || B[p.i + k][p.j] == 0)
							continue;
						q.offer(new Point(p.i + k, p.j));
					}
					// 3.좌
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.j - k < 0 || B[p.i][p.j - k] == 0)
							continue;
						q.offer(new Point(p.i, p.j - k));
					}
					// 4.우
					for (int k = 1; k < B[p.i][p.j]; k++) {
						if (p.j + k >= B[0].length || B[p.i][p.j + k] == 0)
							continue;
						q.offer(new Point(p.i, p.j + k));
					}

					// 자신 제거
					B[p.i][p.j] = 0;
				}
				// 재정렬
				for (int m = A.length - 1; m >= 0; m--) {
					for (int n = 0; n < A[0].length; n++) {
						if (B[m][n] == 0)
							continue;
						int nextX = m + 1;

						while (true) {
							if (nextX >= A.length || B[nextX][n] != 0)
								break;
							nextX++;
						}
						if (nextX - 1 == m)
							continue;
						B[nextX - 1][n] = B[m][n];
						B[m][n] = 0;

					}
				}

			}
			for (int m = 0; m < B.length; m++) {
				for (int n = 0; n < B[0].length; n++) {
					if (B[m][n] != 0)
						cnt++;
				}
			}
			if (min > cnt)
				min = cnt;
			return;
		}
		for (int i = 0; i < A[0].length; i++) {
			result[index] = i;
			go(index + 1, N);
			result[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");

				int N = Integer.parseInt(arr[0]);
				int W = Integer.parseInt(arr[1]);
				int H = Integer.parseInt(arr[2]);

				A = new int[H][W];
				for (int j = 0; j < H; j++) {
					String[] arr1 = br.readLine().split(" ");
					for (int k = 0; k < W; k++) {
						A[j][k] = Integer.parseInt(arr1[k]);
					}
				}
				go(0, N);
				System.out.println("#" + (i + 1) + " " + min);
				min = Integer.MAX_VALUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
