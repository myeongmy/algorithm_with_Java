package 프로그래머스;

//브루트 포스(시뮬레이션)
/*
1. 열쇠를 네 방향으로 회전하면서
2. 열쇠가 올 수 있는 위치를 모두 탐색하면서 가능하면 stop
*/

class Solution {
	static void clockwise(int[][] key) {
		int[][] temp = new int[key.length][key.length];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = key[(key.length - 1) - j][i];
			}
		}

		for (int i = 0; i < temp.length; i++)
			key[i] = temp[i].clone();
	}

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		// 자물쇠 홈의 개수 세기
		int hom = 0;
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				if (lock[i][j] == 0)
					hom++;
			}
		}
		Label1: for (int i = 0; i < 4; i++) {
			if (i != 0)
				clockwise(key);

			// 시작점 찾기
			for (int j = -(key.length - 1); j < lock.length + (key.length - 1); j++) {
				for (int k = -(key.length - 1); k < lock.length + (key.length - 1); k++) {
					// 시작점 (j, k)에 대해
					int cnt = 0;
					Label: for (int m = j; m < j + key.length; m++) {
						for (int n = k; n < k + key.length; n++) {
							if (m >= 0 && m < lock.length && n >= 0 && n < lock.length) {
								if (lock[m][n] == 0 && key[m - j][n - k] == 1)
									cnt++; // 채운 홈의 개수
								if (lock[m][n] == 0 && key[m - j][n - k] == 0)
									continue Label;
								if (lock[m][n] == 1 && key[m - j][n - k] == 1)
									continue Label;
							}
						}
					}
					if (hom == cnt) {
						answer = true;
						break Label1;
					}

				}
			}
		}
		return answer;
	}
}
