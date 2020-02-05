//백준 14503번(로봇 청소기)
//구현, 시뮬레이션 문제
/*문제
로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.

로봇 청소기는 다음과 같이 작동한다.

현재 위치를 청소한다.
현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

입력
첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 장소의 모든 외곽은 벽이다.

로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.

출력
로봇 청소기가 청소하는 칸의 개수를 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

public class N_14503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] A = new int[N][M];

		int x = s.nextInt(); // 현재 로봇 청소기의 위치, 방향
		int y = s.nextInt();
		int dir = s.nextInt(); // 0: 북쪽, 1: 동쪽, 2:남쪽, 3:서쪽

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				A[i][j] = s.nextInt();
		}
		A[x][y] = 2; // 현재 위치 청소
		int turn = 0;
		int cleaning = 0;
		cleaning++;
		while (true) {
			if (turn == 4) { // c번 조건
				
				if (dir == 0) {
					if (x + 1 >= N || A[x+1][y] == 1)
						break;
					x = x + 1;
					turn = 0;     //turn 초기화 꼭 필요!!
					continue;
				} else if (dir == 1) {
					if (y - 1 < 0 || A[x][y-1] == 1)
						break;
					y = y - 1;
					turn = 0;
					continue;
				} else if (dir == 2) {
					if (x - 1 < 0 || A[x-1][y] == 1)
						break;
					x = x - 1;
					turn = 0;
					continue;
				} else {
					if (y + 1 >= M || A[x][y+1]== 1)
						break;
					y = y + 1;
					turn = 0;
					continue;
				}

			}
			if (dir == 0) {
				if (y - 1 >= 0 && A[x][y - 1] == 0) { // a번 조건 만족
					dir = 3;
					y = y - 1;
					A[x][y] = 2;
					cleaning++;
					turn = 0;    //여기서도 초기화 해주어야함. 오류의 원인!
					continue;
				} else { // b번 조건
					dir = 3;
					turn++;
					continue;
				}

			} else if (dir == 1) {
				if (x - 1 >= 0 && A[x - 1][y] == 0) {
					dir = 0;
					x = x - 1;
					A[x][y] = 2;
					cleaning++;
					turn = 0;
					continue;
				} else {
					dir = 0;
					turn++;
					continue;
				}
			} else if (dir == 2) {
				if (y + 1 < M && A[x][y + 1] == 0) {
					dir = 1;
					y = y + 1;
					A[x][y] = 2;
					cleaning++;
					turn = 0;
					continue;
				} else {
					dir = 1;
					turn++;
					continue;
				}
			} else {
				if (x + 1 < N && A[x + 1][y] == 0) {
					dir = 2;
					x = x + 1;
					A[x][y] = 2;
					cleaning++;
					turn = 0;
					continue;
				} else {
					dir = 2;
					turn++;
					continue;
				}
			}
		}
		System.out.println(cleaning);
		
	}

}
