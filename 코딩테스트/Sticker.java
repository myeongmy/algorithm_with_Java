//2020-03-21 스티커 불이기 삼성 코테 백준 모의고사
//시뮬레이션 + 브루트 포스 문제
/*문제
혜윤이는 최근에 다양한 대회를 참여하면서 노트북에 붙일 수 있는 스티커들을 많이 받았다. 스티커는 아래와 같이 사각 모눈종이 위에 인쇄되어 있으며, 스티커의 각 칸은 상하좌우로 모두 연결되어 있다. 또한 모눈종이의 크기는 스티커의 크기에 꼭 맞아서, 상하좌우에 스티커가 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.

아래는 올바른 모눈종이의 예시이다. 주황색 칸은 스티커가 붙은 칸을, 하얀색 칸은 스티커가 붙지 않은 칸을 나타낸다.



반면 아래는 올바르지 않은 모눈종이의 예시이다. 첫 번째는 윗쪽에 불필요한 행이 있고, 두 번째는 왼쪽에 불필요한 열이 있다. 그리고 세 번째는 스티커의 각 칸이 상하좌우로 모두 연결되어 있지 않다.



혜윤이는 자신의 노트북에 이 스티커들을 붙이기로 했다. 혜윤이의 노트북은 마침 직사각형 모양이고, 스티커가 인쇄된 모눈종이와 같은 간격으로 격자가 그려져 있다. 혜윤이는 스티커들을 먼저 받았던 것부터 차례대로 격자에 맞춰서 붙이려고 한다.

혜윤이가 스티커를 붙이는 방법은 다음과 같다.

스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다. 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.
아래의 예시를 통해 스티커를 붙이는 과정을 이해해보자. 노트북은 세로 5칸, 가로 4칸 크기이고, 혜윤이가 가지고 있는 스티커들은 아래와 같다. 왼쪽에서 오른쪽 순으로 스티커를 붙일 것이다.



첫 번째 스티커는 회전 없이 온전히 붙일 수 있는 공간이 아래와 같이 6곳이 있다.



이 중에서 가장 위쪽의 위치, 가능한 가장 위쪽의 위치가 여러 개이면 그 중에서 가장 왼쪽의 위치는 첫 번째이다. 스티커를 붙인 후 노트북의 모양은 아래와 같다.



두 번째 스티커는 회전 없이 온전히 붙일 수 있는 공간이 없다. 그러나 시계 방향으로 90도 회전한 후에는 붙일 수 있는 공간이 1개 생긴다. 해당 공간에 스티커를 붙인 후 노트북의 모양은 아래와 같다.



세 번째 스티커는 스티커를 시계방향으로 0, 90, 180, 270도 회전시킨 모양에 대해 전부 확인을 해도 스티커를 붙일 수 있는 공간이 없다. 그러므로 해당 스티커를 붙이지 않고 버린다.

네 번째 스티커는 스티커를 시계방향으로 0, 90, 180도 회전 시킨 모양에 대해 온전히 붙일 수 있는 공간이 없다. 그러나 시계 방향으로 270도 회전한 후에는 공간이 1개 생긴다. 스티커를 붙인 후 노트북의 모양은 아래와 같다. 최종적으로 노트북의 18칸이 스티커로 채워졌다.



혜윤이는 스티커를 다 붙인 후의 노트북의 모습이 궁금해졌다. 노트북의 크기와 스티커들이 주어졌을 때 스티커들을 차례대로 붙이고 난 후 노트북에서 몇 개의 칸이 채워졌는지 구해보자.

입력
첫째 줄에 노트북의 세로와 가로 길이를 나타내는 N(1 ≤ N ≤ 40)과 M(1 ≤ M ≤ 40), 그리고 스티커의 개수 K(1 ≤ K ≤ 100)이 한 칸의 빈칸을 사이에 두고 주어진다.

그 다음 줄부터는 K개의 스티커들에 대한 정보가 주어진다. 각 스티커는 아래와 같은 형식으로 주어진다.

먼저 i번째 스티커가 인쇄된 모눈종이의 행의 개수와 열의 개수를 나타내는 Ri(1 ≤ Ri ≤ 10)와 Ci(1 ≤ Ci ≤ 10)가 한 칸의 빈칸을 사이에 두고 주어진다.

다음 Ri개의 줄에는 각 줄마다 모눈종이의 각 행을 나타내는 Ci개의 정수가 한 개의 빈칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0, 1이다. 0은 스티커가 붙지 않은 칸을, 1은 스티커가 붙은 칸을 의미한다.

문제에서 설명한 것과 같이 스티커는 모두 올바른 모눈종이에 인쇄되어 있다. 구체적으로 스티커의 각 칸은 상하좌우로 모두 연결되어 있고, 모눈종이의 크기는 스티커의 크기에 꼭 맞아서 상하좌우에 스티커에 전혀 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.

출력
첫째 줄에 주어진 스티커들을 차례대로 붙였을 때 노트북에서 스티커가 붙은 칸의 수를 출력한다.*/

package 코딩테스트;

import java.util.*;
import java.io.*;

public class Sticker {
	static int[][][] sticker;
	static int[][][] sticker90;
	static int[][][] sticker180;
	static int[][][] sticker270;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int K = Integer.parseInt(arr[2]);

			sticker = new int[K][][];
			for (int i = 0; i < K; i++) {
				String[] arr1 = br.readLine().split(" ");
				int R = Integer.parseInt(arr1[0]);
				int C = Integer.parseInt(arr1[1]);
				sticker[i] = new int[R][C];
				for (int j = 0; j < R; j++) {
					String[] arr2 = br.readLine().split(" ");

					for (int k = 0; k < C; k++) {
						sticker[i][j][k] = Integer.parseInt(arr2[k]);
					}
				}
			}

