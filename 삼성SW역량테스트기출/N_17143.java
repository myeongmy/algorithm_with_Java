//백준 17143번 (낚시왕)
//시뮬레이션 문제
//시간 초과 -> 나머지 연산을 이용한 최적화 필요
/*문제
낚시왕이 상어 낚시를 하는 곳은 크기가 R×C인 격자판으로 나타낼 수 있다. 격자판의 각 칸은 (r, c)로 나타낼 수 있다. r은 행, c는 열이고, (R, C)는 아래 그림에서 가장 오른쪽 아래에 있는 칸이다. 칸에는 상어가 최대 한 마리 들어있을 수 있다. 상어는 크기와 속도를 가지고 있다.



낚시왕은 처음에 1번 열의 한 칸 왼쪽에 있다. 다음은 1초 동안 일어나는 일이며, 아래 적힌 순서대로 일어난다. 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.

낚시왕이 오른쪽으로 한 칸 이동한다.
낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
상어가 이동한다.
상어는 입력으로 주어진 속도로 이동하고, 속도의 단위는 칸/초이다. 상어가 이동하려고 하는 칸이 격자판의 경계인 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동한다.

왼쪽 그림의 상태에서 1초가 지나면 오른쪽 상태가 된다. 상어가 보고 있는 방향이 속도의 방향, 왼쪽 아래에 적힌 정수는 속력이다. 왼쪽 위에 상어를 구분하기 위해 문자를 적었다.



상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다. 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.

낚시왕이 상어 낚시를 하는 격자판의 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합을 구해보자.

입력
첫째 줄에 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)

둘째 줄부터 M개의 줄에 상어의 정보가 주어진다. 상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

두 상어가 같은 크기를 갖는 경우는 없고, 하나의 칸에 둘 이상의 상어가 있는 경우는 없다.

출력
낚시왕이 잡은 상어 크기의 합을 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

class Shark2 {
	int s; // 속력
	int d; // 방향 (1:위, 2:아래, 3:오른쪽, 4:왼쪽)
	int z; // 크기

	Shark2(int s, int d, int z) {
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_17143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] arr = br.readLine().split(" ");
			int R = Integer.parseInt(arr[0]);
			int C = Integer.parseInt(arr[1]);
			int M = Integer.parseInt(arr[2]);
			ArrayList<Shark2>[][] list = (ArrayList<Shark2>[][]) new ArrayList[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					list[i][j] = new ArrayList<Shark2>();
				}
			}
			for (int i = 0; i < M; i++) {
				String[] arr1 = br.readLine().split(" ");
				int r = Integer.parseInt(arr1[0]);
				int c = Integer.parseInt(arr1[1]);
				int sp = Integer.parseInt(arr1[2]);
				int d = Integer.parseInt(arr1[3]);
				int z = Integer.parseInt(arr1[4]);
				list[r - 1][c - 1].add(new Shark2(sp, d, z));
			}
			int man = -1; // 낚시왕의 현재 위치
			int sum = 0;
			while (true) {
				man++;
				if (man == C)
					break;
				int num = 0;
				while (num < R && list[num][man].size() == 0) {
					num++;
				}
				if (num < R) {
					sum += list[num][man].get(0).z;
					list[num][man].remove(0);
				}
				// 큐에 상어 넣기
				Queue<Point> q = new LinkedList<Point>();
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (list[i][j].size() != 0)
							q.offer(new Point(i, j));
					}
				}
				// 상어들 이동시킨다.
				while (!q.isEmpty()) {
					Point p = q.poll();
					int i = p.i;
					int j = p.j;
					if (list[i][j].get(0).d == 1) {
						int next_x = i;
						int next_y = j;
						int remain = list[i][j].get(0).s;
						while (remain != 0) {
							remain--;
							if (next_x - 1 >= 0 && list[i][j].get(0).d == 1) {
								next_x--;
							} else if (next_x - 1 < 0 && list[i][j].get(0).d == 1) {
								list[i][j].get(0).d = 2;
							}
							if (next_x + 1 < R && list[i][j].get(0).d == 2) {
								next_x++;
							} else if (next_x + 1 >= R && list[i][j].get(0).d == 2) {
								list[i][j].get(0).d = 1;
								remain++;
							}
						}
						list[next_x][next_y].add(list[i][j].remove(0));
					} else if (list[i][j].get(0).d == 2) {
						int next_x = i;
						int next_y = j;
						int remain = list[i][j].get(0).s;
						while (remain != 0) {
							remain--;
							if (next_x + 1 < R && list[i][j].get(0).d == 2) {
								next_x++;
							} else if (next_x + 1 >= R && list[i][j].get(0).d == 2) {
								list[i][j].get(0).d = 1;
							}
							if (next_x - 1 >= 0 && list[i][j].get(0).d == 1) {
								next_x--;
							} else if (next_x - 1 < 0 && list[i][j].get(0).d == 1) {
								list[i][j].get(0).d = 2;
								remain++;
							}

						}
						list[next_x][next_y].add(list[i][j].remove(0));

					} else if (list[i][j].get(0).d == 3) {
						int next_x = i;
						int next_y = j;
						int remain = list[i][j].get(0).s;
						while (remain != 0) {
							remain--;
							if (next_y + 1 < C && list[i][j].get(0).d == 3) {
								next_y++;
							} else if (next_y + 1 >= C && list[i][j].get(0).d == 3) {
								list[i][j].get(0).d = 4;
							}
							if (next_y - 1 >= 0 && list[i][j].get(0).d == 4) {
								next_y--;
							} else if (next_y - 1 < 0 && list[i][j].get(0).d == 4) {
								list[i][j].get(0).d = 3;
								remain++;
							}

						}
						list[next_x][next_y].add(list[i][j].remove(0));
					} else {
						int next_x = i;
						int next_y = j;
						int remain = list[i][j].get(0).s;
						while (remain != 0) {
							remain--;
							if (next_y - 1 >= 0 && list[i][j].get(0).d == 4) {
								next_y--;
							} else if (next_y - 1 < 0 && list[i][j].get(0).d == 4) {
								list[i][j].get(0).d = 3;
							}
							if (next_y + 1 < C && list[i][j].get(0).d == 3) {
								next_y++;
							} else if (next_y + 1 >= C && list[i][j].get(0).d == 3) {
								list[i][j].get(0).d = 4;
								remain++;
							}

						}
						list[next_x][next_y].add(list[i][j].remove(0));
					}

				}

				// 한 칸에 상어가 여러 마리 있는지 확인
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (list[i][j].size() > 1) {
							int max = 0;
							int max_dir = 0;
							int max_s = 0;
							for (int k = 0; k < list[i][j].size(); k++) {
								if (max < list[i][j].get(k).z) {
									max = list[i][j].get(k).z;
									max_dir = list[i][j].get(k).d;
									max_s = list[i][j].get(k).s;
								}
							}
							list[i][j].clear();
							list[i][j].add(new Shark2(max_s, max_dir, max));
						}
					}
				}

			}
			bw.write(Integer.toString(sum));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
