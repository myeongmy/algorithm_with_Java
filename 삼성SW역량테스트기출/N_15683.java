//백준 15683번(감시)
//완전탐색과 시뮬레이션 문제
/*문제
스타트링크의 사무실은 1×1크기의 정사각형으로 나누어져 있는 N×M 크기의 직사각형으로 나타낼 수 있다. 사무실에는 총 K개의 CCTV가 설치되어져 있는데, CCTV는 5가지 종류가 있다. 각 CCTV가 감시할 수 있는 방법은 다음과 같다.

				
1번	2번	3번	4번	5번
1번 CCTV는 한 쪽 방향만 감시할 수 있다. 2번과 3번은 두 방향을 감시할 수 있는데, 2번은 감시하는 방향이 서로 반대방향이어야 하고, 3번은 직각 방향이어야 한다. 4번은 세 방향, 5번은 네 방향을 감시할 수 있다.

CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다. 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.

CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다. 위의 예시에서 1번의 방향에 따라 감시할 수 있는 영역을 '#'로 나타내면 아래와 같다.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 # 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
# # 1 0 6 0
0 0 0 0 0 0
0 0 # 0 0 0
0 0 # 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 # 0 0 0
→	←	↑	↓
CCTV는 벽을 통과할 수 없기 때문에, 1번이 → 방향을 감시하고 있을 때는 6의 오른쪽에 있는 벽을 감시할 수 없다.

0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
위의 예시에서 감시할 수 있는 방향을 알아보면 아래와 같다.

0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
왼쪽 상단 2: ↔, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↔, 오른쪽 하단 2: ↕	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↔	왼쪽 상단 2: ↕, 오른쪽 하단 2: ↕
CCTV는 CCTV를 통과할 수 있다. 아래 예시를 보자.

0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
위와 같은 경우에 2의 방향이 ↕ 3의 방향이 ←와 ↓인 경우 감시받는 영역은 다음과 같다.

# # 2 # 3
0 6 # 0 #
0 0 6 6 #
0 0 0 0 #
사무실의 크기와 상태, 그리고 CCTV의 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다. 

CCTV의 최대 개수는 8개를 넘지 않는다.

출력
첫째 줄에 사각 지대의 최소 크기를 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class CCTV {
	int num; // 씨씨티비 번호
	int i; // 씨씨티비의 위치
	int j;

	CCTV(int num, int i, int j) {
		this.num = num;
		this.i = i;
		this.j = j;
	}
}

public class N_15683 {
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int min = 100;

	static void go(int index, int[][] A, ArrayList<CCTV> list) {
		if (index == list.size()) {
			int[][] test = new int[A.length][A[0].length];
			for (int i = 0; i < test.length; i++)
				test[i] = A[i].clone();
			for (int i = 0; i < result.size(); i++) {
				if (list.get(i).num == 1) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 2) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 3) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 4) {
					if (result.get(i) == 0) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					} else if (result.get(i) == 1) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
					}else if(result.get(i) == 2) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (y + 1 < A[0].length && test[x][y + 1] != 6) {
							y += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
					}else if(result.get(i) == 3) {
						int x = list.get(i).i;
						int y = list.get(i).j;
						while (y - 1 >= 0 && test[x][y - 1] != 6) {
							y -= 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x + 1 < A.length && test[x + 1][y] != 6) {
							x += 1;
							test[x][y] = 1;
						}
						x = list.get(i).i;
						y = list.get(i).j;
						while (x - 1 >= 0 && test[x - 1][y] != 6) {
							x -= 1;
							test[x][y] = 1;
						}
					}
				} else if (list.get(i).num == 5) {
					int x = list.get(i).i;
					int y = list.get(i).j;
					while (y - 1 >= 0 && test[x][y - 1] != 6) {
						y -= 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (x + 1 < A.length && test[x + 1][y] != 6) {
						x += 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (y + 1 < A[0].length && test[x][y + 1] != 6) {
						y += 1;
						test[x][y] = 1;
					}
					x = list.get(i).i;
					y = list.get(i).j;
					while (x - 1 >= 0 && test[x - 1][y] != 6) {
						x -= 1;
						test[x][y] = 1;
					}
				}
			}
			int numZero = 0;
			for (int i = 0; i < test.length; i++) {
				for (int j = 0; j < test[0].length; j++) {
					if (test[i][j] == 0)
						numZero++;
				}
			}
			if (min > numZero)
				min = numZero;

			return;
		}
		if (list.get(index).num == 1) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 2) {
			for (int i = 0; i <= 1; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 3) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 4) {
			for (int i = 0; i <= 3; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		} else if (list.get(index).num == 5) {
			for (int i = 0; i <= 0; i++) {
				result.add(i);
				go(index + 1, A, list);
				result.remove(result.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];
		ArrayList<CCTV> list = new ArrayList<CCTV>(); // 씨씨티비의 번호와 위치를 저장하는 리스트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] >= 1 && A[i][j] <= 5)
					list.add(new CCTV(A[i][j], i, j));
			}
		}

		go(0, A, list);

		System.out.println(min);
	}

}
