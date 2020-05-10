//2048 문제 - 완전탐색

package 코딩테스트;

//완전탐색
import java.util.*;

class Solution13 {
	static int[] result = new int[5];
	static int total_max = Integer.MIN_VALUE;

	static void go(int index, int[][] board) {
		if (index == 5) {
			// board 배열 복사
			int[][] A = new int[board.length][board[0].length];
			for (int i = 0; i < A.length; i++)
				A[i] = board[i].clone();

			for (int i = 0; i < 5; i++) {
				int[][] c = new int[A.length][A[0].length]; // 합쳐졌는지 여부 저장
				if (result[i] == 0) { // 상
					for (int j = 1; j < A.length; j++) {

						for (int k = 0; k < A[0].length; k++) {
							int nextj = j;
							while (true) {
								if (nextj - 1 < 0 || A[nextj - 1][k] != 0)
									break;
								nextj--;
							}

							if (nextj != j) {
								A[nextj][k] = A[j][k];
								A[j][k] = 0;
							}

							if (nextj - 1 >= 0 && A[nextj][k] == A[nextj - 1][k] && c[nextj - 1][k] == 0) {
								A[nextj - 1][k] = A[nextj - 1][k] * 2;
								A[nextj][k] = 0;
								c[nextj - 1][k] = 1;
							}
						}
					}
				} else if (result[i] == 1) { // 하
					for (int j = A.length - 2; j >= 0; j--) {
						for (int k = 0; k < A[0].length; k++) {
							int nextj = j;

							while (true) {
								if (nextj + 1 >= A.length || A[nextj + 1][k] != 0)
									break;
								nextj++;
							}

							if (nextj != j) {
								A[nextj][k] = A[j][k];
								A[j][k] = 0;
							}

							if (nextj + 1 < A.length && A[nextj][k] == A[nextj + 1][k] && c[nextj + 1][k] == 0) {
								A[nextj + 1][k] = A[nextj + 1][k] * 2;
								A[nextj][k] = 0;
								c[nextj + 1][k] = 1;
							}
						}
					}
				} else if (result[i] == 2) { // 좌
					for (int j = 1; j < A[0].length; j++) {
						for (int k = 0; k < A.length; k++) {
							int nextj = j;

							while (true) {
								if (nextj - 1 < 0 || A[k][nextj - 1] != 0)
									break;
								nextj--;
							}

							if (nextj != j) {
								A[k][nextj] = A[k][j];
								A[k][j] = 0;
							}

							if (nextj - 1 >= 0 && A[k][nextj] == A[k][nextj - 1] && c[k][nextj - 1] == 0) {
								A[k][nextj - 1] = A[k][nextj - 1] * 2;
								A[k][nextj] = 0;
								c[k][nextj - 1] = 1;
							}
						}
					}

				} else if (result[i] == 3) { // 우
					for (int j = A[0].length - 2; j >= 0; j--) {
						for (int k = 0; k < A.length; k++) {
							int nextj = j;

							while (true) {
								if (nextj + 1 >= A[0].length || A[k][nextj + 1] != 0)
									break;
								nextj++;
							}

							if (nextj != j) {
								A[k][nextj] = A[k][j];
								A[k][j] = 0;
							}

							if (nextj + 1 < A[0].length && A[k][nextj] == A[k][nextj + 1] && c[k][nextj + 1] == 0) {
								A[k][nextj + 1] = A[k][nextj + 1] * 2;
								A[k][nextj] = 0;
								c[k][nextj + 1] = 1;
							}
						}
					}
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					if (max < A[i][j])
						max = A[i][j];
				}
			}

			if (total_max < max)
				total_max = max;
			return;
		}
		for (int i = 0; i < 4; i++) {
			result[index] = i;
			go(index + 1, board);
			result[index] = 0;
		}
	}

	int solution(int[][] board) {
		int answer = -1;
		go(0, board);
		answer = total_max;
		return answer;
	}
}

public class HyundaiITE_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 2, 4, 8, 2 }, { 2, 2, 2, 2 }, { 0, 4, 2, 4 }, { 2, 2, 2, 4 } };
		System.out.println(new Solution13().solution(board));
	}

}
