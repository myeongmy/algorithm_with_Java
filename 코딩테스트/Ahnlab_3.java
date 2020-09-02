package 코딩테스트;

import java.util.*;

class Ahnlab_3 {
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1 };

	public int solution(String[] bishops) {
		int answer = 0;

		int[][] A = new int[8][8]; // 1은 비숍이 이동할 수 있는 칸, 0은 이동할 수 없는 칸
		for (int i = 0; i < bishops.length; i++) {
			int si = bishops[i].charAt(0) - 65;
			int sj = bishops[i].charAt(1) - 48 - 1;
			A[si][sj] = 1;

			for (int j = 0; j < dx.length; j++) {
				int k = 1;
				while (si + (dx[j] * k) >= 0 && si + (dx[j] * k) < 8 && sj + (dy[j] * k) >= 0 && sj + (dy[j] * k) < 8) {
					A[si + (dx[j] * k)][sj + (dy[j] * k)] = 1;
					k++;
				}
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (A[i][j] == 0)
					answer++;
			}
		}
		return answer;
	}
}
