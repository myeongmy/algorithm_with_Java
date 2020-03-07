//백준 17281번 (야구)
//브루트 포스 + 시뮬레이션 문제
/*문제
⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다. 하나의 이닝은 공격과 수비로 이루어져 있고, 총 N이닝동안 게임을 진행해야 한다. 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.

두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다. 9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다. 타순은 이닝이 변경되어도 순서를 유지해야 한다. 예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.

공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다. 공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다. 타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다. 루에 있는 선수를 주자라고 한다. 이닝이 시작될 때는 주자는 없다.

타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 각각이 발생했을 때, 벌어지는 일은 다음과 같다.

안타: 타자와 모든 주자가 한 루씩 진루한다.
2루타: 타자와 모든 주자가 두 루씩 진루한다.
3루타: 타자와 모든 주자가 세 루씩 진루한다.
홈런: 타자와 모든 주자가 홈까지 진루한다.
아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
한 야구팀의 감독 아인타는 타순을 정하려고 한다. 아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다. 아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 이제 다른 선수의 타순을 모두 결정해야 한다. 아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.

입력
첫째 줄에 이닝 수 N(2 ≤ N ≤ 50)이 주어진다. 둘째 줄부터 N개의 줄에는 각 선수가 각 이닝에서 얻는 결과가 1번 이닝부터 N번 이닝까지 순서대로 주어진다. 이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다. 각 결과가 의미하는 정수는 다음과 같다.

안타: 1
2루타: 2
3루타: 3
홈런: 4
아웃: 0
각 이닝에는 아웃을 기록하는 타자가 적어도 한 명 존재한다.

출력
아인타팀이 얻을 수 있는 최대 점수를 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

public class N_17281 {
	static int[] order = new int[9]; // 타자들의 타순 저장
	static int[] c = new int[10]; // 방문 여부 저장
	static int max_result = -1;

	static void go(int index, int[][] A) {
		if (index == 9) {
			int current_ining = 0;
			int current_num = 0;
			int outNum = 0;
			int result = 0; // 총 점수
			int oneLu = 0;
			int twoLu = 0;
			int threeLu = 0;

			while (true) {
				if (current_ining == A.length)
					break;
				if (A[current_ining][order[current_num]] == 1) {
					if (threeLu == 1) {
						threeLu = 0;
						result++;
					}
					if (twoLu == 1) {
						threeLu = 1;
						twoLu = 0;
					}
					if (oneLu == 1) {
						twoLu = 1;
						oneLu = 0;
					}
					oneLu = 1;
				} else if (A[current_ining][order[current_num]] == 2) {
					if (threeLu == 1) {
						threeLu = 0;
						result++;
					}
					if (twoLu == 1) {
						twoLu = 0;
						result++;
					}
					if (oneLu == 1) {
						threeLu = 1;
						oneLu = 0;
					}
					twoLu = 1;
				} else if (A[current_ining][order[current_num]] == 3) {
					if (threeLu == 1) {
						threeLu = 0;
						result++;
					}
					if (twoLu == 1) {
						twoLu = 0;
						result++;
					}
					if (oneLu == 1) {
						oneLu = 0;
						result++;
					}
					threeLu = 1;
				} else if (A[current_ining][order[current_num]] == 4) {
					if (threeLu == 1) {
						threeLu = 0;
						result++;
					}
					if (twoLu == 1) {
						twoLu = 0;
						result++;
					}
					if (oneLu == 1) {
						oneLu = 0;
						result++;
					}
					result++;
				} else if (A[current_ining][order[current_num]] == 0) {
					outNum++;
				}
				if (outNum == 3) {
					current_ining++; // 이닝 바꿈
					outNum = 0; // 이닝 바꾸면 out 수 초기화(이것 때문에 틀림)
					oneLu = 0;
					twoLu = 0;
					threeLu = 0;
				}
				current_num = (current_num + 1) % 9;
			}
			if (max_result < result) {
				max_result = result;
			}
			return;
		}
		if (index == 3) {
			go(index + 1, A);
		} else {
			for (int i = 2; i <= 9; i++) {
				if (c[i] == 1)
					continue;
				c[i] = 1;
				order[index] = i;
				go(index + 1, A);
				c[i] = 0;
				order[index] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][10];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 9; j++) {
				A[i][j] = s.nextInt();
			}
		}
		order[3] = 1;
		c[1] = 1;
		go(0, A);
		System.out.println(max_result);
	}

}
