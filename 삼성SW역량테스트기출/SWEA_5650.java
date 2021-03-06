//[모의 SW역량테스트] 핀볼 게임
//브루트 포스 + 시뮬레이션 문제
/*민기는 핀볼 게임을 개발 중에 있다. 핀볼게임은 N x N 크기의 핀볼 게임판에 정사각형 블록과 4가지 형태의 삼각형 블록들이 섞여 있고, 여기에 추가적으로 웜홀과 블랙홀이 존재한다. 핀볼게임의 게임판의 하나의 예는 아래 [그림1]과 같다.

                
                                                       [그림1]

각 블록들은 일정한 번호로 주어지는데, 블록들의 번호와 모양은 아래 [그림2]와 같다.


            
                                                       [그림2]


웜홀과 블랙홀은 각각 아래 [그림3]의 번호로 주어진다.

              
                        [그림3]

 

게임판 위에서는 작은 핀볼 하나가 상, 하, 좌, 우 중 한 방향으로 움직인다.
 

            
 

핀볼은 블록이나 웜홀 또는 블랙홀을 만나지 않는 한 현재 방향을 유지하면서 계속 직진하며,

블록의 수평면이나 수직면을 만날 경우 방향을 바꿔 반대 방향으로 돌아오고, 경사면을 만날 경우에는 직각으로 진행 방향이 꺾이게 된다.

                

 

또한 핀볼은 벽을 만날 경우에도 반대 방향으로 돌아온다. 아래의 그림과 같이 핀볼이 왼쪽으로 움직이다 벽을 만나면 반대 방향으로 다시 돌아오게 된다.
 

             
 

핀볼이 웜홀에 빠지면 동일한 숫자를 가진 다른 반대편 웜홀로 빠져 나오게 되며 진행방향은 그대로 유지된다. (웜홀은 반드시 쌍으로 주어지며, 입력에서는 6 이상 10 이하의 숫자로 표시된다.)
 


 

핀볼이 블랙홀을 만나면, 핀볼이 사라지게 되어 게임은 끝나게 된다.
 


 

게임은 핀볼이 출발 위치로 돌아오거나, 블랙홀에 빠질 때 끝나게 되며, 점수는 벽이나 블록에 부딪힌 횟수가 된다. (웜홀을 통과하는 것은 점수에 포함되지 않는다.)

블랙홀에 빠져서 게임이 끝나더라도, 벽이나 블록에 부딪혀 획득한 점수는 남아있게 된다.

게임판 위에서 출발 위치와 진행 방향을 임의로 선정가능 할 때,

▶ 게임에서 얻을 수 있는 점수의 최댓값을 구하여라!

단, 블록, 웜홀 또는 블랙홀이 있는 위치에서는 출발할 수 없다.

 

[제약 사항]

게임판의 크기는 정사각형으로 주어지며, 한 변의 길이 N 은 5 이상 100 이하이다. (5 ≤ N ≤ 100)
웜홀은 게임판 내에서 숫자 6 ~ 10으로 주어진다.
블랙홀은 게임판 내에서 숫자 -1 로 주어진다.
게임판에서 웜홀 또는 블랙홀이 존재하지 않는 경우도 있다.
웜홀이 있는 경우 반드시 쌍(pair)으로 존재하며, 웜홀이 주어지는 경우 최대 5쌍 존재한다.
웜홀을 통과한 핀볼은 동일한 숫자를 가진 반대편 웜홀로 이동하게 되며, 이때 진행방향은 그대로 유지된다.
블랙홀은 최대 5개가 주어진다.
 

[입력]

입력의 가장 첫 줄에는 총 테스트 케이스의 개수 T가 주어지며, 그 다음 줄부터 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫째 줄에는 N이 주어지고, 다음 N줄에 걸쳐서 핀볼 게임판의 모양이 주어진다.

게임판의 모양은 -1 이상 10 이하의 정수로 주어지며, 각 숫자는 한 칸씩 띄어져서 주어진다.
숫자에 따른 의미는 다음과 같다

 

-1

0

1 ~ 5

6 ~ 10

블랙홀

빈공간

블록

웜홀

 
[출력]

테스트 케이스 t에 대한 결과는 "#t"를 찍고, 한 칸 띄고 정답을 출력한다.

(단, t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

package 삼성SW역량테스트기출;

import java.io.*;
import java.util.*;

public class SWEA_5650 {
	static int[] dx = { 0, 0, -1, 1 }; // 진행방향(0: 왼쪽, 1: 오른쪽, 2: 위쪽, 3: 아래쪽)
	static int[] dy = { -1, 1, 0, 0 };

	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int hashCode() {
			return (Integer.toString(i) + Integer.toString(j)).hashCode();
		}

		public boolean equals(Object o) {
			Point p = (Point) o;
			return this.i == p.i && this.j == p.j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] block = new int[6][4];
		block[1][1] = 0;
		block[1][2] = 3;
		block[1][0] = 2;
		block[1][3] = 1;

		block[2][0] = 3;
		block[2][1] = 0;
		block[2][2] = 1;
		block[2][3] = 2;

		block[3][0] = 1;
		block[3][1] = 3;
		block[3][2] = 0;
		block[3][3] = 2;

		block[4][0] = 1;
		block[4][1] = 2;
		block[4][2] = 3;
		block[4][3] = 0;

		block[5][0] = 1;
		block[5][1] = 0;
		block[5][2] = 3;
		block[5][3] = 2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				int[][] A = new int[N][N];
				ArrayList<Point> zero = new ArrayList<Point>(); // 핀볼이 올 수 있는 위치 저장
				ArrayList<Point>[] hole = (ArrayList<Point>[]) new ArrayList[5]; // 블랙홀 위치(인덱스: 블랙홀 번호 -6)
				for (int j = 0; j < hole.length; j++)
					hole[j] = new ArrayList<Point>();

				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr[k]);
						if (A[j][k] == 0)
							zero.add(new Point(j, k));
						if (A[j][k] >= 6)
							hole[A[j][k] - 6].add(new Point(j, k));
					}
				}

				int max = Integer.MIN_VALUE;

				for (int j = 0; j < zero.size(); j++) {
					Point p = zero.get(j); // 핀볼의 위치

					for (int k = 0; k < 4; k++) {
						int dir = k;
						int score = 0;
						int curi = p.i;
						int curj = p.j;
						int time = 0;

						Label: while (true) {
							if (time != 0 && (curi == p.i && curj == p.j))
								break;
							int nexti = curi;
							int nextj = curj;

							while (true) {
								nexti += dx[dir];
								nextj += dy[dir];

								if (time != 0 && nexti == p.i && nextj == p.j)
									break Label;
								time++;
								if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) { // 벽을 만난 경우
									score += 1;
									nexti -= dx[dir];
									nextj -= dy[dir];
									curi = nexti;
									curj = nextj;
									
									if (dir == 0) {
										dir = 1;
									} else if (dir == 1) {
										dir = 0;
									} else if (dir == 2) {
										dir = 3;
									} else if (dir == 3) {
										dir = 2;
									}
									if (A[curi][curj] >= 1 && A[curi][curj] <= 5) {
										dir = block[A[curi][curj]][dir];
										score += 1;       // 47/50개 맞았던 이유 (여기도 블록에 부딪힌 경우인데 score ++가 되지 않아서!!)
										break;
									}
									if (A[curi][curj] >= 6 && A[curi][curj] <= 10) {
										if (hole[A[nexti][nextj] - 6].get(0).i == nexti
												&& hole[A[nexti][nextj] - 6].get(0).j == nextj) {
											curi = hole[A[nexti][nextj] - 6].get(1).i;
											curj = hole[A[nexti][nextj] - 6].get(1).j;
										} else if (hole[A[nexti][nextj] - 6].get(1).i == nexti
												&& hole[A[nexti][nextj] - 6].get(1).j == nextj) {
											curi = hole[A[nexti][nextj] - 6].get(0).i;
											curj = hole[A[nexti][nextj] - 6].get(0).j;
										}
										break;
									}
									break;
								} else if (A[nexti][nextj] >= 1 && A[nexti][nextj] <= 5) { // 블록을 만난 경우
									score += 1;
									curi = nexti;
									curj = nextj;
									dir = block[A[curi][curj]][dir];
									break;
								} else if (A[nexti][nextj] == -1) { // 블랙홀을 만난 경우
									break Label;
								} else if (A[nexti][nextj] >= 6 && A[nexti][nextj] <= 10) { // 웜홀 만난 경우
									if (hole[A[nexti][nextj] - 6].get(0).i == nexti
											&& hole[A[nexti][nextj] - 6].get(0).j == nextj) {
										curi = hole[A[nexti][nextj] - 6].get(1).i;
										curj = hole[A[nexti][nextj] - 6].get(1).j;
									} else if (hole[A[nexti][nextj] - 6].get(1).i == nexti
											&& hole[A[nexti][nextj] - 6].get(1).j == nextj) {
										curi = hole[A[nexti][nextj] - 6].get(0).i;
										curj = hole[A[nexti][nextj] - 6].get(0).j;
									}
									break;
								}

							}

						}
						if (max < score) {
							max = score;
						}
					}
				}
				System.out.println("#" + (i + 1) + " " + max);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
