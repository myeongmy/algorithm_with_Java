//백준 17136번 (색종이 붙이기)
//브루트 포스 문제

package 삼성SW역량테스트기출;

import java.util.*;

/*class Point {
	int i;
	int j;

	Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}*/

public class N_17136_v2 {
	static int[][] c = new int[10][10];
	static ArrayList<Point> list;
	static int min = 30;

	static void go(int index, int[][] A, int[] cnt) {
		if (index == list.size()) {
			int sum = cnt[1] + cnt[2] + cnt[3] + cnt[4] + cnt[5];
			if (min > sum)
				min = sum;
			return;
		}

		int i = list.get(index).i;
		int j = list.get(index).j;
		if (c[i][j] == 1)
			go(index + 1, A, cnt);
		else {
			// 5x5
			if (c[i][j] == 0 && cnt[5] < 5 && i + 4 < 10 && j + 4 < 10 && A[i][j + 1] == 1 && A[i][j + 2] == 1
					&& A[i][j + 3] == 1 && A[i][j + 4] == 1 && A[i + 1][j] == 1 && A[i + 1][j + 1] == 1
					&& A[i + 1][j + 2] == 1 && A[i + 1][j + 3] == 1 && A[i + 1][j + 4] == 1 && A[i + 2][j] == 1
					&& A[i + 2][j + 1] == 1 && A[i + 2][j + 2] == 1 && A[i + 2][j + 3] == 1 && A[i + 2][j + 4] == 1
					&& A[i + 3][j] == 1 && A[i + 3][j + 1] == 1 && A[i + 3][j + 2] == 1 && A[i + 3][j + 3] == 1
					&& A[i + 3][j + 4] == 1 && A[i + 4][j] == 1 && A[i + 4][j + 1] == 1 && A[i + 4][j + 2] == 1
					&& A[i + 4][j + 3] == 1 && A[i + 4][j + 4] == 1 && c[i][j + 1] == 0 && c[i][j + 2] == 0
					&& c[i][j + 3] == 0 && c[i][j + 4] == 0 && c[i + 1][j] == 0 && c[i + 1][j + 1] == 0
					&& c[i + 1][j + 2] == 0 && c[i + 1][j + 3] == 0 && c[i + 1][j + 4] == 0 && c[i + 2][j] == 0
					&& c[i + 2][j + 1] == 0 && c[i + 2][j + 2] == 0 && c[i + 2][j + 3] == 0 && c[i + 2][j + 4] == 0
					&& c[i + 3][j] == 0 && c[i + 3][j + 1] == 0 && c[i + 3][j + 2] == 0 && c[i + 3][j + 3] == 0
					&& c[i + 3][j + 4] == 0 && c[i + 4][j] == 0 && c[i + 4][j + 1] == 0 && c[i + 4][j + 2] == 0
					&& c[i + 4][j + 3] == 0 && c[i + 4][j + 4] == 0) {
				cnt[5]++;
				c[i][j] = 1;
				c[i][j + 1] = 1;
				c[i][j + 2] = 1;
				c[i][j + 3] = 1;
				c[i][j + 4] = 1;
				c[i + 1][j] = 1;
				c[i + 1][j + 1] = 1;
				c[i + 1][j + 2] = 1;
				c[i + 1][j + 3] = 1;
				c[i + 1][j + 4] = 1;
				c[i + 2][j] = 1;
				c[i + 2][j + 1] = 1;
				c[i + 2][j + 2] = 1;
				c[i + 2][j + 3] = 1;
				c[i + 2][j + 4] = 1;
				c[i + 3][j] = 1;
				c[i + 3][j + 1] = 1;
				c[i + 3][j + 2] = 1;
				c[i + 3][j + 3] = 1;
				c[i + 3][j + 4] = 1;
				c[i + 4][j] = 1;
				c[i + 4][j + 1] = 1;
				c[i + 4][j + 2] = 1;
				c[i + 4][j + 3] = 1;
				c[i + 4][j + 4] = 1;
				go(index + 1, A, cnt);
				cnt[5] -= 1;
				c[i][j] = 0;
				c[i][j + 1] = 0;
				c[i][j + 2] = 0;
				c[i][j + 3] = 0;
				c[i][j + 4] = 0;
				c[i + 1][j] = 0;
				c[i + 1][j + 1] = 0;
				c[i + 1][j + 2] = 0;
				c[i + 1][j + 3] = 0;
				c[i + 1][j + 4] = 0;
				c[i + 2][j] = 0;
				c[i + 2][j + 1] = 0;
				c[i + 2][j + 2] = 0;
				c[i + 2][j + 3] = 0;
				c[i + 2][j + 4] = 0;
				c[i + 3][j] = 0;
				c[i + 3][j + 1] = 0;
				c[i + 3][j + 2] = 0;
				c[i + 3][j + 3] = 0;
				c[i + 3][j + 4] = 0;
				c[i + 4][j] = 0;
				c[i + 4][j + 1] = 0;
				c[i + 4][j + 2] = 0;
				c[i + 4][j + 3] = 0;
				c[i + 4][j + 4] = 0;
			}
			// 4x4
			if (c[i][j] == 0 && cnt[4] < 5 && i + 3 < 10 && j + 3 < 10 && A[i][j + 1] == 1 && A[i][j + 2] == 1
					&& A[i][j + 3] == 1 && A[i + 1][j] == 1 && A[i + 1][j + 1] == 1 && A[i + 1][j + 2] == 1
					&& A[i + 1][j + 3] == 1 && A[i + 2][j] == 1 && A[i + 2][j + 1] == 1 && A[i + 2][j + 2] == 1
					&& A[i + 2][j + 3] == 1 && A[i + 3][j] == 1 && A[i + 3][j + 1] == 1 && A[i + 3][j + 2] == 1
					&& A[i + 3][j + 3] == 1 && c[i][j + 1] == 0 && c[i][j + 2] == 0 && c[i][j + 3] == 0
					&& c[i + 1][j] == 0 && c[i + 1][j + 1] == 0 && c[i + 1][j + 2] == 0 && c[i + 1][j + 3] == 0
					&& c[i + 2][j] == 0 && c[i + 2][j + 1] == 0 && c[i + 2][j + 2] == 0 && c[i + 2][j + 3] == 0
					&& c[i + 3][j] == 0 && c[i + 3][j + 1] == 0 && c[i + 3][j + 2] == 0 && c[i + 3][j + 3] == 0) {
				cnt[4]++;
				c[i][j] = 1;
				c[i][j + 1] = 1;
				c[i][j + 2] = 1;
				c[i][j + 3] = 1;
				c[i + 1][j] = 1;
				c[i + 1][j + 1] = 1;
				c[i + 1][j + 2] = 1;
				c[i + 1][j + 3] = 1;
				c[i + 2][j] = 1;
				c[i + 2][j + 1] = 1;
				c[i + 2][j + 2] = 1;
				c[i + 2][j + 3] = 1;
				c[i + 3][j] = 1;
				c[i + 3][j + 1] = 1;
				c[i + 3][j + 2] = 1;
				c[i + 3][j + 3] = 1;
				go(index + 1, A, cnt);
				cnt[4] -= 1;
				c[i][j] = 0;
				c[i][j + 1] = 0;
				c[i][j + 2] = 0;
				c[i][j + 3] = 0;
				c[i + 1][j] = 0;
				c[i + 1][j + 1] = 0;
				c[i + 1][j + 2] = 0;
				c[i + 1][j + 3] = 0;
				c[i + 2][j] = 0;
				c[i + 2][j + 1] = 0;
				c[i + 2][j + 2] = 0;
				c[i + 2][j + 3] = 0;
				c[i + 3][j] = 0;
				c[i + 3][j + 1] = 0;
				c[i + 3][j + 2] = 0;
				c[i + 3][j + 3] = 0;
			}
			// 3x3
			if (c[i][j] == 0 && cnt[3] < 5 && i + 2 < 10 && j + 2 < 10 && A[i][j + 1] == 1 && A[i][j + 2] == 1
					&& A[i + 1][j] == 1 && A[i + 1][j + 1] == 1 && A[i + 1][j + 2] == 1 && A[i + 2][j] == 1
					&& A[i + 2][j + 1] == 1 && A[i + 2][j + 2] == 1 && c[i][j + 1] == 0 && c[i][j + 2] == 0
					&& c[i + 1][j] == 0 && c[i + 1][j + 1] == 0 && c[i + 1][j + 2] == 0 && c[i + 2][j] == 0
					&& c[i + 2][j + 1] == 0 && c[i + 2][j + 2] == 0) {
				cnt[3]++;

				c[i][j] = 1;
				c[i][j + 1] = 1;
				c[i][j + 2] = 1;
				c[i + 1][j] = 1;
				c[i + 1][j + 1] = 1;
				c[i + 1][j + 2] = 1;
				c[i + 2][j] = 1;
				c[i + 2][j + 1] = 1;
				c[i + 2][j + 2] = 1;
				go(index + 1, A, cnt);
				cnt[3] -= 1;
				c[i][j] = 0;
				c[i][j + 1] = 0;
				c[i][j + 2] = 0;
				c[i + 1][j] = 0;
				c[i + 1][j + 1] = 0;
				c[i + 1][j + 2] = 0;
				c[i + 2][j] = 0;
				c[i + 2][j + 1] = 0;
				c[i + 2][j + 2] = 0;
			}
			// 2x2
			if (c[i][j] == 0 && cnt[2] < 5 && i + 1 < 10 && j + 1 < 10 && A[i][j + 1] == 1 && A[i + 1][j] == 1
					&& A[i + 1][j + 1] == 1 && c[i][j + 1] == 0 && c[i + 1][j] == 0 && c[i + 1][j + 1] == 0) {
				cnt[2]++;

				c[i][j] = 1;
				c[i][j + 1] = 1;
				c[i + 1][j] = 1;
				c[i + 1][j + 1] = 1;
				go(index + 1, A, cnt);
				cnt[2] -= 1;
				c[i][j] = 0;
				c[i][j + 1] = 0;
				c[i + 1][j] = 0;
				c[i + 1][j + 1] = 0;
			}
			// 1x1
			if (c[i][j] == 0 && cnt[1] < 5) {
				cnt[1]++;
				c[i][j] = 1;
				go(index + 1, A, cnt);
				cnt[1] -= 1;
				c[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[][] A = new int[10][10];
		list = new ArrayList<Point>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				A[i][j] = s.nextInt();
				if (A[i][j] == 1)
					list.add(new Point(i, j));
			}
		}
		int[] cnt = new int[6];
		go(0, A, cnt);
		if (min == 30) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(min);
	}

}
