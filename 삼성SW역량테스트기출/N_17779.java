//백준 17779번 (게리멘더링2)
//브루트 포스 + 시뮬레이션 문제
/*문제
재현시의 시장 구재현은 지난 몇 년간 게리맨더링을 통해서 자신의 당에게 유리하게 선거구를 획정했다. 견제할 권력이 없어진 구재현은 권력을 매우 부당하게 행사했고, 심지어는 시의 이름도 재현시로 변경했다. 이번 선거에서는 최대한 공평하게 선거구를 획정하려고 한다.

재현시는 크기가 N×N인 격자로 나타낼 수 있다. 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다. 구역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다. 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다. 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다. 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.

선거구를 나누는 방법은 다음과 같다.

기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
다음 칸은 경계선이다.
(x, y), (x+1, y-1), ..., (x+d1, y-d1)
(x, y), (x+1, y+1), ..., (x+d2, y+d2)
(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
경계선과 경계선의 안에 포함되어있는 5번 선거구이다.
5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다.
1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
아래는 크기가 7×7인 재현시를 다섯 개의 선거구로 나눈 방법의 예시이다.

		
x = 2, y = 4, d1 = 2, d2 = 2	x = 2, y = 5, d1 = 3, d2 = 2	x = 4, y = 3, d1 = 1, d2 = 1
구역 (r, c)의 인구는 A[r][c]이고, 선거구의 인구는 선거구에 포함된 구역의 인구를 모두 합한 값이다. 선거구를 나누는 방법 중에서, 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값을 구해보자.

입력
첫째 줄에 재현시의 크기 N이 주어진다.

둘째 줄부터 N개의 줄에 N개의 정수가 주어진다. r행 c열의 정수는 A[r][c]를 의미한다.

출력
첫째 줄에 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

public class N_17779 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int totalMin = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 >= N || y - d1 < 0)
							continue;
						if (x + d2 >= N || y + d2 >= N)
							continue;
						if (x + d1 + d2 >= N || y - d1 + d2 < 0 || y - d1 + d2 >= N)
							continue;
						int[][] B = new int[N][N];
						// 1번
						for (int k = 0; k <= d1; k++) {
							B[x + k][y - k] = 5;
						}
						// 2번
						for (int k = 0; k <= d2; k++) {
							B[x + k][y + k] = 5;
						}
						// 3번
						for (int k = 0; k <= d2; k++) {
							B[x + d1 + k][y - d1 + k] = 5;
						}
						// 4번
						for (int k = 0; k <= d1; k++) {
							B[x + d2 + k][y + d2 - k] = 5;
						}
						// 5구역 채우기
						for (int k = 1; k <= d1; k++) {
							for (int j = 1;; j++) {
								if (B[x + k][y - k + j] == 5)
									break;
								B[x + k][y - k + j] = 5;
							}
						}
						for (int k = 1; k < d2; k++) {
							for (int j = 1;; j++) {
								if (B[x + d1 + k][y - d1 + k + j] == 5)
									break;
								B[x + d1 + k][y - d1 + k + j] = 5;
							}
						}
						// 1구역 채우기
						for (int k = 0; k < x + d1; k++) {
							for (int j = 0; j <= y; j++) {
								if (B[k][j] == 5)
									break;
								B[k][j] = 1;
							}
						}
						// 3구역 채우기
						for (int k = x + d1; k < N; k++) {
							for (int j = 0; j < y - d1 + d2; j++) {
								if (B[k][j] == 5)
									break;
								B[k][j] = 3;
							}
						}
						// 2구역 채우기
						for (int k = 0; k <= x + d2; k++) {
							for (int j = y + 1; j < N; j++) {
								if (B[k][j] == 5)
									continue;
								B[k][j] = 2;
							}
						}
						// 4구역 채우기
						for (int k = x + d2 + 1; k < N; k++) {
							for (int j = y - d1 + d2; j < N; j++) {
								if (B[k][j] == 5)
									continue;
								B[k][j] = 4;
							}
						}
						int[] popul = new int[6]; // index번 선거구의 인구 수 저장
						for (int i = 0; i < N; i++) {
							for (int j = 0; j < N; j++) {
								popul[B[i][j]] += A[i][j];
							}
						}
						int min = 100000;
						int max = 0;
						for (int i = 1; i < popul.length; i++) {
							if (max < popul[i])
								max = popul[i];
							if (min > popul[i])
								min = popul[i];
						}
						if (totalMin > Math.abs(max - min))
							totalMin = Math.abs(max - min);

					}
				}
			}
		}
		System.out.println(totalMin);
	}

}
