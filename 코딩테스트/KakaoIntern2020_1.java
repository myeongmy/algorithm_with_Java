package 코딩테스트;

//BFS+시뮬레이션
import java.util.*;

public class KakaoIntern2020_1 {
	static class Point {
		int x;
		int y;
		int cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static char[][] arr = new char[4][3];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void putValueIntoArray() {
		arr[0][0] = '1';
		arr[0][1] = '2';
		arr[0][2] = '3';
		arr[1][0] = '4';
		arr[1][1] = '5';
		arr[1][2] = '6';
		arr[2][0] = '7';
		arr[2][1] = '8';
		arr[2][2] = '9';
		arr[3][0] = '*';
		arr[3][1] = '0';
		arr[3][2] = '#';
	}

	static int bfs(int x, int y, int target) {
		Queue<Point> q = new LinkedList<Point>();
		int[][] c = new int[4][3];

		c[x][y] = 1;
		q.offer(new Point(x, y, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (arr[p.x][p.y] == Integer.toString(target).charAt(0)) {
				return p.cnt;
			}

			for (int i = 0; i < dx.length; i++) {
				if (p.x + dx[i] >= 0 && p.x + dx[i] < 4 && p.y + dy[i] >= 0 && p.y + dy[i] < 3) {
					if (c[p.x + dx[i]][p.y + dy[i]] == 0) {
						q.offer(new Point(p.x + dx[i], p.y + dy[i], p.cnt + 1));
						c[p.x + dx[i]][p.y + dy[i]] = 1;
					}
				}
			}
		}
		return 0;
	}

	public String solution(int[] numbers, String hand) {
		String answer = "";
		putValueIntoArray();
		int leftX = 3; // 왼손 현재 위치
		int leftY = 0;
		int rightX = 3; // 오른손 현재 위치
		int rightY = 2;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				leftX = (numbers[i] - 1) / 3;
				leftY = (numbers[i] - 1) % 3;

				answer += "L";
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				rightX = (numbers[i] - 1) / 3;
				rightY = (numbers[i] - 1) % 3;

				answer += "R";
			} else {
				// 왼손 Bfs
				int leftDist = bfs(leftX, leftY, numbers[i]);
				// 오른손 Bfs
				int rightDist = bfs(rightX, rightY, numbers[i]);

				if (leftDist < rightDist) {
					answer += "L";

					if (numbers[i] == 0) {
						leftX = 3;
						leftY = 1;
						continue;
					}
					leftX = (numbers[i] - 1) / 3;
					leftY = (numbers[i] - 1) % 3;
				} else if (rightDist < leftDist) {
					answer += "R";

					if (numbers[i] == 0) {
						rightX = 3;
						rightY = 1;
						continue;
					}
					rightX = (numbers[i] - 1) / 3;
					rightY = (numbers[i] - 1) % 3;
				} else {
					if (hand.equals("left")) {
						answer += "L";

						if (numbers[i] == 0) {
							leftX = 3;
							leftY = 1;
							continue;
						}
						leftX = (numbers[i] - 1) / 3;
						leftY = (numbers[i] - 1) % 3;
					} else if (hand.equals("right")) {
						answer += "R";

						if (numbers[i] == 0) {
							rightX = 3;
							rightY = 1;
							continue;
						}
						rightX = (numbers[i] - 1) / 3;
						rightY = (numbers[i] - 1) % 3;
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(new KakaoIntern2020_1().solution(numbers, hand));
	}
}
