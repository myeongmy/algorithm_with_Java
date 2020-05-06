//백준 1022번
//구현 문제 풀이
/*문제
크기가 무한인 정사각형 모눈종이가 있다. 모눈종이의 각 정사각형은 행과 열의 쌍으로 표현할 수 있다.

이 모눈종이 전체를 양의 정수의 소용돌이 모양으로 채울 것이다. 일단 숫자 1을 0행 0열에 쓴다. 그리고 나서 0행 1열에 숫자 2를 쓴다. 거기서 부터 소용돌이는 반시계 방향으로 시작된다. 다음 숫자는 다음과 같이 채우면 된다.

    -3 -2 -1  0  1  2  3
    --------------------
-3 |37 36 35 34 33 32 31
-2 |38 17 16 15 14 13 30
-1 |39 18  5  4  3 12 29
 0 |40 19  6  1  2 11 28
 1 |41 20  7  8  9 10 27
 2 |42 21 22 23 24 25 26
 3 |43 44 45 46 47 48 49
이 문제는 위와 같이 채운 것을 예쁘게 출력하면 된다. r1, c1, r2, c2가 입력으로 주어진다. r1, c1은 가장 왼쪽 위 칸이고, r2, c2는 가장 오른쪽 아래 칸이다.

예쁘게 출력한다는 것은 다음과 같이 출력하는 것이다.

출력은 r1행부터 r2행까지 차례대로 출력한다.
각 원소는 공백으로 구분한다.
모든 행은 같은 길이를 가져야 한다.
공백의 길이는 최소로 해야 한다.
모든 숫자의 길이(앞에 붙는 공백을 포함)는 같아야 한다.
만약 수의 길이가 가장 길이가 긴 수보다 작다면, 왼쪽에서부터 공백을 삽입해 길이를 맞춘다.
입력
첫째 줄에 r1, c1, r2, c2가 주어진다. 모두 절댓값이 5000보다 작거나 같은 정수이고, r2-r1은 0보다 크거나 같고, 49보다 작거나 같으며, c2-c1은 0보다 크거나 같고, 4보다 작거나 같다.

출력
r2-r1+1개의 줄에 소용돌이를 예쁘게 출력한다.*/
//방향: 우->상->좌>하 (dir: 0우, 1상, 2좌, 3하)
//증가: 1122334455

package 백준;

import java.io.*;
import java.util.*;

public class N_1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int r1 = Integer.parseInt(input[0]);
			int c1 = Integer.parseInt(input[1]);
			int r2 = Integer.parseInt(input[2]);
			int c2 = Integer.parseInt(input[3]);

			long[][] A = new long[r2 - r1 + 1][c2 - c1 + 1];
			int row = 0;
			int col = 0;
			if (r1 < 0) {
				row = -r1;
			} else if (r1 > 0) {
				row = -r1;
			} else if (r1 == 0) {
				row = 0;
			}

			if (c1 < 0) {
				col = -c1;
			} else if (c1 > 0) {
				col = -c1;
			} else if (c1 == 0) {
				col = 0;
			}

			int increasing = 1;
			int dir = 0;
			int currentX = 0;
			int currentY = 0;
			long num = 1;
			long max = Long.MIN_VALUE; // 배열에 들어가는 수 중 가장 큰 수 찾기 위함

			if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
				A[currentX + row][currentY + col] = num;
				if (max < num)
					max = num;
			}

			while (Math.abs(currentX) <= 5000 && Math.abs(currentY) <= 5000) {     //<5000이라 해서 틀렸습니다 떳음
				if (dir == 0) {
					for (int i = 0; i < increasing; i++) {
						currentY++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 1) {
					for (int i = 0; i < increasing; i++) {
						currentX--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 2) {
					for (int i = 0; i < increasing; i++) {
						currentY--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 3) {
					for (int i = 0; i < increasing; i++) {
						currentX++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				}

				dir = (dir + 1) % 4;

				if (dir == 0) {
					for (int i = 0; i < increasing; i++) {
						currentY++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 1) {
					for (int i = 0; i < increasing; i++) {
						currentX--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 2) {
					for (int i = 0; i < increasing; i++) {
						currentY--;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				} else if (dir == 3) {
					for (int i = 0; i < increasing; i++) {
						currentX++;
						num++;
						if (r1 <= currentX && currentX <= r2 && c1 <= currentY && currentY <= c2) {
							A[currentX + row][currentY + col] = num;
							if (max < num)
								max = num;
						}
					}
				}

				dir = (dir + 1) % 4;
				increasing++;
			}
			int cnt = Long.toString(max).length();

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if(j == A[0].length - 1)
						System.out.printf("%" + cnt + "d", A[i][j]);
					else
						System.out.printf("%" + cnt + "d ", A[i][j]);
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