			// 90도 회전
			sticker90 = new int[K][][];
			for (int i = 0; i < K; i++) {
				sticker90[i] = new int[sticker[i][0].length][sticker[i].length];
				for (int j = 0; j < sticker[i][0].length; j++) {
					for (int k = sticker[i].length - 1; k >= 0; k--) {
						sticker90[i][j][(sticker[i].length - 1) - k] = sticker[i][k][j];
					}
				}
			}

			// 180도 회전
			sticker180 = new int[K][][];
			for (int i = 0; i < K; i++) {
				sticker180[i] = new int[sticker90[i][0].length][sticker90[i].length];
				for (int j = 0; j < sticker90[i][0].length; j++) {
					for (int k = sticker90[i].length - 1; k >= 0; k--) {
						sticker180[i][j][(sticker90[i].length - 1) - k] = sticker90[i][k][j];
					}
				}
			}

			// 270도 회전
			sticker270 = new int[K][][];
			for (int i = 0; i < K; i++) {
				sticker270[i] = new int[sticker180[i][0].length][sticker180[i].length];
				for (int j = 0; j < sticker180[i][0].length; j++) {
					for (int k = sticker180[i].length - 1; k >= 0; k--) {
						sticker270[i][j][(sticker180[i].length - 1) - k] = sticker180[i][k][j];
					}
				}
			}

			// 스티커 붙이기
			int[][] A = new int[N][M];
			Label1: for (int i = 0; i < K; i++) {
				int starti = -1;
				int startj = -1;

				Label: for (int j = 0; j <= N - sticker[i].length; j++) {
					for (int k = 0; k <= M - sticker[i][0].length; k++) { // 시작점이 올 수 있는 위치
						int cnt = 0;
						int count = 0;
						for (int m = 0; m < sticker[i].length; m++) {
							for (int n = 0; n < sticker[i][0].length; n++) {
								if (sticker[i][m][n] == 1)
									count++;
								if (A[j + m][k + n] == 0 && sticker[i][m][n] == 1) {
									cnt++;
								}
							}
						}
						if (count == cnt) {
							starti = j;
							startj = k;
							break Label;
						}

					}
				}

				if (starti != -1 && startj != -1) {
					for (int m = 0; m < sticker[i].length; m++) {
						for (int n = 0; n < sticker[i][0].length; n++) {
							if (sticker[i][m][n] == 1) {
								A[starti + m][startj + n] = 1;
							}
						}
					}

					continue Label1;
				}

				// 90도 돌린 것 붙여보기
				starti = -1;
				startj = -1;

				Label: for (int j = 0; j <= N - sticker90[i].length; j++) {
					for (int k = 0; k <= M - sticker90[i][0].length; k++) { // 시작점이 올 수 있는 위치
						int cnt = 0;
						int count = 0;
						for (int m = 0; m < sticker90[i].length; m++) {
							for (int n = 0; n < sticker90[i][0].length; n++) {
								if (sticker90[i][m][n] == 1)
									count++;
								if (A[j + m][k + n] == 0 && sticker90[i][m][n] == 1) {
									cnt++;
								}
							}
						}
						if (count == cnt) {
							starti = j;
							startj = k;
							break Label;
						}

					}
				}

				if (starti != -1 && startj != -1) {
					for (int m = 0; m < sticker90[i].length; m++) {
						for (int n = 0; n < sticker90[i][0].length; n++) {
							if (sticker90[i][m][n] == 1) {
								A[starti + m][startj + n] = 1;
							}
						}
					}

					continue Label1;
				}

				// 180도 붙여보기
				starti = -1;
				startj = -1;

				Label: for (int j = 0; j <= N - sticker180[i].length; j++) {
					for (int k = 0; k <= M - sticker180[i][0].length; k++) { // 시작점이 올 수 있는 위치
						int cnt = 0;
						int count = 0;
						for (int m = 0; m < sticker180[i].length; m++) {
							for (int n = 0; n < sticker180[i][0].length; n++) {
								if (sticker180[i][m][n] == 1)
									count++;
								if (A[j + m][k + n] == 0 && sticker180[i][m][n] == 1) {
									cnt++;
								}
							}
						}
						if (count == cnt) {
							starti = j;
							startj = k;
							break Label;
						}

					}
				}

				if (starti != -1 && startj != -1) {
					for (int m = 0; m < sticker180[i].length; m++) {
						for (int n = 0; n < sticker180[i][0].length; n++) {
							if (sticker180[i][m][n] == 1) {
								A[starti + m][startj + n] = 1;
							}
						}
					}
					continue Label1;
				}

				// 270
				starti = -1;
				startj = -1;

				Label: for (int j = 0; j <= N - sticker270[i].length; j++) {
					for (int k = 0; k <= M - sticker270[i][0].length; k++) { // 시작점이 올 수 있는 위치
						int cnt = 0;
						int count = 0;
						for (int m = 0; m < sticker270[i].length; m++) {
							for (int n = 0; n < sticker270[i][0].length; n++) {
								if (sticker270[i][m][n] == 1)
									count++;
								if (A[j + m][k + n] == 0 && sticker270[i][m][n] == 1) {
									cnt++;
								}
							}
						}
						if (count == cnt) {
							starti = j;
							startj = k;
							break Label;
						}

					}
				}

				if (starti != -1 && startj != -1) {
					for (int m = 0; m < sticker270[i].length; m++) {
						for (int n = 0; n < sticker270[i][0].length; n++) {
							if (sticker270[i][m][n] == 1) {
								A[starti + m][startj + n] = 1;

							}
						}
					}

					continue Label1;
				}

			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (A[i][j] == 1)
						result++;
				}
			}
			System.out.println(result);
		} catch (IOException e) {

		}
	}

}
