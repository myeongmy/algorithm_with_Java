//백준 17143번 (낚시왕)
//시뮬레이션 문제
//나머지 연산을 이용한 풀이


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

public class N_17143_v2 {

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
						remain = remain % (R*2-2);
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
						remain = remain % (R*2-2);
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
						remain = remain % (C*2-2);
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
						remain = remain % (C*2-2);
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
