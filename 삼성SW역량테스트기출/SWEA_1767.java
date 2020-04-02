//[SW Test 샘플문제] 프로세서 연결하기
//브루트 포스 문제
/*삼성에서 개발한 최신 모바일 프로세서 멕시노스는 가로 N개 x 세로 N개의 cell로 구성되어 있다.



1개의 cell에는 1개의 Core 혹은 1개의 전선이 올 수 있다.


멕시노스의 가장 자리에는 전원이 흐르고 있다.

Core와 전원을 연결하는 전선은 직선으로만 설치가 가능하며,


전선은 절대로 교차해서는 안 된다.

초기 상태로는 아래와 같이 전선을 연결하기 전 상태의 멕시노스 정보가 주어진다.


(멕시노스의 가장자리에 위치한 Core는 이미 전원이 연결된 것으로 간주한다.)





▶ 최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.

   단, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라.

위 예제의 정답은 12가 된다.



[제약 사항]

1. 7 ≤  N ≤ 12

2. Core의 개수는 최소 1개 이상 12개 이하이다.

3. 최대한 많은 Core에 전원을 연결해도, 전원이 연결되지 않는 Core가 존재할 수 있다.



[입력]

입력의 가장 첫 줄에는 총 테스트 케이스의 개수 T가 주어지며 그 다음 줄부터 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 줄에는 N값이 주어지며, 다음 N줄에 걸쳐서 멕시노스의 초기 상태가 N x N 배열로 주어진다.

0은 빈 cell을 의미하며, 1은 core를 의미하고, 그 외의 숫자는 주어지지 않는다.



[출력]

각 테스트 케이스마다 '#X'를 찍고, 한 칸 띄고, 정답을 출력한다.

(X는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/

package 삼성SW역량테스트기출;

import java.util.*;
import java.io.*;

public class SWEA_1767 {
	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[][] A;
	static int[][] c; // 방문 여부 저장
	static ArrayList<Point> cell = new ArrayList<Point>(); // 전선을 연결해야할 cell 모임
	static int connectedCell = 0;
	static int length = 0;
	static int max = Integer.MIN_VALUE;
	static int min_length = Integer.MAX_VALUE;

	static boolean check_up(int index, int j) {
		for (int i = 0; i <= index; i++) {
			if (A[i][j] != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean check_down(int index, int j) {
		for (int i = index; i < A.length; i++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean check_left(int index, int i) {
		for (int j = 0; j <= index; j++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean check_right(int index, int i) {
		for (int j = index; j < A.length; j++) {
			if (A[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_up(int index, int j) {
		for (int i = 0; i <= index; i++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_down(int index, int j) {
		for (int i = index; i < A.length; i++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_left(int index, int i) {
		for (int j = 0; j <= index; j++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static boolean visited_right(int index, int i) {
		for (int j = index; j < A.length; j++) {
			if (c[i][j] != 0)
				return false;
		}
		return true;
	}

	static void go(int index) {
		if (index == cell.size()) {
			if (max < connectedCell) { // 연결된 cell 개수가 가장 클 때의 길이를 저장하고
				max = connectedCell;
				min_length = length;
			} else if (max == connectedCell) { // 같을 때만 길이끼리 비교
				if (min_length > length)
					min_length = length;
			}
			return;
		}
		// 상
		if (check_up(cell.get(index).i - 1, cell.get(index).j)) {
			if (visited_up(cell.get(index).i - 1, cell.get(index).j)) {
				for (int i = 0; i < cell.get(index).i; i++) {
					c[i][cell.get(index).j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int i = 0; i < cell.get(index).i; i++) {
					c[i][cell.get(index).j] = 0;
					length--;
				}
			}
		}
		// 하
		if (check_down(cell.get(index).i + 1, cell.get(index).j)) {
			if (visited_down(cell.get(index).i + 1, cell.get(index).j)) {
				for (int i = cell.get(index).i + 1; i < A.length; i++) {
					c[i][cell.get(index).j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int i = cell.get(index).i + 1; i < A.length; i++) {
					c[i][cell.get(index).j] = 0;
					length--;
				}
			}
		}
		// 좌
		if (check_left(cell.get(index).j - 1, cell.get(index).i)) {
			if (visited_left(cell.get(index).j - 1, cell.get(index).i)) {
				for (int j = 0; j < cell.get(index).j; j++) {
					c[cell.get(index).i][j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int j = 0; j < cell.get(index).j; j++) {
					c[cell.get(index).i][j] = 0;
					length--;
				}
			}
		}
		// 우
		if (check_right(cell.get(index).j + 1, cell.get(index).i)) {
			if (visited_right(cell.get(index).j + 1, cell.get(index).i)) {
				for (int j = cell.get(index).j + 1; j < A.length; j++) {
					c[cell.get(index).i][j] = 1;
					length++;
				}
				connectedCell++;
				go(index + 1);
				connectedCell--;
				for (int j = cell.get(index).j + 1; j < A.length; j++) {
					c[cell.get(index).i][j] = 0;
					length--;
				}
			}
		}
		// 안 놓고 넘어가는 경우 (총 다섯 가지 경우의 수)
		go(index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());

				A = new int[N][N];
				c = new int[N][N];
				for (int j = 0; j < N; j++) {
					String[] arr = br.readLine().split(" ");
					for (int k = 0; k < N; k++) {
						A[j][k] = Integer.parseInt(arr[k]);
						if (A[j][k] == 1 && j != 0 && j != N - 1 && k != 0 && k != N - 1)
							cell.add(new Point(j, k));
					}
				}

				go(0);
				System.out.println("#" + (i + 1) + " " + min_length);
				max = Integer.MIN_VALUE;
				min_length = Integer.MAX_VALUE;
				cell.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
