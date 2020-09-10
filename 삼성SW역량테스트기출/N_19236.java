//백준 19236번 청소년 상어
//dfs + 시뮬레이션

package 삼성SW역량테스트기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_19236 {
	static class Fish {
		int i;
		int j;
		int dir;

		Fish(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}

	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = Integer.MIN_VALUE;

	static void dfs(int i, int j, int[][] A, Fish[] fishArr, int num) {

		int[][] B = new int[4][4];
		for (int k = 0; k < B.length; k++)
			B[k] = A[k].clone();

		Fish[] fishArr2 = new Fish[fishArr.length];
		for (int k = 1; k <= 16; k++) {
			if (fishArr[k] != null)
				fishArr2[k] = new Fish(fishArr[k].i, fishArr[k].j, fishArr[k].dir);
		}

		// 상어가 잡아 먹는다.
		int ateNum = B[i][j];
		B[i][j] = 0;
		int sharkDir = fishArr2[ateNum].dir;
		fishArr2[ateNum] = null;

		if (max < num + ateNum)
			max = num + ateNum;

		// 1.물고기가 번호가 작은 물고기부터 순서대로 이동
		for (int n = 1; n <= 16; n++) {
			if (fishArr2[n] == null)
				continue;

			int sDir = fishArr2[n].dir;
			int si = fishArr2[n].i;
			int sj = fishArr2[n].j;
			int rotationNum = 0;

			while (true) { // 이동할 곳을 찾을 때까지 반복
				if (rotationNum >= 8)
					break;
				// 이동할 수 없는 칸일 때
				if (si + dx[sDir] < 0 || si + dx[sDir] >= 4 || sj + dy[sDir] < 0 || sj + dy[sDir] >= 4
						|| (si + dx[sDir] == i && sj + dy[sDir] == j)) {
					sDir = sDir % 8 + 1;
					rotationNum++;
				}
				// 이동할 수 있는 칸일 때
				else {
					int changeNum = B[si + dx[sDir]][sj + dy[sDir]];
					// 배열 A 업데이트
					B[si][sj] = changeNum;
					B[si + dx[sDir]][sj + dy[sDir]] = n;
					// 배열 fishArr 업데이트
					fishArr2[n].i = si + dx[sDir];
					fishArr2[n].j = sj + dy[sDir];
					fishArr2[n].dir = sDir;
					if (changeNum != 0) {
						fishArr2[changeNum].i = si;
						fishArr2[changeNum].j = sj;
					}

					break;
				}
			}

		}

		// 2.상어의 이동
		int si = i + dx[sharkDir];
		int sj = j + dy[sharkDir];

		while (si >= 0 && si < 4 && sj >= 0 && sj < 4) {
			if (B[si][sj] != 0) {
				dfs(si, sj, B, fishArr2, num + ateNum);
			}

			si += dx[sharkDir];
			sj += dy[sharkDir];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int[][] A = new int[4][4]; // 물고기의 번호 저장
			Fish[] fishArr = new Fish[17];

			// 물고기 정보 저장
			for (int i = 0; i < 4; i++) {
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < arr.length; j += 2) {
					A[i][j / 2] = Integer.parseInt(arr[j]);
					fishArr[Integer.parseInt(arr[j])] = new Fish(i, j / 2, Integer.parseInt(arr[j + 1]));
				}
			}

			// 상어 처음 위치
			dfs(0, 0, A, fishArr, 0);
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
