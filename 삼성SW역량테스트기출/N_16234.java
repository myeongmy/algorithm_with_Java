//백준 16234번(인구이동)
//dfs 문제
/*문제
N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.

오늘부터 인구 이동이 시작되는 날이다.

인구 이동은 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.

국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루동안 연다.
위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
연합을 해체하고, 모든 국경선을 닫는다.
각 나라의 인구수가 주어졌을 때, 인구 이동이 몇 번 발생하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)

둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (1 ≤ A[r][c] ≤ 100)

인구 이동이 발생하는 횟수가 2,000번 보다 작거나 같은 입력만 주어진다.

출력
인구 이동이 몇 번 발생하는지 첫째 줄에 출력한다.*/

package 삼성SW역량테스트기출;

import java.util.*;

class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class N_16234 {
	static ArrayList<Point> list = new ArrayList<Point>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int L;
	static int R;

	static void dfs(int i, int j, int[][] A, int[][] c) {
		c[i][j] = 1;
		list.add(new Point(i, j));

		for (int k = 0; k < dx.length; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < A.length && j + dy[k] >= 0 && j + dy[k] < A.length) {
				if (Math.abs(A[i][j] - A[i + dx[k]][j + dy[k]]) >= L && Math.abs(A[i][j] - A[i + dx[k]][j + dy[k]]) <= R
						&& c[i + dx[k]][j + dy[k]] == 0) {
					dfs(i + dx[k], j + dy[k], A, c);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		L = s.nextInt();
		R = s.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = s.nextInt();
			}
		}
		int moving = 0;
		int flag = 0;
		while (true) {
			int[][] c = new int[N][N];
			int lastMoving = moving;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (c[i][j] == 0) {
						dfs(i, j, A, c);
						if (list.size() > 1) {
							int sum = 0;
							for (int k = 0; k < list.size(); k++) {
								sum += A[list.get(k).i][list.get(k).j];
							}
							sum = sum / list.size();
							for (int k = 0; k < list.size(); k++) {
								A[list.get(k).i][list.get(k).j] = sum;
							}
							flag = 1;
						}
						list.clear();
					}
				}
			}
			if(flag == 1) moving++;
			flag = 0;
			if (lastMoving == moving)
				break;
		}
		System.out.println(moving);
	}

}
